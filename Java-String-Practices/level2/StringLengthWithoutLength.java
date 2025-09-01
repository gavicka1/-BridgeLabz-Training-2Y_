import java.util.Scanner;

public class StringLengthWithoutLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        int manualLength = getStringLength(text);
        int builtInLength = text.length();

        System.out.println("\nLength using manual method: " + manualLength);
        System.out.println("Length using built-in length(): " + builtInLength);

        sc.close();
    }

    public static int getStringLength(String s) {
        int count = 0;
        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }
}
