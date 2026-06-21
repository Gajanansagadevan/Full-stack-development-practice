import java.util.Scanner;

public class Addition {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number (a): ");
        int a = input.nextInt();
        System.out.print("Enter second number (b): ");
        int b = input.nextInt();

        System.out.println("The result is: " +(a+b));
        input.close();
    }
}
