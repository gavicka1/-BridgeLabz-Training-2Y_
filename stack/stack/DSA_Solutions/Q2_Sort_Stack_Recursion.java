/**
 * Q2: Sort a Stack Using Recursion
 *
 * Problem: Given a stack, sort its elements in ascending order (smallest on top)
 *          using only recursion — no extra data structures.
 *
 * Approach:
 *   1. sortStack(stack):
 *      - Pop the top element `temp`.
 *      - Recursively sort the remaining stack.
 *      - Insert `temp` back at the correct sorted position using insertSorted().
 *
 *   2. insertSorted(stack, element):
 *      - If stack is empty, or top >= element, push element and return.
 *      - Else pop the top, recurse for insertion, then push the top back.
 *
 * Time Complexity : O(n²)   – each insertion may scan all elements
 * Space Complexity: O(n)    – recursion call stack
 */

import java.util.Stack;

public class Q2_Sort_Stack_Recursion {

    // Insert `element` into its correct sorted position in the stack
    static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: stack empty, or element is smaller than or equal to top → just push
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        // Current top is larger — pop it, recurse, then restore it
        int top = stack.pop();
        insertSorted(stack, element);
        stack.push(top);
    }

    // Sort the entire stack in ascending order (smallest on top)
    static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        // Remove the top element
        int top = stack.pop();

        // Sort the remaining stack
        sortStack(stack);

        // Insert the removed element at its correct position
        insertSorted(stack, top);
    }

    // Helper: print stack without destroying it
    static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) temp.push(stack.pop());

        System.out.print("Bottom → ");
        while (!temp.isEmpty()) {
            int val = temp.pop();
            System.out.print(val + " ");
            stack.push(val);
        }
        System.out.println("← Top");
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int[] input = {34, 3, 31, 98, 92, 23};
        for (int v : input) stack.push(v);

        System.out.println("=== Sort a Stack Using Recursion ===\n");
        System.out.print("Before sorting: ");
        printStack(stack);

        sortStack(stack);

        System.out.print("After  sorting: ");
        printStack(stack);
        // Expected: smallest on top → 3 23 31 34 92 98 (top = 3)
    }
}
