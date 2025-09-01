import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Logic 1: Iterative check using start and end indexes
        boolean isPalindrome1 = isPalindromeIterative(text);
        System.out.println("Palindrome check (Iterative): " + isPalindrome1);

        // Logic 2: Recursive check
        boolean isPalindrome2 = isPalindromeRecursive(text, 0, getLength(text) - 1);
        System.out.println("Palindrome check (Recursive): " + isPalindrome2);

        // Logic 3: Using character arrays and reverse
        boolean isPalindrome3 = isPalindromeUsingReverse(text);
        System.out.println("Palindrome check (Reverse Array): " + isPalindrome3);

        sc.close();
    }

    // Logic 1: Iterative check
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = getLength(text) - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive check
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using character arrays and reverse
    public static boolean isPalindromeUsingReverse(String text) {
        int length = getLength(text);
        char[] original = new char[length];
        char[] reverse = new char[length];

        for (int i = 0; i < length; i++) {
            original[i] = text.charAt(i);
            reverse[length - i - 1] = text.charAt(i); // reverse index
        }

        for (int i = 0; i < length; i++) {
            if (original[i] != reverse[i]) return false;
        }

        return true;
    }

    // Custom method to get string length without using length()
    public static int getLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }
}
