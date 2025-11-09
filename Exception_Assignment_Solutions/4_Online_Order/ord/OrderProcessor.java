package ord;
import java.util.Random;
public class OrderProcessor {
    private Random r = new Random();
    public void placeOrder() throws OutOfStockException, PaymentFailedException {
        int code = r.nextInt(3);
        if (code == 0) throw new OutOfStockException("Product is out of stock");
        if (code == 1) throw new PaymentFailedException("Payment failed");
        System.out.println("Order placed successfully");
    }
}
