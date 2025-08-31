import java.util.Scanner;

public class que6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Number: " + number);
        System.out.println("Is Perfect? " + NumberChecker.isPerfect(number));
        System.out.println("Is Abundant? " + NumberChecker.isAbundant(number));
        System.out.println("Is Deficient? " + NumberChecker.isDeficient(number));
        System.out.println("Is Strong? " + NumberChecker.isStrong(number));

        sc.close();
    }
}

class NumberChecker {

    public static boolean isPerfect(int num) {
        return num > 0 && sumOfProperDivisors(num) == num;
    }

    public static boolean isAbundant(int num) {
        return num > 0 && sumOfProperDivisors(num) > num;
    }

    public static boolean isDeficient(int num) {
        return num > 0 && sumOfProperDivisors(num) < num;
    }

    public static boolean isStrong(int num) {
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == num;
    }

    private static int sumOfProperDivisors(int num) {
        if (num <= 1) return 0;
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) sum += num / i;
            }
        }
        return sum;
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
}
