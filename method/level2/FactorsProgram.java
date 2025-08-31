import java.util.Scanner;

public class FactorsProgram {

    // Method to find factors and store in an array
    public static int[] findFactors(int number) {
        int count = 0;

        // First loop - count factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Create array of exact size
        int[] factors = new int[count];
        int index = 0;

        // Second loop - save factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to calculate sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    // Method to calculate product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    // Method to calculate sum of squares of factors
    public static long sumOfSquares(int[] factors) {
        long sumSquares = 0;
        for (int f : factors) {
            sumSquares += Math.pow(f, 2);
        }
        return sumSquares;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        
        int[] factors = findFactors(number);

        
        System.out.print("Factors of " + number + ": ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        
        int sum = sumOfFactors(factors);
        long product = productOfFactors(factors);
        long sumSquares = sumOfSquares(factors);

        
        System.out.println("Sum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumSquares);

        sc.close();
    }
}
