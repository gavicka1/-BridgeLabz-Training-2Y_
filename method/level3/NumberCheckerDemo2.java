import java.util.Arrays;

public class NumberCheckerDemo2 {
    public static void main(String[] args) {
        int number = 12021; // Example number

        System.out.println("Number: " + number);

        int digitCount = NumberChecker.countDigits(number);
        System.out.println("Number of digits: " + digitCount);

        int[] digits = NumberChecker.storeDigits(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        int[] reversedDigits = NumberChecker.reverseDigits(digits);
        System.out.println("Reversed digits: " + Arrays.toString(reversedDigits));

        boolean isPalindrome = NumberChecker.isPalindrome(digits);
        System.out.println("Is Palindrome? " + isPalindrome);

        boolean isDuck = NumberChecker.isDuckNumber(digits);
        System.out.println("Is Duck Number? " + isDuck);
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

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return areArraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) return true;
        }
        return false; 
    }
}
