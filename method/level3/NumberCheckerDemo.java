import java.util.Arrays;

public class NumberCheckerDemo {
    public static void main(String[] args) {
        int number = 153; // Example number, you can change it

        System.out.println("Number: " + number);

        int digitCount = NumberChecker.countDigits(number);
        System.out.println("Number of digits: " + digitCount);

        int[] digits = NumberChecker.storeDigits(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        boolean isDuck = NumberChecker.isDuckNumber(digits);
        System.out.println("Is Duck Number? " + isDuck);

        boolean isArmstrong = NumberChecker.isArmstrongNumber(number, digits);
        System.out.println("Is Armstrong Number? " + isArmstrong);

        int[] largestTwo = NumberChecker.findLargestAndSecondLargest(digits);
        System.out.println("Largest: " + largestTwo[0] + ", Second Largest: " + largestTwo[1]);

        int[] smallestTwo = NumberChecker.findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest: " + smallestTwo[0] + ", Second Smallest: " + smallestTwo[1]);
    }
}

class NumberChecker {

    
    public static int countDigits(int num) {
        int count = 0;
        int n = num;
        if (n == 0) return 1;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    
    public static int[] storeDigits(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        int temp = num;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true; // Non-zero digit present
            }
        }
        return false; // All digits are zero (not a duck number)
    }

    
    public static boolean isArmstrongNumber(int num, int[] digits) {
        int sum = 0;
        int power = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == num;
    }

    
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }
}
