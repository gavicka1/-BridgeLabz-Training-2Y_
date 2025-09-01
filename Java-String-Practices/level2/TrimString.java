import java.util.Scanner;

public class TrimString {

    public static int[] trimIndices(String str) {
        int start = 0;
        int end = 0;
        int len = 0;

        try {
            while (true) {
                str.charAt(len++);
            }
        } catch (IndexOutOfBoundsException e) {
        }

        while (start < len && str.charAt(start) == ' ') {
            start++;
        }

        end = len - 1;
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String substring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        int len1 = 0, len2 = 0;
        try {
            while (true) {
                str1.charAt(len1++);
            }
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            while (true) {
                str2.charAt(len2++);
            }
        } catch (IndexOutOfBoundsException e) {
        }

        if (len1 != len2) return false;

        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] indices = trimIndices(input);
        String trimmedCustom = substring(input, indices[0], indices[1]);
        String trimmedBuiltIn = input.trim();

        System.out.println("Custom trimmed string: '" + trimmedCustom + "'");
        System.out.println("Built-in trimmed string: '" + trimmedBuiltIn + "'");
        System.out.println("Are both strings equal? " + compareStrings(trimmedCustom, trimmedBuiltIn));

        sc.close();
    }
}
