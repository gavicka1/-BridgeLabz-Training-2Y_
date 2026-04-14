/**
 * Q10: Two Sum Problem
 *
 * Problem: Given an array of integers and a target sum, return the INDICES of
 *          the two numbers that add up to the target.
 *          Assume exactly one solution exists, and the same element cannot be
 *          used twice.
 *
 * Approach (HashMap — single pass):
 *   - As we iterate through the array, for each element `nums[i]`:
 *       1. Compute complement = target - nums[i].
 *       2. If complement is already in the map → return [map.get(complement), i].
 *       3. Otherwise store nums[i] → i in the map and move on.
 *
 * Why this works: By the time we check nums[i], every element before index i
 * is already in the map. So if nums[j] + nums[i] == target (j < i), we find it
 * the moment we reach i.
 *
 * Time Complexity : O(n)   – single pass
 * Space Complexity: O(n)   – HashMap
 */

import java.util.*;

public class Q10_Two_Sum {

    static int[] twoSum(int[] nums, int target) {
        // Map from value → index
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }
            indexMap.put(nums[i], i);
        }
        // Problem guarantees a solution exists, but handle gracefully:
        return new int[]{-1, -1};
    }

    // Bonus: find ALL pairs (for arrays that may have multiple solutions)
    static List<int[]> twoSumAll(int[] nums, int target) {
        List<int[]> results = new ArrayList<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                for (int j : indexMap.get(complement)) {
                    results.add(new int[]{j, i});
                }
            }
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        return results;
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        System.out.println("=== Two Sum Problem ===\n");

        // --- Standard Two Sum (single solution) ---
        Object[][] tests = {
            new Object[]{new int[]{2,  7, 11, 15}, 9},
            new Object[]{new int[]{3,  2,  4},     6},
            new Object[]{new int[]{3,  3},         6},
            new Object[]{new int[]{-3, 4,  3, 90}, 0}
        };

        System.out.println("--- Single solution ---");
        for (Object[] t : tests) {
            int[] nums   = (int[]) t[0];
            int   target = (int)   t[1];
            int[] ans    = twoSum(nums, target);

            System.out.println("nums=" + Arrays.toString(nums) + "  target=" + target);
            if (ans[0] != -1) {
                System.out.println("  Indices: [" + ans[0] + ", " + ans[1] + "]"
                    + "  → values (" + nums[ans[0]] + " + " + nums[ans[1]] + " = " + target + ")");
            } else {
                System.out.println("  No solution found.");
            }
            System.out.println();
        }

        // --- Bonus: Multiple solutions ---
        System.out.println("--- All pairs (bonus) ---");
        int[] multi  = {1, 5, 3, 3, 2, 4};
        int   target = 6;
        List<int[]> all = twoSumAll(multi, target);
        System.out.println("nums=" + Arrays.toString(multi) + "  target=" + target);
        for (int[] pair : all) {
            System.out.println("  Indices [" + pair[0] + ", " + pair[1] + "]"
                + " → (" + multi[pair[0]] + " + " + multi[pair[1]] + ")");
        }
    }
}
