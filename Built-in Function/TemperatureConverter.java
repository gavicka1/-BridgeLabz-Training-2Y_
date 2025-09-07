import java.util.*;

public class TemperatureConverter {
    static double toCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
    static double toFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double f = sc.nextDouble();
        double c = sc.nextDouble();
        System.out.println(f + " F = " + toCelsius(f) + " C");
        System.out.println(c + " C = " + toFahrenheit(c) + " F");
        sc.close();
    }
}
