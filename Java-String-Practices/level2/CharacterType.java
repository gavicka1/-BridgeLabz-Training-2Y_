import java.util.Scanner;

public class CharacterType {

    public static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static String[][] findCharTypes(String str) {
        int length = 0;
        try {
            while (true) {
                str.charAt(length++);
            }
        } catch (IndexOutOfBoundsException e) {
        }

        String[][] result = new String[length][2];
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkChar(ch);
        }
        return result;
    }

    public static void displayTable(String[][] arr) {
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        System.out.println("-------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-10s %-15s%n", arr[i][0], arr[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[][] charTypes = findCharTypes(input);
        displayTable(charTypes);
        sc.close();
    }
}
