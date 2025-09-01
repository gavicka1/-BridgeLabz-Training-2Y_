import java.util.Scanner;

public class NestedLoopCharacterFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[] frequencyResult = characterFrequencies(text);

        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (String entry : frequencyResult) {
            System.out.println(entry);
        }

        sc.close();
    }

    
    public static String[] characterFrequencies(String text) {
        char[] chars = text.toCharArray(); 
        int length = chars.length;
        int[] freq = new int[length]; 

       
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') continue; 
            freq[i] = 1; 
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; 
                }
            }
        }

       
        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') uniqueCount++;
        }

       
        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + "         | " + freq[i];
                index++;
            }
        }

        return result;
    }
}
