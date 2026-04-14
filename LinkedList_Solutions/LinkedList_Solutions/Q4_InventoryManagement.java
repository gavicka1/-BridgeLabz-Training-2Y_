/**
 * Q4: Singly Linked List - Inventory Management System
 *
 * Operations:
 *  1. Add item at beginning, end, or specific position
 *  2. Remove item by Item ID
 *  3. Update quantity by Item ID
 *  4. Search by Item ID or Item Name
 *  5. Calculate total inventory value (Price * Quantity)
 *  6. Sort by Item Name or Price (merge sort on linked list)
 */
public class Q4_InventoryManagement {

    // ── Node ─────────────────────────────────────────────────────────
    static class Item {
        int    itemId, quantity;
        String itemName;
        double price;
        Item   next;

        Item(int itemId, String itemName, int quantity, double price) {
            this.itemId   = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price    = price;
        }
    }

    // ── Singly Linked List ────────────────────────────────────────────
    static class Inventory {
        Item head;

        // 1a. Add at beginning
        void addAtBeginning(int id, String name, int qty, double price) {
            Item node = new Item(id, name, qty, price);
            node.next = head;
            head = node;
            System.out.println("Added at beginning: " + name);
        }

        // 1b. Add at end
        void addAtEnd(int id, String name, int qty, double price) {
            Item node = new Item(id, name, qty, price);
            if (head == null) { head = node; System.out.println("Added: " + name); return; }
            Item cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
            System.out.println("Added at end: " + name);
        }

        // 1c. Add at specific position
        void addAtPosition(int pos, int id, String name, int qty, double price) {
            if (pos <= 1) { addAtBeginning(id, name, qty, price); return; }
            Item node = new Item(id, name, qty, price);
            Item cur  = head;
            for (int i = 1; i < pos - 1 && cur != null; i++) cur = cur.next;
            if (cur == null) { addAtEnd(id, name, qty, price); return; }
            node.next = cur.next;
            cur.next  = node;
            System.out.println("Added at position " + pos + ": " + name);
        }

        // 2. Remove by Item ID
        void removeById(int itemId) {
            if (head == null) { System.out.println("Inventory empty."); return; }
            if (head.itemId == itemId) {
                System.out.println("Removed: " + head.itemName);
                head = head.next; return;
            }
            Item cur = head;
            while (cur.next != null && cur.next.itemId != itemId) cur = cur.next;
            if (cur.next == null) { System.out.println("Item ID " + itemId + " not found."); return; }
            System.out.println("Removed: " + cur.next.itemName);
            cur.next = cur.next.next;
        }

        // 3. Update quantity
        void updateQuantity(int itemId, int newQty) {
            Item cur = head;
            while (cur != null && cur.itemId != itemId) cur = cur.next;
            if (cur == null) { System.out.println("Item ID " + itemId + " not found."); return; }
            cur.quantity = newQty;
            System.out.println("Updated quantity of '" + cur.itemName + "' to " + newQty);
        }

        // 4a. Search by ID
        Item searchById(int itemId) {
            Item cur = head;
            while (cur != null) { if (cur.itemId == itemId) return cur; cur = cur.next; }
            return null;
        }

        // 4b. Search by Name (case-insensitive)
        Item searchByName(String name) {
            Item cur = head;
            while (cur != null) { if (cur.itemName.equalsIgnoreCase(name)) return cur; cur = cur.next; }
            return null;
        }

        // 5. Total inventory value
        double totalValue() {
            double total = 0;
            Item cur = head;
            while (cur != null) { total += cur.price * cur.quantity; cur = cur.next; }
            return total;
        }

        // 6. Merge sort on linked list ──────────────────────────────
        Item mergeSort(Item node, boolean byName) {
            if (node == null || node.next == null) return node;
            Item mid   = getMiddle(node);
            Item right = mid.next;
            mid.next   = null;
            Item left  = mergeSort(node,  byName);
            right      = mergeSort(right, byName);
            return merge(left, right, byName);
        }

        Item merge(Item a, Item b, boolean byName) {
            if (a == null) return b;
            if (b == null) return a;
            boolean aFirst = byName
                    ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                    : a.price <= b.price;
            if (aFirst) { a.next = merge(a.next, b, byName); return a; }
            else        { b.next = merge(a, b.next, byName); return b; }
        }

        Item getMiddle(Item node) {
            Item slow = node, fast = node.next;
            while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
            return slow;
        }

        void sortByName()  { head = mergeSort(head, true);  System.out.println("Sorted by Name."); }
        void sortByPrice() { head = mergeSort(head, false); System.out.println("Sorted by Price."); }

        // Display
        void display() {
            System.out.println("  ID  | Item Name            | Qty | Price   | Value");
            System.out.println("  ----|----------------------|-----|---------|--------");
            Item cur = head;
            while (cur != null) {
                System.out.printf("  %-3d | %-20s | %-3d | %-7.2f | %.2f%n",
                        cur.itemId, cur.itemName, cur.quantity, cur.price,
                        cur.price * cur.quantity);
                cur = cur.next;
            }
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Inventory Management System (Singly Linked List) ===\n");
        Inventory inv = new Inventory();

        inv.addAtEnd(201, "Laptop",     10, 75000.00);
        inv.addAtEnd(202, "Mouse",      50,   500.00);
        inv.addAtEnd(203, "Keyboard",   30,  1200.00);
        inv.addAtEnd(204, "Monitor",    15, 18000.00);
        inv.addAtBeginning(205, "Desk",  5, 12000.00);

        System.out.println("\n--- All Items ---");
        inv.display();

        System.out.printf("%n--- Total Inventory Value: Rs. %.2f ---%n", inv.totalValue());

        System.out.println("\n--- Search by ID 203 ---");
        Item it = inv.searchById(203);
        if (it != null) System.out.println("Found: " + it.itemName + " | Qty: " + it.quantity);

        System.out.println("\n--- Update Quantity of ID 202 to 80 ---");
        inv.updateQuantity(202, 80);

        System.out.println("\n--- Remove ID 205 ---");
        inv.removeById(205);

        System.out.println("\n--- Sort by Price ---");
        inv.sortByPrice();
        inv.display();

        System.out.println("\n--- Sort by Name ---");
        inv.sortByName();
        inv.display();
    }
}
