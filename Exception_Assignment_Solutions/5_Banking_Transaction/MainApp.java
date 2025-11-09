import tx.Transaction;
import tx.NegativeAmountException;
import tx.InsufficientFundsException;
import tx.NetworkFailureException;
public class MainApp {
    public static void main(String[] args) {
        Transaction t = new Transaction();
        try {
            t.process(2000, 1500);
        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NetworkFailureException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
