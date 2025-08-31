import java.util.Scanner;
import java.util.Random;

public class ZaraBonus {

    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random rand = new Random();
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 10 + rand.nextInt(90); // Physics 10-99
            scores[i][1] = 10 + rand.nextInt(90); // Chemistry 10-99
            scores[i][2] = 10 + rand.nextInt(90); // Math 10-99
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
        System.out.printf("%-8s %-8s %-10s %-8s %-8s %-8s %-10s\n", 
                          "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Percentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-8d %-8d %-10d %-8d %-8.0f %-8.2f %-10.2f%%\n", 
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
