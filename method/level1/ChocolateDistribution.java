import java.util.Scanner;

public class ChocolateDistribution {

    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;   // chocolates per child
        int remainder = number % divisor;  // leftover chocolates
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input values
        System.out.print("Enter total number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int numberOfChildren = sc.nextInt();

        // Avoid divide by zero
        if (numberOfChildren <= 0) {
            System.out.println("Number of children must be greater than 0.");
        } else {
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            System.out.println("Each child will get: " + result[0] + " chocolates");
            System.out.println("Remaining chocolates: " + result[1]);
        }

        sc.close();
    }
}
