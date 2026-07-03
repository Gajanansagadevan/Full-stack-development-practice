import java.util.Scanner;

// Custom Exception Class
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// BankAccount Class
class BankAccount {

    String accountNumber;
    String accountHolderName;
    double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Withdraw Method
    public void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Withdrawal cannot be completed.");
        }

        balance = balance - amount;

        System.out.println("Withdrawal Successful.");
        System.out.println("Remaining Balance: Rs." + balance);
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create Bank Account Object
        BankAccount account =
                new BankAccount("1001", "Gajanan", 5000);

        System.out.println("Account Number : " + account.accountNumber);
        System.out.println("Account Holder : " + account.accountHolderName);
        System.out.println("Available Balance : Rs." + account.balance);

        try {

            System.out.print("\nEnter withdrawal amount: ");
            double amount = input.nextDouble();

            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {

            System.out.println("Error: " + e.getMessage());

        }

        input.close();
    }
}