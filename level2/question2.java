
import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
        double base, height;
        Scanner input = new Scanner(System.in);
        base = input.nextDouble();
        height = input.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaIn = areaCm / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaIn + " and sq cm is " + areaCm);
    }
}

