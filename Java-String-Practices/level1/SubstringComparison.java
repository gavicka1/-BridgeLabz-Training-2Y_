import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String manualSubstring = createSubstringUsingCharAt(text, start, end);
        String builtInSubstring = text.substring(start, end);

        System.out.println("\nSubstring using charAt(): " + manualSubstring);
        System.out.println("Substring using built-in substring(): " + builtInSubstring);

        boolean areEqual = compareUsingCharAt(manualSubstring, builtInSubstring);
        System.out.println("Are both substrings equal? " + areEqual);

        sc.close();
    }

    public static String createSubstringUsingCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end && i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
