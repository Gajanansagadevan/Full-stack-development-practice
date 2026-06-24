import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        // Reverse the array
        for (int i = 0; i < size / 2; i++) {
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }

        System.out.println("\nReversed array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        scanner.close();
    }
}
