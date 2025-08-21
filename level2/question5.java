import java.util.Scanner;

public class question5 {
    public static void main(String[] args) {
        int number1, number2;
        Scanner input = new Scanner(System.in);
        number1 = input.nextInt();
        number2 = input.nextInt();

        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + number1 + " and " + number2);
    }
}

