import ord.OrderProcessor;
import ord.OutOfStockException;
import ord.PaymentFailedException;
public class MainApp {
    public static void main(String[] args) {
        OrderProcessor o = new OrderProcessor();
        try {
            o.placeOrder();
        } catch (OutOfStockException e) {
            System.out.println("Order error: " + e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println("Order error: " + e.getMessage());
        }
    }
}
