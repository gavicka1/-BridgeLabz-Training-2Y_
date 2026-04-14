/**
 * Q3: Stock Span Problem
 *
 * Problem: For each day in a stock price array, calculate the span — the number
 *          of consecutive days (including today) for which the stock price was
 *          less than or equal to today's price.
 *
 * Approach:
 *   - Use a stack that stores INDICES of prices in decreasing order of price.
 *   - For each day i:
 *       • Pop all indices from the stack where price[index] <= price[i].
 *       • If stack is empty, span = i + 1 (all previous days qualify).
 *       • Otherwise, span = i - stack.peek() (days since last greater price).
 *       • Push index i onto the stack.
 *
 * Time Complexity : O(n)   – each index is pushed and popped at most once
 * Space Complexity: O(n)   – stack
 */

import java.util.Arrays;
import java.util.Stack;

public class Q3_Stock_Span_Problem {

    static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> indexStack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Pop elements while stack top has price <= current price
            while (!indexStack.isEmpty() && prices[indexStack.peek()] <= prices[i]) {
                indexStack.pop();
            }

            // If stack is empty, all previous days have lower/equal prices
            span[i] = indexStack.isEmpty() ? (i + 1) : (i - indexStack.peek());

            indexStack.push(i);
        }
        return span;
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        System.out.println("=== Stock Span Problem ===\n");

        int[][] testCases = {
            {100, 80, 60, 70, 60, 75, 85},
            {10, 4, 5, 90, 120, 80},
            {10, 10, 10, 10}
        };

        for (int[] prices : testCases) {
            int[] span = calculateSpan(prices);
            System.out.println("Prices : " + Arrays.toString(prices));
            System.out.println("Spans  : " + Arrays.toString(span));
            System.out.println();
        }

        /*
         * Walkthrough for {100, 80, 60, 70, 60, 75, 85}:
         *   Day 0 (100): no previous day greater → span = 1
         *   Day 1 ( 80): 100 > 80              → span = 1
         *   Day 2 ( 60): 80 > 60               → span = 1
         *   Day 3 ( 70): 60 <= 70, 80 > 70     → span = 2  (days 2,3)
         *   Day 4 ( 60): 70 > 60               → span = 1
         *   Day 5 ( 75): 60<=75, 70<=75, 80>75 → span = 4  (days 2,3,4,5)
         *   Day 6 ( 85): 75<=85, 80<=85,100>85 → span = 6  (days 1-6)
         *   Result: [1, 1, 1, 2, 1, 4, 6]
         */
    }
}
