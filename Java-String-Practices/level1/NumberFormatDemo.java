import java.util.Scanner;

public class NumberFormatDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to convert to number: ");
        String text = sc.nextLine();

        System.out.println("\n1. Method that generates NumberFormatException:");
        try {
            generateException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught in main: " + e);
        } catch (RuntimeException e) {
            System.out.println("Other runtime exception caught in main: " + e);
        }

        System.out.println("\n2. Method that handles NumberFormatException internally:");
        handleException(text);

        sc.close();
    }

    public static void generateException(String text) {
        System.out.println("Attempting to convert text to number...");
        
        int number = Integer.parseInt(text);
        System.out.println("Number is: " + number);
    }

    public static void handleException(String text) {
        try {
            System.out.println("Attempting to convert text to number...");
            int number = Integer.parseInt(text);
            System.out.println("Number is: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException internally: " + e);
        } catch (RuntimeException e) {
            System.out.println("Handled other runtime exception internally: " + e);
        }
    }
}
