import java.util.Scanner;

public class SplitText {

   
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

    
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text:");
        String input = sc.nextLine();

        
        String[] wordsCustom = splitWords(input);

        String[] wordsSplit = input.split(" ");

        
        System.out.println("\nWords using custom method:");
        for (String w : wordsCustom) {
            System.out.println(w);
        }

        System.out.println("\nWords using split() method:");
        for (String w : wordsSplit) {
            System.out.println(w);
        }

        
        boolean areEqual = compareArrays(wordsCustom, wordsSplit);
        System.out.println("\nAre both arrays equal? " + areEqual);

        sc.close();
    }
}
