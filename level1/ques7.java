public class ques7 {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double pi = Math.PI;
        double volumeKm = (4.0 / 3) * pi * Math.pow(radiusKm, 3);
        double conversionFactor = 0.621371;
        double radiusMiles = radiusKm * conversionFactor;
        double volumeMiles = (4.0 / 3) * pi * Math.pow(radiusMiles, 3);
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);
    }
}
