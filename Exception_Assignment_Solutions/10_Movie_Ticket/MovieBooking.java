import mv.InvalidSeatException;
import mv.SeatAlreadyBookedException;
import java.util.*;
public class MovieBooking {
    private Map<String, Boolean> seats = new HashMap<>();
    public MovieBooking() {
        seats.put("A1", true);
        seats.put("A2", true);
    }
    public void book(String seat) throws InvalidSeatException, SeatAlreadyBookedException {
        if (!seats.containsKey(seat)) throw new InvalidSeatException("No such seat: " + seat);
        if (!seats.get(seat)) throw new SeatAlreadyBookedException("Already booked: " + seat);
        seats.put(seat, false);
        System.out.println("Booked: " + seat);
    }
    public static void main(String[] args) {
        MovieBooking m = new MovieBooking();
        try {
            m.book("A3");
        } catch (Exception e) {
            System.out.println("Booking error: " + e.getMessage());
        }
    }
}
