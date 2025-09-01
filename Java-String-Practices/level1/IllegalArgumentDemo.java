import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.println("\n1. Method that generates IllegalArgumentException:");
        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e);
        } catch (RuntimeException e) {
            System.out.println("Other runtime exception caught in main: " + e);
        }

        System.out.println("\n2. Method that handles IllegalArgumentException internally:");
        handleException(text);

        sc.close();
    }

    public static void generateException(String s) {
        System.out.println("Attempting to use substring with start index > end index...");
        System.out.println(s.substring(s.length(), s.length() - 1));
    }

    public static void handleException(String s) {
        try {
            System.out.println("Attempting to use substring with start index > end index...");
            System.out.println(s.substring(s.length(), s.length() - 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException internally: " + e);
        } catch (RuntimeException e) {
            System.out.println("Handled other runtime exception internally: " + e);
        }
    }
}
