public class NullPointerDemo {

    public static void main(String[] args) {
        System.out.println("Demonstrating NullPointerException:");

        System.out.println("\n1. Method that generates NullPointerException:");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\n2. Method that handles NullPointerException internally:");
        handleException();
    }

  
    public static void generateException() {
        String text = null;
        System.out.println("Attempting to access length of null string...");
        System.out.println(text.length()); 
    }

    
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Attempting to access length of null string...");
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException internally: " + e);
        }
    }
}
