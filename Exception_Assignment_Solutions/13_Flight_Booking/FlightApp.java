import fl.SeatUnavailableException;
import fl.PaymentFailedException;
import java.util.Random;
public class FlightApp {
    public static void checkSeatAvailability() throws SeatUnavailableException {
        if (new Random().nextBoolean()) throw new SeatUnavailableException("Seat not available");
    }
    public static void processPayment() throws PaymentFailedException {
        if (new Random().nextBoolean()) throw new PaymentFailedException("Payment failed");
    }
    public static void bookTicket() throws Exception {
        checkSeatAvailability();
        processPayment();
        System.out.println("Ticket booked");
    }
    public static void main(String[] args) {
        try {
            bookTicket();
        } catch (SeatUnavailableException e) {
            System.out.println("Booking error: " + e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println("Payment error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other error: " + e.getMessage());
        } finally {
            System.out.println("Thank you for booking with us!");
        }
    }
}
