import java.util.Scanner;

public class ThrowAndThrows {
     public static void checkNumber(int number) throws Exception {

        if (number < 0) {

            throw new Exception("Negative number is not allowed.");

        }

        System.out.println("The number is positive.");

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            System.out.print("Enter a number: ");
            int number = input.nextInt();

            checkNumber(number);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

        input.close();
    }
}
