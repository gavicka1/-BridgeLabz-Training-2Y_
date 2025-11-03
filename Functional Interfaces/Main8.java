interface Converter {
    static double kmToMiles(double km) { return km * 0.621371; }
    static double kgToLbs(double kg) { return kg * 2.20462; }
}

public class Main8 {
    public static void main(String[] args) {
        System.out.println(Converter.kmToMiles(10));
        System.out.println(Converter.kgToLbs(5));
    }
}
