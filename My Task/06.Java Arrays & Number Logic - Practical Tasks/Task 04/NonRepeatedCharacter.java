import java.util.Scanner;

public class NonRepeatedCharacter {
     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        boolean found = false;

        for (int i = 0; i < text.length(); i++) {

            int count = 0;

            for (int j = 0; j < text.length(); j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println("First Non-Repeated Character: " + text.charAt(i));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No Non-Repeated Character Found.");
        }
    }
}
