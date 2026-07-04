// BankAccount Class
class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Synchronized Deposit Method
    public synchronized void deposit(double amount) {

        balance += amount;

        System.out.println(Thread.currentThread().getName()
                + " deposited Rs." + amount);

        System.out.println("Current Balance: Rs." + balance);
    }

    // Synchronized Withdraw Method
    public synchronized void withdraw(double amount) {

        if (balance >= amount) {

            balance -= amount;

            System.out.println(Thread.currentThread().getName()
                    + " withdrew Rs." + amount);

        } else {

            System.out.println(Thread.currentThread().getName()
                    + " failed. Insufficient Balance.");

        }

        System.out.println("Current Balance: Rs." + balance);
    }
}

// Deposit Thread
class DepositThread extends Thread {

    private BankAccount account;
    private double amount;

    public DepositThread(BankAccount account, double amount) {

        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {

        account.deposit(amount);

    }
}

// Withdraw Thread
class WithdrawThread extends Thread {

    private BankAccount account;
    private double amount;

    public WithdrawThread(BankAccount account, double amount) {

        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {

        account.withdraw(amount);

    }
}

// Main Class
public class BankAccountDemo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        DepositThread deposit =
                new DepositThread(account, 500);

        WithdrawThread withdraw1 =
                new WithdrawThread(account, 700);

        WithdrawThread withdraw2 =
                new WithdrawThread(account, 1000);

        deposit.setName("Deposit Thread");
        withdraw1.setName("Withdraw Thread 1");
        withdraw2.setName("Withdraw Thread 2");

        deposit.start();
        withdraw1.start();
        withdraw2.start();

    }
}