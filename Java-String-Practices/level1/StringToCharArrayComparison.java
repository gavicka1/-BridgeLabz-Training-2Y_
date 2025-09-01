import java.util.Arrays;
import java.util.Scanner;

public class StringToCharArrayComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] manualChars = getCharsManually(text);
        char[] builtInChars = text.toCharArray();

        System.out.println("\nCharacters using manual method: " + Arrays.toString(manualChars));
        System.out.println("Characters using toCharArray(): " + Arrays.toString(builtInChars));

        boolean areEqual = compareCharArrays(manualChars, builtInChars);
        System.out.println("Are both arrays equal? " + areEqual);

        sc.close();
    }

    public static char[] getCharsManually(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
