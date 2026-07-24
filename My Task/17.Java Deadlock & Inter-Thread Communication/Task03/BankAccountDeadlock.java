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
        // BUG: locks "from" first, then "to".
        // Thread1 locks A then B, Thread2 locks B then A -> circular wait.
        synchronized (from) {
            System.out.println(getName() + ": locked " + from.getName() +
                    ", waiting for " + to.getName());
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (to) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println(getName() + ": transferred " + amount +
                            " from " + from.getName() + " to " + to.getName());
                } else {
                    System.out.println(getName() + ": insufficient balance in " + from.getName());
                }
            }
        }
    }
}

public class BankAccountDeadlock {
    public static void main(String[] args) {
        Account accountA = new Account("Account-A", 1000);
        Account accountB = new Account("Account-B", 1000);

        // Thread 1: A -> B  (locks A first, then B)
        Thread t1 = new TransferThread("Thread-1(A->B)", accountA, accountB, 100);
        // Thread 2: B -> A  (locks B first, then A)
        Thread t2 = new TransferThread("Thread-2(B->A)", accountB, accountA, 150);

        t1.start();
        t2.start();

        // Program will hang here — classic deadlock.
        // Both threads sleep after acquiring their first lock, then both
        // block forever trying to acquire the second (already-held) lock.
    }
}
