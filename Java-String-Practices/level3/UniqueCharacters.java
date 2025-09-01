import java.util.Scanner;

public class UniqueCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int textLength = getLength(text); // get length without using length()
        char[] uniqueChars = findUniqueChars(text, textLength);

        System.out.print("Unique characters in the string: ");
        for (char c : uniqueChars) {
            if (c != 0) { // ignore empty slots in the array
                System.out.print(c + " ");
            }
        }

        sc.close();
    }

    // Method to find the length of the string without using length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // will throw exception when index is out of bounds
                count++;
            }
        } catch (Exception e) {
            // reached end of string
        }
        return count;
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueChars(String text, int length) {
        char[] result = new char[length]; // store unique characters
        int index = 0;

        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if current character appeared before
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                result[index] = current;
                index++;
            }
        }

        return result;
    }
}
