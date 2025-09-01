import java.util.Scanner;

public class WordsAndLengths {

    
    public static int stringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            
        }
        return count;
    }

    
    public static String[] splitWords(String str) {
        int len = stringLength(str);
        int wordCount = 1;

       
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount; i++) {
            int end = (i < spaceIndexes.length) ? spaceIndexes[i] : len;
            String word = "";
            for (int j = start; j < end; j++) {
                word += str.charAt(j);
            }
            words[i] = word;
            start = end + 1;
        }

        return words;
    }

    
    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(stringLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text:");
        String input = sc.nextLine();

        
        String[] words = splitWords(input);

        
        String[][] wordsAndLengths = wordsWithLengths(words);

        
        System.out.println("\nWord\tLength");
        System.out.println("---------------");
        for (int i = 0; i < wordsAndLengths.length; i++) {
            String word = wordsAndLengths[i][0];
            int length = Integer.parseInt(wordsAndLengths[i][1]);
            System.out.println(word + "\t" + length);
        }

        sc.close();
    }
}
