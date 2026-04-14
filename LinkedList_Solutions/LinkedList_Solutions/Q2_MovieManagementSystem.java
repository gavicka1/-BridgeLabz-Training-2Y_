/**
 * Q2: Doubly Linked List - Movie Management System
 *
 * Operations:
 *  1. Add movie at beginning, end, or specific position
 *  2. Remove movie by Title
 *  3. Search by Director or Rating
 *  4. Display forward and reverse
 *  5. Update rating by Title
 */
import java.util.ArrayList;
import java.util.List;

public class Q2_MovieManagementSystem {

    // ── Node ─────────────────────────────────────────────────────────
    static class Movie {
        String title, director;
        int    year;
        double rating;
        Movie  next, prev;

        Movie(String title, String director, int year, double rating) {
            this.title    = title;
            this.director = director;
            this.year     = year;
            this.rating   = rating;
        }
    }

    // ── Doubly Linked List ────────────────────────────────────────────
    static class MovieList {
        Movie head, tail;

        // 1a. Add at beginning
        void addAtBeginning(String title, String director, int year, double rating) {
            Movie node = new Movie(title, director, year, rating);
            if (head == null) { head = tail = node; }
            else { node.next = head; head.prev = node; head = node; }
            System.out.println("Added at beginning: " + title);
        }

        // 1b. Add at end
        void addAtEnd(String title, String director, int year, double rating) {
            Movie node = new Movie(title, director, year, rating);
            if (tail == null) { head = tail = node; }
            else { tail.next = node; node.prev = tail; tail = node; }
            System.out.println("Added at end: " + title);
        }

        // 1c. Add at specific position (1-based)
        void addAtPosition(int pos, String title, String director, int year, double rating) {
            if (pos <= 1) { addAtBeginning(title, director, year, rating); return; }
            Movie node = new Movie(title, director, year, rating);
            Movie cur = head;
            for (int i = 1; i < pos - 1 && cur != null; i++) cur = cur.next;
            if (cur == null || cur.next == null) { addAtEnd(title, director, year, rating); return; }
            node.next       = cur.next;
            node.prev       = cur;
            cur.next.prev   = node;
            cur.next        = node;
            System.out.println("Added at position " + pos + ": " + title);
        }

        // 2. Remove by title
        void removeByTitle(String title) {
            Movie cur = head;
            while (cur != null && !cur.title.equalsIgnoreCase(title)) cur = cur.next;
            if (cur == null) { System.out.println("Movie not found: " + title); return; }
            if (cur.prev != null) cur.prev.next = cur.next; else head = cur.next;
            if (cur.next != null) cur.next.prev = cur.prev; else tail = cur.prev;
            System.out.println("Removed: " + title);
        }

        // 3a. Search by director
        List<Movie> searchByDirector(String director) {
            List<Movie> result = new ArrayList<>();
            Movie cur = head;
            while (cur != null) {
                if (cur.director.equalsIgnoreCase(director)) result.add(cur);
                cur = cur.next;
            }
            return result;
        }

        // 3b. Search by minimum rating
        List<Movie> searchByRating(double minRating) {
            List<Movie> result = new ArrayList<>();
            Movie cur = head;
            while (cur != null) {
                if (cur.rating >= minRating) result.add(cur);
                cur = cur.next;
            }
            return result;
        }

        // 4a. Display forward
        void displayForward() {
            System.out.println("  [Forward]");
            Movie cur = head;
            while (cur != null) {
                System.out.printf("  %-30s | %-20s | %d | %.1f%n",
                        cur.title, cur.director, cur.year, cur.rating);
                cur = cur.next;
            }
        }

        // 4b. Display reverse
        void displayReverse() {
            System.out.println("  [Reverse]");
            Movie cur = tail;
            while (cur != null) {
                System.out.printf("  %-30s | %-20s | %d | %.1f%n",
                        cur.title, cur.director, cur.year, cur.rating);
                cur = cur.prev;
            }
        }

        // 5. Update rating
        void updateRating(String title, double newRating) {
            Movie cur = head;
            while (cur != null && !cur.title.equalsIgnoreCase(title)) cur = cur.next;
            if (cur == null) { System.out.println("Movie not found: " + title); return; }
            cur.rating = newRating;
            System.out.println("Updated rating of '" + title + "' to " + newRating);
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Movie Management System (Doubly Linked List) ===\n");
        MovieList list = new MovieList();

        list.addAtEnd("Inception",       "Christopher Nolan", 2010, 8.8);
        list.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        list.addAtEnd("Interstellar",    "Christopher Nolan", 2014, 8.6);
        list.addAtBeginning("Parasite",  "Bong Joon-ho",     2019, 8.5);
        list.addAtPosition(3, "Dune",    "Denis Villeneuve", 2021, 8.0);

        System.out.println("\n--- Forward Display ---");
        list.displayForward();

        System.out.println("\n--- Reverse Display ---");
        list.displayReverse();

        System.out.println("\n--- Search by Director: Christopher Nolan ---");
        list.searchByDirector("Christopher Nolan")
            .forEach(m -> System.out.println("  " + m.title + " (" + m.year + ")"));

        System.out.println("\n--- Search by Rating >= 8.7 ---");
        list.searchByRating(8.7)
            .forEach(m -> System.out.println("  " + m.title + " -> " + m.rating));

        System.out.println("\n--- Update Rating of Dune to 8.3 ---");
        list.updateRating("Dune", 8.3);

        System.out.println("\n--- Remove 'Inception' ---");
        list.removeByTitle("Inception");

        System.out.println("\n--- Final List (Forward) ---");
        list.displayForward();
    }
}
