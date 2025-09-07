import java.util.*;
import java.util.Random;

public class BuiltInFunctionsDifferent {
    
    public static void generateRandomNumbers() {
        Random random = new Random();
        System.out.println("Random boolean: " + random.nextBoolean());
        System.out.println("Random double (0-1): " + random.nextDouble());
    }
    
    public static void performMathOperations() {
        System.out.println("Max of 12 and 25: " + Math.max(12, 25));
        System.out.println("Min of 12 and 25: " + Math.min(12, 25));
        System.out.println("Ceil of 5.3: " + Math.ceil(5.3));
        System.out.println("Floor of 5.7: " + Math.floor(5.7));
        System.out.println("Round of 5.5: " + Math.round(5.5));
    }
    
    public static void manipulateArray() {
        int[] numbers = {10, 20, 30, 40, 50};
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copied Array: " + Arrays.toString(copy));
        System.out.println("Are arrays equal? " + Arrays.equals(numbers, copy));
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Filled Array: " + Arrays.toString(filled));
    }
    
    public static void manipulateString() {
        String text = "Java Programming";
        System.out.println("Length: " + text.length());
        System.out.println("Character at 5: " + text.charAt(5));
        System.out.println("Contains 'Pro': " + text.contains("Pro"));
        System.out.println("Replace 'Java' with 'C++': " + text.replace("Java", "C++"));
        System.out.println("Trimmed: " + "   Hello   ".trim());
    }
    
    public static void main(String[] args) {
        System.out.println("Random Numbers:");
        generateRandomNumbers();
        
        System.out.println("\nMath Operations:");
        performMathOperations();
        
        System.out.println("\nArray Manipulation:");
        manipulateArray();
        
        System.out.println("\nString Manipulation:");
        manipulateString();
        
    }
}
