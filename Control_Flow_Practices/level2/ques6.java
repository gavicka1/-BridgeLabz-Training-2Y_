import java.util.Scanner;

public class ques6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Amar's age and height:");
        int amarAge = scanner.nextInt();
        double amarHeight = scanner.nextDouble();

        System.out.println("Enter Akbar's age and height:");
        int akbarAge = scanner.nextInt();
        double akbarHeight = scanner.nextDouble();

        System.out.println("Enter Anthony's age and height:");
        int anthonyAge = scanner.nextInt();
        double anthonyHeight = scanner.nextDouble();

        // Find youngest
        int youngestAge = amarAge;
        String youngestFriend = "Amar";

        if (akbarAge < youngestAge) {
            youngestAge = akbarAge;
            youngestFriend = "Akbar";
        }
        if (anthonyAge < youngestAge) {
            youngestAge = anthonyAge;
            youngestFriend = "Anthony";
        }

        // Find tallest
        double tallestHeight = amarHeight;
        String tallestFriend = "Amar";

        if (akbarHeight > tallestHeight) {
            tallestHeight = akbarHeight;
            tallestFriend = "Akbar";
        }
        if (anthonyHeight > tallestHeight) {
            tallestHeight = anthonyHeight;
            tallestFriend = "Anthony";
        }

        System.out.println("The youngest friend is " + youngestFriend + " with age " + youngestAge);
        System.out.println("The tallest friend is " + tallestFriend + " with height " + tallestHeight);
    }
}
