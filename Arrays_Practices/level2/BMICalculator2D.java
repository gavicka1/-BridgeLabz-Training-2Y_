import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];

        // Input weight and height
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            double weight = sc.nextDouble();
            while (weight <= 0) {
                System.out.print("Invalid! Enter positive weight: ");
                weight = sc.nextDouble();
            }

            System.out.print("Enter height (meters) for person " + (i + 1) + ": ");
            double height = sc.nextDouble();
            while (height <= 0) {
                System.out.print("Invalid! Enter positive height: ");
                height = sc.nextDouble();
            }

            double bmi = weight / (height * height);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nPerson Details:");
        System.out.println("----------------------------------------------------");
        System.out.println("Height(m)   Weight(kg)   BMI       Status");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f       %.2f       %.2f   %s\n",
                    personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
    }
}
