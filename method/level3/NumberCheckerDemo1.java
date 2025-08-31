import java.util.Arrays;

public class NumberCheckerDemo1 {
    public static void main(String[] args) {
        int number = 1729; // Example number

        System.out.println("Number: " + number);

        int digitCount = NumberChecker.countDigits(number);
        System.out.println("Number of digits: " + digitCount);

        int[] digits = NumberChecker.storeDigits(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        int sumDigits = NumberChecker.sumOfDigits(digits);
        System.out.println("Sum of digits: " + sumDigits);

        int sumSquares = NumberChecker.sumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits: " + sumSquares);

        boolean isHarshad = NumberChecker.isHarshadNumber(number, digits);
        System.out.println("Is Harshad Number? " + isHarshad);

        int[][] frequency = NumberChecker.digitFrequency(digits);
        System.out.println("Digit Frequency (Digit : Frequency):");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + " : " + frequency[i][1]);
            }
        }
    }
}

class NumberChecker {

    public static int countDigits(int num) {
        if (num == 0) return 1;
        int count = 0;
        int n = num;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static int[] storeDigits(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        int temp = num;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int num, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && num % sum == 0;
    }

   
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2]; // 10 digits, [digit, frequency]
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i; // digit
            freq[i][1] = 0; // initialize frequency
        }

        for (int digit : digits) {
            freq[digit][1]++;
        }
        return freq;
    }
}
