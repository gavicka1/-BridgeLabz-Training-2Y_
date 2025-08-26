import java.util.Scanner;

public class ques4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number greater than 1: ");
        int number = scanner.nextInt();

        if (number <= 1) {
            System.out.println("Number should be greater than 1.");
            return;
        }

        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(number + " is a Prime Number:");
        } else {
            System.out.println(number + " is not a Prime Number:");
        }

    }

}
