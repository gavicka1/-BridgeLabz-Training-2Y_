import java.util.Random;

public class FootballTeamHeights {

    public static void main(String[] args) {
        int[] heights = generateRandomHeights(11); // Array for 11 players

        int sum = calculateSum(heights);
        double mean = calculateMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        System.out.println("Heights of players: ");
        for (int height : heights) {
            System.out.print(height + " cm  ");
        }
        System.out.println("\n\nSum of heights: " + sum + " cm");
        System.out.println("Mean height: " + mean + " cm");
        System.out.println("Shortest player: " + shortest + " cm");
        System.out.println("Tallest player: " + tallest + " cm");
    }

    
    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            heights[i] = rand.nextInt(101) + 150; // Random number between 150 and 250
        }
        return heights;
    }

    
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    
    public static double calculateMean(int[] arr) {
        return (double) calculateSum(arr) / arr.length;
    }

    
    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    
    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
