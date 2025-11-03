import java.util.function.Predicate;

public class Main4 {
    public static void main(String[] args) {
        Predicate<Double> alert = t -> t > 40.0;
        double temp = 42.5;
        if (alert.test(temp)) System.out.println("High Temperature Alert!");
    }
}
