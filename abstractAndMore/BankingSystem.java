import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber,String holderName,double balance){setAccountNumber(accountNumber);setHolderName(holderName);setBalance(balance);}
    public String getAccountNumber(){return accountNumber;}
    public void setAccountNumber(String a){if(a==null||a.isEmpty()) throw new IllegalArgumentException(); this.accountNumber=a;}
    public String getHolderName(){return holderName;}
    public void setHolderName(String n){if(n==null||n.isEmpty()) throw new IllegalArgumentException(); this.holderName=n;}
    public double getBalance(){return balance;}
    protected void setBalance(double b){this.balance=b;}
    public void deposit(double amount){if(amount<=0) throw new IllegalArgumentException(); setBalance(getBalance()+amount);}
    public void withdraw(double amount){if(amount<=0||amount>getBalance()) throw new IllegalArgumentException(); setBalance(getBalance()-amount);}
    public abstract double calculateInterest();
}

interface Loanable{
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable{
    public SavingsAccount(String acc,String name,double bal){super(acc,name,bal);}
    public double calculateInterest(){return getBalance()*0.04;}
    public boolean applyForLoan(double amount){return calculateLoanEligibility()>=amount;}
    public double calculateLoanEligibility(){return getBalance()*5;}
}

class CurrentAccount extends BankAccount implements Loanable{
    public CurrentAccount(String acc,String name,double bal){super(acc,name,bal);}
    public double calculateInterest(){return 0;}
    public boolean applyForLoan(double amount){return calculateLoanEligibility()>=amount;}
    public double calculateLoanEligibility(){return getBalance()*2;}
}

public class BankingSystem{
    public static void main(String[] args){
        List<BankAccount> accounts=new ArrayList<>();
        SavingsAccount s=new SavingsAccount("S001","Maya",20000);
        CurrentAccount c=new CurrentAccount("C001","Karan",50000);
        accounts.add(s);
        accounts.add(c);
        s.deposit(5000);
        c.withdraw(10000);
        for(BankAccount a:accounts){
            System.out.println(a.getHolderName()+" Acc:"+a.getAccountNumber()+" Balance:"+a.getBalance()+" Interest:"+a.calculateInterest());
            Loanable l=(Loanable)a;
            System.out.println("Loan Eligibility: "+l.calculateLoanEligibility()+" Can apply for 100000: "+l.applyForLoan(100000));
        }
    }
}
