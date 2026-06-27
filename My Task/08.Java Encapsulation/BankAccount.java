public class BankAccount {
     // Private Attributes
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Getter and Setter for Account Number
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter and Setter for Account Holder Name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // Getter and Setter for Balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Display Method
    public void displayAccountDetails() {
        System.out.println("\n===== Account Details =====");
        System.out.println("Account Number      : " + accountNumber);
        System.out.println("Account Holder Name : " + accountHolderName);
        System.out.println("Current Balance     : ₹" + balance);
    }

    // Main Method
    public static void main(String[] args) {

        // Create BankAccount Object
        BankAccount account = new BankAccount();

        // Set Account Details
        account.setAccountNumber("ACC1001");
        account.setAccountHolderName("Gajanan Sagadevan");
        account.setBalance(10000);

        // Deposit ₹5000
        account.deposit(5000);

        // Withdraw ₹2000
        account.withdraw(2000);

        // Display Updated Details
        account.displayAccountDetails();
    }
}
