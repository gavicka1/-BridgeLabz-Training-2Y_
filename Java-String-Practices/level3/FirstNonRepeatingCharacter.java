import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result != 0) {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }

    
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return 0; 
        }

        int[] freq = new int[256];
        int length = getLength(text);

        
        for (int i = 0; i < length; i++) {
            freq[text.charAt(i)]++;
        }

       
        for (int i = 0; i < length; i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return 0; 
    }

    
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
