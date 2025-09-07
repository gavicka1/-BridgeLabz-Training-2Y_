import java.util.*;

public class NumberGuessingGame {
    static int generateGuess(int low, int high) {
        return new Random().nextInt(high - low + 1) + low;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            String feedback = sc.nextLine();
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Guessed correctly!");
                break;
            } else if (feedback.equalsIgnoreCase("high")) high = guess - 1;
            else if (feedback.equalsIgnoreCase("low")) low = guess + 1;
            sc.close();
        }
    }
}
