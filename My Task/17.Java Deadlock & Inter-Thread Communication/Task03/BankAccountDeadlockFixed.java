class Account {
    private String name;
    private double balance;

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }
    public void withdraw(double amt) { balance -= amt; }
    public void deposit(double amt) { balance += amt; }
}

class TransferThread extends Thread {
    private Account from, to;
    private double amount;

    TransferThread(String threadName, Account from, Account to, double amount) {
        super(threadName);
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        // FIX: Determine a consistent lock order for ALL threads,
        // e.g., alphabetically by account name, instead of by
        // "from/to" role. This guarantees every thread requests
        // locks in the same sequence -> no circular wait possible.
        Account firstLock, secondLock;
        if (from.getName().compareTo(to.getName()) < 0) {
            firstLock = from;
            secondLock = to;
        } else {
            firstLock = to;
            secondLock = from;
        }

        synchronized (firstLock) {
            System.out.println(getName() + ": locked " + firstLock.getName());
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (secondLock) {
                System.out.println(getName() + ": locked " + secondLock.getName());

                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println(getName() + ": transferred " + amount +
                            " from " + from.getName() + " to " + to.getName() +
                            " | " + from.getName() + " balance=" + from.getBalance() +
                            ", " + to.getName() + " balance=" + to.getBalance());
                } else {
                    System.out.println(getName() + ": insufficient balance in " + from.getName());
                }
            }
        }
    }
}

public class BankAccountDeadlockFixed {
    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("Account-A", 1000);
        Account accountB = new Account("Account-B", 1000);

        // Thread 1: A -> B
        Thread t1 = new TransferThread("Thread-1(A->B)", accountA, accountB, 100);
        // Thread 2: B -> A
        Thread t2 = new TransferThread("Thread-2(B->A)", accountB, accountA, 150);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balances -> " + accountA.getName() + ": " +
                accountA.getBalance() + ", " + accountB.getName() + ": " + accountB.getBalance());
    }
}