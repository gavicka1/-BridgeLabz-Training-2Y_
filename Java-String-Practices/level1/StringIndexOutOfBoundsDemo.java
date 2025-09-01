import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.println("\n1. Method that generates StringIndexOutOfBoundsException:");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\n2. Method that handles StringIndexOutOfBoundsException internally:");
        handleException(text);

        sc.close();
    }

    public static void generateException(String s) {
        System.out.println("Attempting to access index beyond string length...");
        
        System.out.println(s.charAt(s.length() + 1));
    }

    public static void handleException(String s) {
        try {
            System.out.println("Attempting to access index beyond string length...");
            System.out.println(s.charAt(s.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException internally: " + e);
        }
    }
}
