import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + (int)(Math.random() * 91); // 10-100 random marks
            }
        }
        return scores;
    }

    public static double[][] calculateTotalsPercentages(int[][] scores) {
        int numStudents = scores.length;
        double[][] result = new double[numStudents][4]; // total, average, percentage, placeholder for future
        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = Math.round((total / 3.0) * 100.0) / 100.0;
            double percentage = Math.round((total / 300.0 * 100.0) * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    public static String[] calculateGrades(double[][] totalsPercentages) {
        int numStudents = totalsPercentages.length;
        String[] grades = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            double percentage = totalsPercentages[i][2];
            if (percentage >= 80) grades[i] = "A";
            else if (percentage >= 70) grades[i] = "B";
            else if (percentage >= 60) grades[i] = "C";
            else if (percentage >= 50) grades[i] = "D";
            else if (percentage >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] totalsPercentages, String[] grades) {
        System.out.printf("%-10s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s%n", 
                          "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Percent", "Grade");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-8d %-8d %-8d %-8.0f %-8.2f %-8.2f %-8s%n",
                              (i + 1),
                              scores[i][0],
                              scores[i][1],
                              scores[i][2],
                              totalsPercentages[i][0],
                              totalsPercentages[i][1],
                              totalsPercentages[i][2],
                              grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] totalsPercentages = calculateTotalsPercentages(scores);
        String[] grades = calculateGrades(totalsPercentages);

        displayScorecard(scores, totalsPercentages, grades);
        sc.close();
    }
}
