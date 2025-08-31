import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step a: Take input for a number
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        // Step b: Convert number to string (to count digits easily)
        String numStr = Long.toString(number);
        int length = numStr.length();

        // Step c: Store digits in an array
        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = numStr.charAt(i) - '0';  // convert char to int
        }

        // Step d: Frequency array of size 10
        int[] frequency = new int[10];

        // Count frequency
        for (int d : digits) {
            frequency[d]++;
        }

        // Step e: Display frequency
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {  // show only digits that exist in number
                System.out.println("Digit " + i + " -> " + frequency[i] + " times");
            }
        }
    }
}
