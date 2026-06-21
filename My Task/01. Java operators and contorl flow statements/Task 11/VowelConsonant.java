import java.util.Scanner;

public class VowelConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        char lowerCh = Character.toLowerCase(ch);

        if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
            System.out.println(ch + " is a Vowel");
        } else if (Character.isLetter(ch)) {
            System.out.println(ch + " is a Consonant");
        } else {
            System.out.println(ch + " is not a letter");
        }
        sc.close();
    }
}
