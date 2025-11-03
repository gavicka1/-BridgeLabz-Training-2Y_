import java.util.*;
import java.util.function.Predicate;

public class Main3 {
    public static void main(String[] args) {
        List<String> alerts = Arrays.asList("Critical", "Normal", "Emergency", "Info");
        Predicate<String> filter = a -> a.equals("Critical") || a.equals("Emergency");
        alerts.stream().filter(filter).forEach(System.out::println);
    }
}
