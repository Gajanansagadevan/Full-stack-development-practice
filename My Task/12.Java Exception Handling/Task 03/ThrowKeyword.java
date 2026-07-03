import java.util.Scanner;

public class ThrowKeyword {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            System.out.print("Enter student's age: ");
            int age = input.nextInt();

            if (age < 18) {

                throw new IllegalArgumentException("Student must be at least 18 years old.");

            }

            System.out.println("Eligible.");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        input.close();
    }
}
