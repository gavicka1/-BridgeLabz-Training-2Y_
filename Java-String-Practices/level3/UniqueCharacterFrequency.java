import java.util.Scanner;

public class UniqueCharacterFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] uniqueChars = uniqueCharacters(text);
        String[][] frequencyResult = characterFrequencies(text, uniqueChars);

        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (int i = 0; i < frequencyResult.length; i++) {
            System.out.println(frequencyResult[i][0] + "         | " + frequencyResult[i][1]);
        }

        sc.close();
    }

    // Method to find unique characters in a string
    public static char[] uniqueCharacters(String text) {
        int length = getLength(text);
        String unique = "";

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean isDuplicate = false;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                unique += ch; // add only unique characters
            }
        }

        // Convert to char array
        char[] uniqueArray = new char[getLength(unique)];
        for (int i = 0; i < getLength(unique); i++) {
            uniqueArray[i] = unique.charAt(i);
        }

        return uniqueArray;
    }

    // Method to calculate frequency of unique characters
    public static String[][] characterFrequencies(String text, char[] uniqueChars) {
        int length = getLength(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            int count = 0;

            for (int j = 0; j < length; j++) {
                if (text.charAt(j) == ch) {
                    count++;
                }
            }

            result[i][0] = Character.toString(ch);
            result[i][1] = Integer.toString(count);
        }

        return result;
    }

    // Method to find length of string without using length()
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
