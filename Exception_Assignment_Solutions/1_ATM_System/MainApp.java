import atm.ATM;
import atm.InsufficientFundsException;
public class MainApp {
    public static void main(String[] args) {
        ATM atm = new ATM(10000);
        try {
            atm.withdraw(15000);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
