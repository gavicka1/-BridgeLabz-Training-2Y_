import java.util.Scanner;

public class WindChillCalculator {

    // Method to calculate wind chill
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature 
               + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input temperature and wind speed
        System.out.print("Enter temperature in Fahrenheit: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter wind speed in miles per hour: ");
        double windSpeed = sc.nextDouble();

        if (temperature <= 50 && windSpeed >= 3) { 
            double windChill = calculateWindChill(temperature, windSpeed);
            System.out.println("The Wind Chill Temperature is: " + windChill);
        } else {
            System.out.println("Formula not valid for given values (Temp must be <= 50F and Wind Speed >= 3 mph).");
        }

        sc.close();
    }
}
