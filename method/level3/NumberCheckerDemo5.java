import java.util.ArrayList;

public class NumberCheckerDemo5 {
    public static void main(String[] args) {
        int number = 7;

        System.out.println("Number: " + number);
        System.out.println("Is Prime? " + NumberChecker.isPrime(number));
        System.out.println("Is Neon? " + NumberChecker.isNeon(number));
        System.out.println("Is Spy? " + NumberChecker.isSpy(number));
        System.out.println("Is Automorphic? " + NumberChecker.isAutomorphic(number));
        System.out.println("Is Buzz? " + NumberChecker.isBuzz(number));
    }
}

class NumberChecker {

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    public static boolean isSpy(int num) {
        int sum = 0;
        int product = 1;
        ArrayList<Integer> digits = getDigits(num);
        for (int d : digits) {
            sum += d;
            product *= d;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int num) {
        ArrayList<Integer> numDigits = getDigits(num);
        int square = num * num;
        ArrayList<Integer> squareDigits = getDigits(square);

        int n = numDigits.size();
        int m = squareDigits.size();
        for (int i = 0; i < n; i++) {
            if (!numDigits.get(n - 1 - i).equals(squareDigits.get(m - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBuzz(int num) {
        ArrayList<Integer> digits = getDigits(num);
        return num % 7 == 0 || digits.get(digits.size() - 1) == 7;
    }

    private static ArrayList<Integer> getDigits(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        if (num == 0) digits.add(0);
        while (num > 0) {
            digits.add(0, num % 10);
            num /= 10;
        }
        return digits;
    }
}
