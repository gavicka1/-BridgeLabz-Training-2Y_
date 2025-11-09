import com.bank.util.InterestCalculator;
public class MainApp {
    public static void main(String[] args) {
        InterestCalculator i = new InterestCalculator();
        System.out.println("SI: " + i.si(10000, 5, 2));
        System.out.println("CI: " + i.ci(10000, 5, 2));
    }
}