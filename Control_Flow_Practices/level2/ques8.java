import java.util.Scanner;

public class ques8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            int counter = 1;
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
            System.out.println(number); // number itself is a factor
        } else {
            System.out.println("Please enter a positive integer.");
        }

    }

}
