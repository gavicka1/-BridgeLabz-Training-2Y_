import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0; 
            double bmi = weight / (heightInMeters * heightInMeters);
            data[i][2] = bmi;
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] teamData = new double[10][3]; 

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of member " + (i + 1) + ": ");
            teamData[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of member " + (i + 1) + ": ");
            teamData[i][1] = sc.nextDouble();
        }

        calculateBMI(teamData);
        String[] bmiStatus = getBMIStatus(teamData);

        System.out.println("\nTeam BMI Report:");
        System.out.println("Weight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s\n",
                    teamData[i][0], teamData[i][1], teamData[i][2], bmiStatus[i]);
        }

        sc.close();
    }
}
