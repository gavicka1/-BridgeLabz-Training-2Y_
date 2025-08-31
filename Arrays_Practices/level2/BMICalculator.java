import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        // Input weight and height
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height (meters) for person " + (i + 1) + ": ");
            height[i] = sc.nextDouble();
        }

        // Calculate BMI and status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nPerson Details:");
        System.out.println("----------------------------------------------------");
        System.out.println("Height(m)   Weight(kg)   BMI       Status");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f       %.2f       %.2f   %s\n",
                    height[i], weight[i], bmi[i], status[i]);
        }
    }
}
