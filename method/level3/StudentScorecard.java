import java.util.Scanner;
import java.util.Random;

public class StudentScorecard {

    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random rand = new Random();
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 10 + rand.nextInt(91); // Physics 10-99
            scores[i][1] = 10 + rand.nextInt(91); // Chemistry 10-99
            scores[i][2] = 10 + rand.nextInt(91); // Math 10-99
        }
        return scores;
    }

    public static double[][] calculateTotalsAveragesPercentages(int[][] scores) {
        int numStudents = scores.length;
        double[][] results = new double[numStudents][3]; 
        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = Math.round(total / 3.0 * 100.0) / 100.0;
            double percentage = Math.round((total / 300.0) * 10000.0) / 100.0;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\n", 
                i+1, scores[i][0], scores[i][1], scores[i][2], 
                results[i][0], results[i][1], results[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        int[][] scores = generateScores(numStudents);
        double[][] results = calculateTotalsAveragesPercentages(scores);
        displayScorecard(scores, results);
        sc.close();
    }
}
