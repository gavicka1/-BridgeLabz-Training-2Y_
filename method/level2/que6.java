public class que6 {

    
    private que6() {}

    
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

   
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

   
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    
    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    
    public static void main(String[] args) {
        double fahrenheit = 98.6;
        double celsius = 37;
        double pounds = 150;
        double kilograms = 68;
        double gallons = 10;
        double liters = 25;

        System.out.println(fahrenheit + "°F = " + convertFahrenheitToCelsius(fahrenheit) + "°C");
        System.out.println(celsius + "°C = " + convertCelsiusToFahrenheit(celsius) + "°F");
        System.out.println(pounds + " lbs = " + convertPoundsToKilograms(pounds) + " kg");
        System.out.println(kilograms + " kg = " + convertKilogramsToPounds(kilograms) + " lbs");
        System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");
        System.out.println(liters + " liters = " + convertLitersToGallons(liters) + " gallons");
    }
}
