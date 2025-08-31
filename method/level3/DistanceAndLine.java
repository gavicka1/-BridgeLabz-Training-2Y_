import java.util.Scanner;

public class DistanceAndLine {

    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    
    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double slope, intercept;

        
        if (x2 - x1 == 0) {
            System.out.println("The line is vertical. Slope is undefined.");
            slope = Double.NaN; 
            intercept = Double.NaN;
        } else {
            slope = (y2 - y1) / (x2 - x1); 
            intercept = y1 - slope * x1;        
                }

        return new double[]{slope, intercept};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 and y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 and y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distance = euclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance between the points: %.2f\n", distance);

        double[] line = lineEquation(x1, y1, x2, y2);
        if (!Double.isNaN(line[0])) {
            System.out.printf("Equation of the line: y = %.2fx + %.2f\n", line[0], line[1]);
        } else {
            System.out.println("Equation of the line: x = " + x1); // vertical line
        }

        sc.close();
    }
}
