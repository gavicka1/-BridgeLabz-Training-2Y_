package atm;
public class ATM {
    private int balance;
    public ATM(int balance) { this.balance = balance; }
    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) throw new InsufficientFundsException("Insufficient balance: " + amount);
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " Remaining: " + balance);
    }
}
