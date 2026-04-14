/**
 * Q9: Implement a Custom HashMap
 *
 * Problem: Design and implement a basic HashMap class from scratch with:
 *          - put(key, value)   → insert or update
 *          - get(key)          → retrieve value, or -1 if not found
 *          - remove(key)       → delete key-value pair
 *
 * Approach (Separate Chaining with Linked List):
 *   - Maintain an array of "buckets". Each bucket is a linked list of
 *     (key, value) nodes — this handles hash collisions gracefully.
 *   - Hash function: index = key % capacity
 *   - Dynamic resizing when load factor exceeds 0.75.
 *
 * Time Complexity:
 *   - Average case: O(1) for put / get / remove
 *   - Worst case  : O(n) if all keys hash to the same bucket
 * Space Complexity: O(n)
 */

public class Q9_Custom_HashMap {

    // --------------- Node (key-value pair in a chain) ---------------
    static class Node {
        int key, value;
        Node next;
        Node(int k, int v) { key = k; value = v; }
    }

    // --------------- Custom HashMap implementation ---------------
    static class MyHashMap {
        private static final int INITIAL_CAPACITY = 16;
        private static final double LOAD_FACTOR   = 0.75;

        private Node[] buckets;
        private int    size;
        private int    capacity;

        MyHashMap() {
            capacity = INITIAL_CAPACITY;
            buckets  = new Node[capacity];
            size     = 0;
        }

        // Hash function: maps key to a bucket index
        private int hash(int key) {
            return Math.abs(key % capacity);
        }

        // Insert or update key-value pair
        public void put(int key, int value) {
            // Resize if load factor exceeded
            if ((double) size / capacity >= LOAD_FACTOR) resize();

            int idx  = hash(key);
            Node cur = buckets[idx];

            // Check if key already exists in the chain → update
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                cur = cur.next;
            }

            // Key not found → prepend new node to the chain
            Node newNode = new Node(key, value);
            newNode.next = buckets[idx];
            buckets[idx] = newNode;
            size++;
        }

        // Retrieve value for key, or -1 if not found
        public int get(int key) {
            int idx  = hash(key);
            Node cur = buckets[idx];
            while (cur != null) {
                if (cur.key == key) return cur.value;
                cur = cur.next;
            }
            return -1;
        }

        // Remove the key-value pair
        public void remove(int key) {
            int idx  = hash(key);
            Node cur = buckets[idx];
            Node prev = null;

            while (cur != null) {
                if (cur.key == key) {
                    if (prev == null) buckets[idx] = cur.next;
                    else              prev.next     = cur.next;
                    size--;
                    return;
                }
                prev = cur;
                cur  = cur.next;
            }
        }

        // Resize: double capacity and rehash all existing keys
        private void resize() {
            capacity *= 2;
            Node[] oldBuckets = buckets;
            buckets = new Node[capacity];
            size    = 0;

            for (Node head : oldBuckets) {
                Node cur = head;
                while (cur != null) {
                    put(cur.key, cur.value);
                    cur = cur.next;
                }
            }
        }

        public int size() { return size; }
    }

    // -------------------------  Main / Demo  -------------------------
    public static void main(String[] args) {
        System.out.println("=== Custom HashMap (Separate Chaining) ===\n");

        MyHashMap map = new MyHashMap();

        // Insert
        map.put(1,  10);
        map.put(2,  20);
        map.put(17, 170); // 17 % 16 == 1 → same bucket as key=1 (collision!)
        map.put(3,  30);

        System.out.println("After put(1,10), put(2,20), put(17,170), put(3,30):");
        System.out.println("  get(1)  = " + map.get(1));   // 10
        System.out.println("  get(2)  = " + map.get(2));   // 20
        System.out.println("  get(17) = " + map.get(17));  // 170 (collision handled)
        System.out.println("  get(3)  = " + map.get(3));   // 30
        System.out.println("  get(99) = " + map.get(99));  // -1 (not found)

        // Update
        map.put(2, 200);
        System.out.println("\nAfter put(2, 200) [update]:");
        System.out.println("  get(2)  = " + map.get(2));   // 200

        // Remove
        map.remove(1);
        System.out.println("\nAfter remove(1):");
        System.out.println("  get(1)  = " + map.get(1));   // -1
        System.out.println("  get(17) = " + map.get(17));  // 170 (still there)

        System.out.println("\nFinal size: " + map.size());  // 3
    }
}
