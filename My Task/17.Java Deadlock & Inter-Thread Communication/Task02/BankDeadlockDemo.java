class Account {
    private String name;
    private double balance;

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void withdraw(double amount) { balance -= amount; }
    public void deposit(double amount) { balance += amount; }
}

class TransferThread extends Thread {
    private Account from;
    private Account to;
    private double amount;

    TransferThread(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        // BUG: locks "from" first, then "to" — different threads lock in
        // different orders depending on transfer direction -> deadlock risk
        synchronized (from) {
            System.out.println(Thread.currentThread().getName() +
                    " locked " + from.getName() + ", waiting for " + to.getName());
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (to) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() +
                            " transferred " + amount + " from " + from.getName() +
                            " to " + to.getName());
                } else {
                    System.out.println("Insufficient balance in " + from.getName());
                }
            }
        }
    }
}

public class BankDeadlockDemo {
    public static void main(String[] args) {
        Account accountA = new Account("Account-A", 1000);
        Account accountB = new Account("Account-B", 1000);

        // Thread 1: A -> B (locks A first, then B)
        Thread t1 = new TransferThread(accountA, accountB, 200);
        // Thread 2: B -> A (locks B first, then A)
        Thread t2 = new TransferThread(accountB, accountA, 300);

        t1.setName("Transfer-A-to-B");
        t2.setName("Transfer-B-to-A");

        t1.start();
        t2.start();
    }
}
