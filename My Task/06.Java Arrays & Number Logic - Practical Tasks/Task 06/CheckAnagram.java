import java.util.Scanner;

public class CheckAnagram {
     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter First String: ");
        String first = input.nextLine().toLowerCase();

        System.out.print("Enter Second String: ");
        String second = input.nextLine().toLowerCase();

        first = first.replace(" ", "");
        second = second.replace(" ", "");

        if (first.length() != second.length()) {
            System.out.println("Not Anagrams");
            return;
        }

        int[] count = new int[256];

        for (int i = 0; i < first.length(); i++) {
            count[first.charAt(i)]++;
            count[second.charAt(i)]--;
        }

        boolean isAnagram = true;

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                isAnagram = false;
                break;
            }
        }

        if (isAnagram)
            System.out.println("Strings are Anagrams.");
        else
            System.out.println("Strings are NOT Anagrams.");
    }
}
