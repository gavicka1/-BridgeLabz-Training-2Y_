import java.util.Scanner;

public class ques14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base number (positive integer): ");
        int number = scanner.nextInt();

        System.out.print("Enter the power (positive integer): ");
        int power = scanner.nextInt();

        if (number > 0 && power >= 0) {
            int result = 1;
            int counter = 0;

            while (counter < power) {
                result *= number;
                counter++;
            }

            System.out.println(number + " raised to the power " + power + " is: " + result);
        } else {
            System.out.println("Please enter valid positive integers for both base and power.");
        }
    }
}
