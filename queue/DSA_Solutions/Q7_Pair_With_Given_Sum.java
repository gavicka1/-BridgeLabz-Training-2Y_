/**
 * Q7: Check for a Pair with Given Sum in an Array
 *
 * Problem: Given an array of integers and a target sum, determine whether there
 *          exists a pair of elements (at different indices) whose sum equals
 *          the target. If yes, print the pair.
 *
 * Approach (HashMap):
 *   - For each element `num`, check if `target - num` already exists in the map.
 *   - If yes  → pair found: (num, target - num).
 *   - If no   → store `num` in the map and continue.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

public class Q7_Pair_With_Given_Sum {

    static int[] findPair(int[] arr, int target) {
        // Map from value → index where it was seen
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (seen.containsKey(complement)) {
                // Return both indices (complement's index, current index)
                return new int[]{seen.get(complement), i};
            }
            seen.put(arr[i], i);
        }
        return null; // no pair found
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        System.out.println("=== Check for a Pair with Given Sum ===\n");

        Object[][] tests = {
            new Object[]{new int[]{2, 7, 11, 15}, 9},
            new Object[]{new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10},
            new Object[]{new int[]{1, 2, 3, 4, 5}, 10},
            new Object[]{new int[]{0, -1, 2, -3, 1}, -2}
        };

        for (Object[] t : tests) {
            int[] arr    = (int[]) t[0];
            int   target = (int)   t[1];
            int[] result = findPair(arr, target);

            System.out.println("Array  : " + Arrays.toString(arr));
            System.out.println("Target : " + target);

            if (result != null) {
                System.out.println("Pair found at indices [" + result[0] + ", " + result[1] + "]"
                    + " → values (" + arr[result[0]] + " + " + arr[result[1]] + " = " + target + ")");
            } else {
                System.out.println("No pair found with sum = " + target);
            }
            System.out.println();
        }
    }
}
