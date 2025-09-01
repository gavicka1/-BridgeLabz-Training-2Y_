import java.util.Scanner;

public class CharacterFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[][] frequencyResult = findCharacterFrequency(text);

        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (int i = 0; i < frequencyResult.length; i++) {
            System.out.println(frequencyResult[i][0] + "         | " + (int)frequencyResult[i][1]);
        }

        sc.close();
    }

    
    public static char[][] findCharacterFrequency(String text) {
        int[] freq = new int[256]; 
        int length = getLength(text);

       
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count how many unique characters to size the result array
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }

        // Create a 2D array to store character and its frequency
        char[][] result = new char[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) {
                result[index][0] = ch;
                result[index][1] = (char) freq[ch]; // store frequency as char (for display casting to int)
                freq[ch] = 0; // reset to avoid duplicates
                index++;
            }
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
