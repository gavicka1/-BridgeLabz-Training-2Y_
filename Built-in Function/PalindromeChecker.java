import java.util.*;

public class PalindromeChecker {
    static boolean isPalindrome(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) rev += str.charAt(i);
        return str.equals(rev);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isPalindrome(str) ? "Palindrome" : "Not Palindrome");
        sc.close();
    }
}
