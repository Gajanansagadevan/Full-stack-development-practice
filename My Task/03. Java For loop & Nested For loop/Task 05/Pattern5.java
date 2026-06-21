public class Pattern5 {
    public static void main(String[] args) {

        // Upper Half
        for (int i = 1; i <= 5; i++) {

            // Spaces
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Lower Half
        for (int i = 4; i >= 1; i--) {

            // Spaces
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}