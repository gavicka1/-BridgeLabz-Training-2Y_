/**
 * Q5: Doubly Linked List - Library Management System
 *
 * Operations:
 *  1. Add book at beginning, end, or specific position
 *  2. Remove book by Book ID
 *  3. Search by Title or Author
 *  4. Update availability status
 *  5. Display forward and reverse
 *  6. Count total books
 */
import java.util.ArrayList;
import java.util.List;

public class Q5_LibraryManagement {

    // ── Node ─────────────────────────────────────────────────────────
    static class Book {
        int    bookId;
        String title, author, genre;
        boolean available;
        Book next, prev;

        Book(int bookId, String title, String author, String genre, boolean available) {
            this.bookId    = bookId;
            this.title     = title;
            this.author    = author;
            this.genre     = genre;
            this.available = available;
        }
    }

    // ── Doubly Linked List ────────────────────────────────────────────
    static class Library {
        Book head, tail;

        // 1a. Add at beginning
        void addAtBeginning(int id, String title, String author, String genre, boolean avail) {
            Book node = new Book(id, title, author, genre, avail);
            if (head == null) { head = tail = node; }
            else { node.next = head; head.prev = node; head = node; }
            System.out.println("Added at beginning: " + title);
        }

        // 1b. Add at end
        void addAtEnd(int id, String title, String author, String genre, boolean avail) {
            Book node = new Book(id, title, author, genre, avail);
            if (tail == null) { head = tail = node; }
            else { tail.next = node; node.prev = tail; tail = node; }
            System.out.println("Added: " + title);
        }

        // 1c. Add at specific position (1-based)
        void addAtPosition(int pos, int id, String title, String author, String genre, boolean avail) {
            if (pos <= 1) { addAtBeginning(id, title, author, genre, avail); return; }
            Book cur = head;
            for (int i = 1; i < pos - 1 && cur != null; i++) cur = cur.next;
            if (cur == null || cur.next == null) { addAtEnd(id, title, author, genre, avail); return; }
            Book node = new Book(id, title, author, genre, avail);
            node.next     = cur.next;
            node.prev     = cur;
            cur.next.prev = node;
            cur.next      = node;
            System.out.println("Added at position " + pos + ": " + title);
        }

        // 2. Remove by Book ID
        void removeById(int bookId) {
            Book cur = head;
            while (cur != null && cur.bookId != bookId) cur = cur.next;
            if (cur == null) { System.out.println("Book ID " + bookId + " not found."); return; }
            if (cur.prev != null) cur.prev.next = cur.next; else head = cur.next;
            if (cur.next != null) cur.next.prev = cur.prev; else tail = cur.prev;
            System.out.println("Removed: " + cur.title);
        }

        // 3a. Search by title
        Book searchByTitle(String title) {
            Book cur = head;
            while (cur != null) {
                if (cur.title.equalsIgnoreCase(title)) return cur;
                cur = cur.next;
            }
            return null;
        }

        // 3b. Search by author
        List<Book> searchByAuthor(String author) {
            List<Book> result = new ArrayList<>();
            Book cur = head;
            while (cur != null) {
                if (cur.author.equalsIgnoreCase(author)) result.add(cur);
                cur = cur.next;
            }
            return result;
        }

        // 4. Update availability
        void updateAvailability(int bookId, boolean status) {
            Book cur = head;
            while (cur != null && cur.bookId != bookId) cur = cur.next;
            if (cur == null) { System.out.println("Book ID " + bookId + " not found."); return; }
            cur.available = status;
            System.out.println("'" + cur.title + "' availability set to: " + (status ? "Available" : "Not Available"));
        }

        // 5a. Display forward
        void displayForward() {
            System.out.println("  [Forward]");
            printHeader();
            Book cur = head;
            while (cur != null) { printBook(cur); cur = cur.next; }
        }

        // 5b. Display reverse
        void displayReverse() {
            System.out.println("  [Reverse]");
            printHeader();
            Book cur = tail;
            while (cur != null) { printBook(cur); cur = cur.prev; }
        }

        void printHeader() {
            System.out.println("  ID  | Title                          | Author              | Genre      | Status");
            System.out.println("  ----|--------------------------------|---------------------|------------|--------");
        }

        void printBook(Book b) {
            System.out.printf("  %-3d | %-30s | %-19s | %-10s | %s%n",
                    b.bookId, b.title, b.author, b.genre,
                    b.available ? "Available" : "Checked Out");
        }

        // 6. Count books
        int count() {
            int cnt = 0;
            Book cur = head;
            while (cur != null) { cnt++; cur = cur.next; }
            return cnt;
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Library Management System (Doubly Linked List) ===\n");
        Library lib = new Library();

        lib.addAtEnd(301, "Clean Code",              "Robert C. Martin", "Tech",    true);
        lib.addAtEnd(302, "The Pragmatic Programmer", "Andrew Hunt",      "Tech",    true);
        lib.addAtEnd(303, "Design Patterns",          "Gang of Four",     "Tech",    false);
        lib.addAtEnd(304, "Sapiens",                  "Yuval Harari",     "History", true);
        lib.addAtBeginning(305, "Atomic Habits",      "James Clear",      "Self-Help", true);
        lib.addAtPosition(3, 306, "Dune",             "Frank Herbert",    "Sci-Fi",  true);

        System.out.println("\n--- Forward Display ---");
        lib.displayForward();

        System.out.println("\n--- Reverse Display ---");
        lib.displayReverse();

        System.out.println("\n--- Total Books: " + lib.count() + " ---");

        System.out.println("\n--- Search by Title 'Sapiens' ---");
        Book b = lib.searchByTitle("Sapiens");
        if (b != null) System.out.println("Found: " + b.title + " by " + b.author);

        System.out.println("\n--- Search by Author 'Robert C. Martin' ---");
        lib.searchByAuthor("Robert C. Martin")
           .forEach(bk -> System.out.println("  " + bk.title));

        System.out.println("\n--- Update Availability of ID 302 ---");
        lib.updateAvailability(302, false);

        System.out.println("\n--- Remove Book ID 303 ---");
        lib.removeById(303);

        System.out.println("\n--- Final Count: " + lib.count() + " books ---");
    }
}
