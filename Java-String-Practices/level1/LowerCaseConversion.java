import java.util.Scanner;

public class LowerCaseConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        String manualLower = convertToLowerUsingCharAt(text);
        String builtInLower = text.toLowerCase();

        System.out.println("\nLowercase using manual method: " + manualLower);
        System.out.println("Lowercase using built-in toLowerCase(): " + builtInLower);

        boolean areEqual = compareStrings(manualLower, builtInLower);
        System.out.println("Are both lowercase strings equal? " + areEqual);

        sc.close();
    }

    public static String convertToLowerUsingCharAt(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)(ch + 32)); 
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
