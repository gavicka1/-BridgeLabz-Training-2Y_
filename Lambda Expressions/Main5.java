import java.util.*;
import java.util.stream.Collectors;

public class Main5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Ravi", "Sneha");
        List<String> upper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        upper.forEach(System.out::println);
    }
}
