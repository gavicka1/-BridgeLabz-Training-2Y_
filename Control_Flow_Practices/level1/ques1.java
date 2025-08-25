
import java.util.Scanner;

public class ques1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        String result = (number % 5 == 0) ? "Yes" : "No";
        System.out.println("Is the number " + number + " divisible by 5? " + result);
    }
}
