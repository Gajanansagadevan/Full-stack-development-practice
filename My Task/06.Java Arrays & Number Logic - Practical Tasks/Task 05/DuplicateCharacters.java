import java.util.Scanner;

public class DuplicateCharacters {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine().toLowerCase();

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            if (current == ' ') {
                continue;
            }

            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {
                if (text.charAt(k) == current) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < text.length(); j++) {

                if (current == text.charAt(j)) {
                    count++;
                }
            }

            if (count > 1) {
                System.out.println(current + " = " + count);
            }
        }
    }
}
