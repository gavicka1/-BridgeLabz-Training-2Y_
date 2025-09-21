class BankAccount {
    int accountNumber;
    double balance;
    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    void displayAccountType() {
        System.out.println("Savings Account with Interest: " + interestRate);
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    void displayAccountType() {
        System.out.println("Checking Account with Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int duration;
    FixedDepositAccount(int accountNumber, double balance, int duration) {
        super(accountNumber, balance);
        this.duration = duration;
    }
    void displayAccountType() {
        System.out.println("Fixed Deposit Account Duration: " + duration + " years");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(101, 50000, 5.5);
        CheckingAccount ca = new CheckingAccount(102, 30000, 20000);
        FixedDepositAccount fda = new FixedDepositAccount(103, 100000, 5);
        sa.displayAccountType();
        ca.displayAccountType();
        fda.displayAccountType();
    }
}
