/**
 * Q6: Find All Subarrays with Zero Sum
 *
 * Problem: Given an array of integers, find all subarrays whose elements
 *          sum up to zero.
 *
 * Approach (Prefix Sum + HashMap):
 *   - Compute cumulative prefix sum as we iterate.
 *   - Store each prefix sum and the list of indices where it occurred in a HashMap.
 *   - If prefixSum[j] == prefixSum[i-1], then subarray (i..j) sums to zero.
 *   - Special case: if prefixSum itself becomes 0 at index j, subarray (0..j)
 *     sums to zero.
 *
 * Time Complexity : O(n)  – single pass
 * Space Complexity: O(n)  – HashMap
 */

import java.util.*;

public class Q6_Zero_Sum_Subarrays {

    static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();

        // Map from prefix sum → list of indices where this sum was seen
        // We store index as (actual index + 1) to handle the "start from 0" case
        Map<Integer, List<Integer>> prefixMap = new HashMap<>();
        prefixMap.put(0, new ArrayList<>(Arrays.asList(-1))); // base case

        int prefixSum = 0;

        for (int j = 0; j < arr.length; j++) {
            prefixSum += arr[j];

            if (prefixMap.containsKey(prefixSum)) {
                // Every previous occurrence of this prefix sum gives a zero-sum subarray
                for (int i : prefixMap.get(prefixSum)) {
                    result.add(new int[]{i + 1, j}); // subarray from (i+1) to j
                }
            }

            prefixMap.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(j);
        }

        return result;
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        System.out.println("=== Find All Subarrays with Zero Sum ===\n");

        int[][] testCases = {
            {3, 4, -7, 3, 1, 3, 1, -4, -2, -2},
            {1, -1, 2, -2, 3},
            {0, 0, 0},
            {1, 2, 3}
        };

        for (int[] arr : testCases) {
            List<int[]> subarrays = findZeroSumSubarrays(arr);
            System.out.println("Array  : " + Arrays.toString(arr));
            if (subarrays.isEmpty()) {
                System.out.println("  No zero-sum subarray found.");
            } else {
                System.out.println("  Zero-sum subarrays (" + subarrays.size() + "):");
                for (int[] range : subarrays) {
                    int[] sub = Arrays.copyOfRange(arr, range[0], range[1] + 1);
                    System.out.println("    Index [" + range[0] + " to " + range[1] + "] → "
                            + Arrays.toString(sub));
                }
            }
            System.out.println();
        }
    }
}
