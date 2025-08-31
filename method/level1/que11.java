import java.util.Scanner;

public class que11 {

    // Method to calculate sine, cosine, and tangent
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle); // Convert degrees to radians
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input angle in degrees
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        double[] results = calculateTrigonometricFunctions(angle);

        System.out.println("Sine(" + angle + ") = " + results[0]);
        System.out.println("Cosine(" + angle + ") = " + results[1]);
        System.out.println("Tangent(" + angle + ") = " + results[2]);

        sc.close();
    }
}
