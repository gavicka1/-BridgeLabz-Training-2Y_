/**
 * Q9: Circular Linked List - Online Ticket Reservation System
 *
 * Operations:
 *  1. Add ticket reservation at end of circular list
 *  2. Remove ticket by Ticket ID
 *  3. Display all current tickets
 *  4. Search by Customer Name or Movie Name
 *  5. Calculate total number of booked tickets
 */
import java.util.ArrayList;
import java.util.List;

public class Q9_TicketReservationSystem {

    // ── Node ─────────────────────────────────────────────────────────
    static class Ticket {
        int    ticketId, seatNumber;
        String customerName, movieName, bookingTime;
        Ticket next;

        Ticket(int ticketId, String customerName, String movieName,
               int seatNumber, String bookingTime) {
            this.ticketId     = ticketId;
            this.customerName = customerName;
            this.movieName    = movieName;
            this.seatNumber   = seatNumber;
            this.bookingTime  = bookingTime;
        }
    }

    // ── Circular Linked List ─────────────────────────────────────────
    static class ReservationSystem {
        Ticket head, tail;

        boolean isEmpty() { return head == null; }

        // 1. Add ticket at end
        void addTicket(int id, String customer, String movie, int seat, String time) {
            Ticket node = new Ticket(id, customer, movie, seat, time);
            if (head == null) {
                head = tail = node;
                node.next = head;
            } else {
                tail.next = node;
                node.next = head;
                tail      = node;
            }
            System.out.printf("Booked: Ticket#%d | %s | %s | Seat %d%n",
                    id, customer, movie, seat);
        }

        // 2. Remove by Ticket ID
        void removeTicket(int ticketId) {
            if (isEmpty()) { System.out.println("No tickets booked."); return; }

            // Only one ticket
            if (head == tail && head.ticketId == ticketId) {
                System.out.println("Cancelled: Ticket#" + ticketId);
                head = tail = null; return;
            }
            // Head is target
            if (head.ticketId == ticketId) {
                System.out.println("Cancelled: Ticket#" + ticketId + " (" + head.customerName + ")");
                head      = head.next;
                tail.next = head; return;
            }
            // Search rest
            Ticket prev = head, cur = head.next;
            while (cur != head && cur.ticketId != ticketId) { prev = cur; cur = cur.next; }
            if (cur == head) { System.out.println("Ticket#" + ticketId + " not found."); return; }
            if (cur == tail) tail = prev;
            prev.next = cur.next;
            System.out.println("Cancelled: Ticket#" + ticketId + " (" + cur.customerName + ")");
        }

        // 3. Display all tickets
        void displayAll() {
            if (isEmpty()) { System.out.println("  No tickets booked."); return; }
            System.out.println("  ID  | Customer Name       | Movie                | Seat | Time");
            System.out.println("  ----|---------------------|----------------------|------|--------");
            Ticket cur = head;
            do {
                System.out.printf("  %-3d | %-19s | %-20s | %-4d | %s%n",
                        cur.ticketId, cur.customerName, cur.movieName,
                        cur.seatNumber, cur.bookingTime);
                cur = cur.next;
            } while (cur != head);
        }

        // 4a. Search by Customer Name
        List<Ticket> searchByCustomer(String name) {
            List<Ticket> result = new ArrayList<>();
            if (isEmpty()) return result;
            Ticket cur = head;
            do {
                if (cur.customerName.equalsIgnoreCase(name)) result.add(cur);
                cur = cur.next;
            } while (cur != head);
            return result;
        }

        // 4b. Search by Movie Name
        List<Ticket> searchByMovie(String movie) {
            List<Ticket> result = new ArrayList<>();
            if (isEmpty()) return result;
            Ticket cur = head;
            do {
                if (cur.movieName.equalsIgnoreCase(movie)) result.add(cur);
                cur = cur.next;
            } while (cur != head);
            return result;
        }

        // 5. Count total booked tickets
        int totalTickets() {
            if (isEmpty()) return 0;
            int count = 0;
            Ticket cur = head;
            do { count++; cur = cur.next; } while (cur != head);
            return count;
        }
    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Online Ticket Reservation System (Circular Linked List) ===\n");
        ReservationSystem system = new ReservationSystem();

        System.out.println("--- Booking Tickets ---");
        system.addTicket(1001, "Alice",   "Inception",       12, "10:00 AM");
        system.addTicket(1002, "Bob",     "Interstellar",    5,  "11:30 AM");
        system.addTicket(1003, "Charlie", "Inception",       8,  "10:00 AM");
        system.addTicket(1004, "Diana",   "Dune Part Two",   3,  "02:00 PM");
        system.addTicket(1005, "Eve",     "Interstellar",    14, "11:30 AM");
        system.addTicket(1006, "Alice",   "Dune Part Two",   7,  "02:00 PM");

        System.out.println("\n--- All Booked Tickets ---");
        system.displayAll();

        System.out.println("\n--- Total Booked: " + system.totalTickets() + " ---");

        System.out.println("\n--- Search by Customer: Alice ---");
        system.searchByCustomer("Alice")
              .forEach(t -> System.out.printf("  Ticket#%d | %s | Seat %d%n",
                      t.ticketId, t.movieName, t.seatNumber));

        System.out.println("\n--- Search by Movie: Interstellar ---");
        system.searchByMovie("Interstellar")
              .forEach(t -> System.out.printf("  Ticket#%d | %s | Seat %d%n",
                      t.ticketId, t.customerName, t.seatNumber));

        System.out.println("\n--- Cancel Ticket #1003 ---");
        system.removeTicket(1003);

        System.out.println("\n--- Cancel Ticket #1001 (head node) ---");
        system.removeTicket(1001);

        System.out.println("\n--- Remaining Tickets ---");
        system.displayAll();

        System.out.println("\n--- Final Total: " + system.totalTickets() + " ---");
    }
}
