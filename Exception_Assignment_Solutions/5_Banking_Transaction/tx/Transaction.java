package tx;
import java.util.Random;
public class Transaction {
    private Random r = new Random();
    public void process(double amount, double balance) throws NegativeAmountException, InsufficientFundsException, NetworkFailureException {
        int code = r.nextInt(3);
        if (amount < 0) throw new NegativeAmountException("Negative amount: " + amount);
        if (code == 0 && amount > balance) throw new InsufficientFundsException("Insufficient balance");
        if (code == 1) throw new NetworkFailureException("Network failure occurred");
        System.out.println("Transaction successful for " + amount);
    }
}
