import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step a: Take input for number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Step b: Create arrays
        int[][] marks = new int[n][3];   // [Physics, Chemistry, Maths]
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Step c: Input marks
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                System.out.print(subject + ": ");
                int mark = sc.nextInt();

                // Validate marks
                while (mark < 0 || mark > 100) {
                    System.out.print("Invalid! Enter positive marks (0-100): ");
                    mark = sc.nextInt();
                }
                marks[i][j] = mark;
            }

            // Step d: Calculate percentage
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = (total / 300.0) * 100;

            // Step d: Assign grade
            if (percentage[i] >= 80) grade[i] = 'A';
            else if (percentage[i] >= 70) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 50) grade[i] = 'D';
            else if (percentage[i] >= 40) grade[i] = 'E';
            else grade[i] = 'R';
        }

        // Step e: Display results
        System.out.println("\n------------------------------------------------------");
        System.out.println("Student   Physics   Chemistry   Maths   %   Grade");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d         %d         %d          %d     %.2f    %c\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
    }
}
