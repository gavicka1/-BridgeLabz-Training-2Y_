/**
 * Q4: Sliding Window Maximum
 *
 * Problem: Given an array and a window size k, find the maximum element in
 *          each sliding window of size k as the window moves left to right.
 *
 * Approach (Deque / Monotonic Queue):
 *   - Maintain a Deque that stores INDICES in decreasing order of their values.
 *   - The front of the deque always holds the index of the maximum element
 *     for the current window.
 *   - For each new element at index i:
 *       1. Remove indices from the FRONT that are outside the window (< i-k+1).
 *       2. Remove indices from the BACK whose values <= current value
 *          (they can never be the max while current element is in the window).
 *       3. Add index i to the back.
 *       4. Once i >= k-1, record deque.front() as the window maximum.
 *
 * Time Complexity : O(n)   – each element is added/removed from deque at most once
 * Space Complexity: O(k)   – deque holds at most k indices
 */

import java.util.*;

public class Q4_Sliding_Window_Maximum {

    static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {

            // Step 1: remove indices outside the current window from the front
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Step 2: remove indices from the back whose values are <= nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Step 3: add current index
            deque.offerLast(i);

            // Step 4: record result once the first full window is reached
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        System.out.println("=== Sliding Window Maximum ===\n");

        Object[][] tests = {
            new Object[]{new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3},
            new Object[]{new int[]{9, 11},                     2},
            new Object[]{new int[]{4, -2, 7, 3, 1, 6},        3}
        };

        for (Object[] t : tests) {
            int[] arr = (int[]) t[0];
            int   k   = (int)   t[1];
            int[] res = maxSlidingWindow(arr, k);

            System.out.println("Array  : " + Arrays.toString(arr) + "  k=" + k);
            System.out.println("Maximums: " + Arrays.toString(res));
            System.out.println();
        }

        /*
         * Walkthrough for [1,3,-1,-3,5,3,6,7], k=3:
         *   Window [1,3,-1]  → max = 3
         *   Window [3,-1,-3] → max = 3
         *   Window [-1,-3,5] → max = 5
         *   Window [-3,5,3]  → max = 5
         *   Window [5,3,6]   → max = 6
         *   Window [3,6,7]   → max = 7
         *   Result: [3, 3, 5, 5, 6, 7]
         */
    }
}
