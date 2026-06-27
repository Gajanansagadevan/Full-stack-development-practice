import java.util.Scanner;

public class CharacterFrequency {
     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {

                if (current == text.charAt(k)) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted)
                continue;

            int count = 0;

            for (int j = 0; j < text.length(); j++) {

                if (current == text.charAt(j)) {
                    count++;
                }
            }

            System.out.println(current + " = " + count);
        }
    }
}
