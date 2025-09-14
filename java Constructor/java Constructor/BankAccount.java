class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(int num, String holder, double bal) {
        super(num, holder, bal);
    }

    void show() {
        System.out.println(accountNumber + " " + accountHolder);
    }

    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(101, "Shiva", 5000);
        s.show();
        s.deposit(2000);
        System.out.println(s.getBalance());
    }
}
