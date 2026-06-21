public class SumOfEvenNumber {
    public static void main(String[] args) {
        int number = 2;
        int sum = 0;

        while (number <= 10) {
            sum += number;
            number += 2;
        }

        System.out.println("The sum of even numbers from 2 to 10 is: " + sum);
    }
}
