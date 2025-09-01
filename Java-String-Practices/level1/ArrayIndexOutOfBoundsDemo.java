import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        System.out.println("\n1. Method that generates ArrayIndexOutOfBoundsException:");
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e);
        } catch (RuntimeException e) {
            System.out.println("Other runtime exception caught in main: " + e);
        }

        System.out.println("\n2. Method that handles ArrayIndexOutOfBoundsException internally:");
        handleException(names);

        sc.close();
    }

    public static void generateException(String[] arr) {
        System.out.println("Attempting to access an index beyond array length...");
        System.out.println(arr[arr.length]); // valid indices are 0 to arr.length-1
    }

    public static void handleException(String[] arr) {
        try {
            System.out.println("Attempting to access an index beyond array length...");
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException internally: " + e);
        } catch (RuntimeException e) {
            System.out.println("Handled other runtime exception internally: " + e);
        }
    }
}
