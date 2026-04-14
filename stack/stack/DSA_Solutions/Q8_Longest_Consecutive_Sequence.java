/**
 * Q8: Longest Consecutive Sequence
 *
 * Problem: Given an unsorted array of integers, find the length of the
 *          longest consecutive elements sequence.
 *          Example: [100, 4, 200, 1, 3, 2] → 4  (sequence: 1, 2, 3, 4)
 *
 * Approach (HashSet):
 *   - Insert all elements into a HashSet for O(1) lookup.
 *   - For each element `n`, check if (n - 1) is NOT in the set.
 *     If true, `n` is the START of a new consecutive sequence.
 *   - Count how long the sequence continues: n, n+1, n+2, …
 *   - Track the maximum length seen.
 *
 * Time Complexity : O(n)  – each element is visited at most twice
 * Space Complexity: O(n)  – HashSet
 */

import java.util.*;

public class Q8_Longest_Consecutive_Sequence {

    static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) numSet.add(n);

        int maxLength = 0;

        for (int n : numSet) {
            // Only start counting when `n` is the beginning of a sequence
            if (!numSet.contains(n - 1)) {
                int currentNum    = n;
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    // Also returns the actual sequence for display
    static List<Integer> getLongestSequence(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) numSet.add(n);

        int bestStart  = nums[0];
        int bestLength = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int cur = n, len = 1;
                while (numSet.contains(cur + 1)) { cur++; len++; }
                if (len > bestLength) { bestLength = len; bestStart = n; }
            }
        }

        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < bestLength; i++) seq.add(bestStart + i);
        return seq;
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        System.out.println("=== Longest Consecutive Sequence ===\n");

        int[][] testCases = {
            {100, 4, 200, 1, 3, 2},
            {0, 3, 7, 2, 5, 8, 4, 6, 0, 1},
            {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6},
            {1}
        };

        for (int[] arr : testCases) {
            int length = longestConsecutive(arr);
            List<Integer> seq = getLongestSequence(arr);
            System.out.println("Array    : " + Arrays.toString(arr));
            System.out.println("Length   : " + length);
            System.out.println("Sequence : " + seq);
            System.out.println();
        }
    }
}
