import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            boolean exists = false;

            for (int j = 0; j < result.length(); j++) {

                if (current == result.charAt(j)) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                result += current;
            }
        }

        System.out.println("After Removing Duplicates: " + result);
    }
}
