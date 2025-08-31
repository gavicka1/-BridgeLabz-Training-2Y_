import java.util.Scanner;

public class CollinearPoints {

    public static boolean isCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        int dx1 = x2 - x1;
        int dy1 = y2 - y1;
        int dx2 = x3 - x2;
        int dy2 = y3 - y2;
        int dx3 = x3 - x1;
        int dy3 = y3 - y1;

        return (dy1 * dx2 == dy2 * dx1) && (dy1 * dx3 == dy3 * dx1);
    }

    public static boolean isCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1, y1: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.print("Enter x2, y2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.print("Enter x3, y3: ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        if (isCollinearSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear (Slope Method)");
        } else {
            System.out.println("Points are NOT collinear (Slope Method)");
        }

        if (isCollinearArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear (Area Method)");
        } else {
            System.out.println("Points are NOT collinear (Area Method)");
        }

        sc.close();
    }
}
