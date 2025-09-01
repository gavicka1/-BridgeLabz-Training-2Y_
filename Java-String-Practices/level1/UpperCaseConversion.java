import java.util.Scanner;

public class UpperCaseConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        String manualUpper = convertToUpperUsingCharAt(text);
        String builtInUpper = text.toUpperCase();

        System.out.println("\nUppercase using manual method: " + manualUpper);
        System.out.println("Uppercase using built-in toUpperCase(): " + builtInUpper);

        boolean areEqual = compareStrings(manualUpper, builtInUpper);
        System.out.println("Are both uppercase strings equal? " + areEqual);

        sc.close();
    }

    public static String convertToUpperUsingCharAt(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char)(ch - 32)); 
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
