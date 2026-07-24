class Account {
    private final String name;
    private double balance;

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }
    public synchronized double getBalance() { return balance; }

    // Package-private raw operations (called only while holding the lock externally)
    void withdraw(double amount) { balance -= amount; }
    void deposit(double amount) { balance += amount; }
}

class TransferThread extends Thread {
    private Account from;
    private Account to;
    private double amount;

    TransferThread(String threadName, Account from, Account to, double amount) {
        super(threadName);
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        // FIX 1: Always lock accounts in a consistent global order
        // (e.g., alphabetical by name) no matter the transfer direction.
        Account first, second;
        if (from.getName().compareTo(to.getName()) < 0) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {
                try {
                    // FIX 2: Wait if insufficient balance, instead of failing.
                    while (from.getBalance() < amount) {
                        System.out.println(getName() + ": insufficient balance in " +
                                from.getName() + " (" + from.getBalance() +
                                "). Waiting for deposit...");
                        // wait() releases the monitor of the object it's called on.
                        // Since we're inside synchronized(first) and synchronized(second),
                        // we wait on "from" specifically so a deposit-notify on "from" wakes us.
                        from.wait();
                    }

                    from.withdraw(amount);
                    to.deposit(amount);

                    System.out.println(getName() + " transferred " + amount +
                            " from " + from.getName() + " to " + to.getName() +
                            " | New balances -> " + from.getName() + ": " + from.getBalance() +
                            ", " + to.getName() + ": " + to.getBalance());

                    // Notify any threads waiting on "to" (e.g., someone was waiting
                    // for a deposit into "to")
                    to.notifyAll();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

// A helper thread to simulate an external deposit that wakes up a waiting transfer
class DepositThread extends Thread {
    private Account account;
    private double amount;
    private int delayMs;

    DepositThread(Account account, double amount, int delayMs) {
        this.account = account;
        this.amount = amount;
        this.delayMs = delayMs;
    }

    public void run() {
        try {
            Thread.sleep(delayMs);
        } catch (InterruptedException e) {}

        synchronized (account) {
            account.deposit(amount);
            System.out.println("DepositThread: deposited " + amount + " into " +
                    account.getName() + " | New balance: " + account.getBalance());
            account.notifyAll(); // wake up any thread waiting on this account
        }
    }
}

public class BankTransferFixedDemo {
    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("Account-A", 1000);
        Account accountB = new Account("Account-B", 100); // low balance on purpose

        // Transfer 1: A -> B, 200 (should succeed immediately)
        Thread t1 = new TransferThread("Transfer-A-to-B", accountA, accountB, 200);

        // Transfer 2: B -> A, 300 (B only has 100 -> will need to WAIT for a deposit)
        Thread t2 = new TransferThread("Transfer-B-to-A", accountB, accountA, 300);

        // Deposit into B after 1 second, so t2 can eventually proceed
        Thread depositor = new DepositThread(accountB, 500, 1000);

        t1.start();
        t2.start();
        depositor.start();

        t1.join();
        t2.join();
        depositor.join();

        System.out.println("Final balances -> " + accountA.getName() + ": " +
                accountA.getBalance() + ", " + accountB.getName() + ": " + accountB.getBalance());
    }
}