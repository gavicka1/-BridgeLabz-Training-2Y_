/**
 * Q1: Implement a Queue Using Stacks
 *
 * Problem: Design a queue using two stacks such that enqueue and dequeue
 *          operations are performed efficiently.
 *
 * Approach:
 *   - Use two stacks: `inbox` (for enqueue) and `outbox` (for dequeue).
 *   - Enqueue: push directly onto inbox.
 *   - Dequeue: if outbox is empty, transfer all elements from inbox to outbox,
 *              then pop from outbox. This gives FIFO order.
 *
 * Time Complexity:
 *   - Enqueue: O(1)
 *   - Dequeue: Amortized O(1)  (each element is moved at most once)
 * Space Complexity: O(n)
 */

import java.util.Stack;

public class Q1_Queue_Using_Stacks {

    static class MyQueue {
        private Stack<Integer> inbox  = new Stack<>();  // for enqueue
        private Stack<Integer> outbox = new Stack<>();  // for dequeue

        // Add element to the back of the queue
        public void enqueue(int val) {
            inbox.push(val);
        }

        // Remove and return the front element of the queue
        public int dequeue() {
            if (outbox.isEmpty()) {
                // Transfer all elements from inbox to outbox (reverses order)
                while (!inbox.isEmpty()) {
                    outbox.push(inbox.pop());
                }
            }
            if (outbox.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            return outbox.pop();
        }

        // Peek at the front element without removing it
        public int peek() {
            if (outbox.isEmpty()) {
                while (!inbox.isEmpty()) {
                    outbox.push(inbox.pop());
                }
            }
            if (outbox.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            return outbox.peek();
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return inbox.isEmpty() && outbox.isEmpty();
        }
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println("=== Queue Using Two Stacks ===\n");

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Enqueued: 10, 20, 30");

        System.out.println("Peek (front): " + queue.peek());   // 10
        System.out.println("Dequeue: "      + queue.dequeue()); // 10
        System.out.println("Dequeue: "      + queue.dequeue()); // 20

        queue.enqueue(40);
        System.out.println("Enqueued: 40");

        System.out.println("Dequeue: " + queue.dequeue()); // 30
        System.out.println("Dequeue: " + queue.dequeue()); // 40
        System.out.println("Is empty: "  + queue.isEmpty()); // true
    }
}
