import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int i = 1;
        while (i <= 12) {
            System.out.println(i + " x " + number + " = " + (i * number));
            i++;
        }
        scanner.close();
    }
}
