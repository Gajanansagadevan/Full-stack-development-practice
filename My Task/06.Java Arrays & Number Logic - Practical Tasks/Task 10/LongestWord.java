import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        String[] words = sentence.split(" ");

        String longest = "";

        for (int i = 0; i < words.length; i++) {

            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        System.out.println("Longest Word: " + longest);
        System.out.println("Length: " + longest.length());
    }
}
