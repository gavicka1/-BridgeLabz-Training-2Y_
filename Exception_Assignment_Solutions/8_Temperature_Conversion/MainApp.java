import tem.InvalidTemperatureException;
public class MainApp {
    public static void main(String[] args) {
        try {
            convert( -300, "C");
        } catch (InvalidTemperatureException e) {
            System.out.println("Error: Temperature below absolute zero is not possible!");
        }
    }
    static void convert(double value, String unit) throws InvalidTemperatureException {
        if ("C".equalsIgnoreCase(unit) && value < -273.15) throw new InvalidTemperatureException("Too low");
        if ("F".equalsIgnoreCase(unit) && value < -459.67) throw new InvalidTemperatureException("Too low");
        if ("C".equalsIgnoreCase(unit)) {
            double f = value * 9/5 + 32;
            System.out.println(value + "C = " + f + "F");
        } else {
            double c = (value - 32) * 5/9;
            System.out.println(value + "F = " + c + "C");
        }
    }
}
