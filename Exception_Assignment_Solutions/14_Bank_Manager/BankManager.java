import bm.AccountNotFoundException;
import bm.InsufficientFundsException;
public class BankManager {
    public static void verifyAccount(String id) throws AccountNotFoundException {
        if (!"A1".equals(id)) throw new AccountNotFoundException("Account not found");
    }
    public static void processTransaction(String id, double amt) throws InsufficientFundsException {
        if (amt > 1000) throw new InsufficientFundsException("Not enough funds");
    }
    public static void executeTransaction(String id, double amt) throws Exception {
        verifyAccount(id);
        processTransaction(id, amt);
        System.out.println("Transaction executed");
    }
    public static void main(String[] args) {
        try {
            executeTransaction("X", 2000);
        } catch (AccountNotFoundException e) {
            System.out.println("Verify error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Process error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other error: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.");
        }
    }
}
