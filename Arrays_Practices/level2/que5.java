import java.util.Scanner;

public class que5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (number != 0) {
            int digit = number % 10;

            if (index == maxDigit) {
                maxDigit += 10;  
                int[] temp = new int[maxDigit];
                for (int j = 0; j < index; j++) {
                    temp[j] = digits[j];
                }
                digits = temp; 
            }

            digits[index] = digit;
            index++;
            number = number / 10;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit = " + largest);
        System.out.println("Second largest digit = " + secondLargest);
    }
}
