import java.util.function.Function;

public class Main5 {
    public static void main(String[] args) {
        Function<String, Integer> checkLength = s -> s.length();
        String msg = "HelloWorld";
        int len = checkLength.apply(msg);
        if (len > 8) System.out.println("Message too long");
    }
}
