public class que5 {

    
    private static final double YARDS_TO_FEET = 3.0;
    private static final double FEET_TO_YARDS = 0.333333;
    private static final double METERS_TO_INCHES = 39.3701;
    private static final double INCHES_TO_METERS = 0.0254;
    private static final double INCHES_TO_CM = 2.54;

    
    private que5() {}

    
    public static double convertYardsToFeet(double yards) {
        return yards * YARDS_TO_FEET;
    }

    
    public static double convertFeetToYards(double feet) {
        return feet * FEET_TO_YARDS;
    }

    
    public static double convertMetersToInches(double meters) {
        return meters * METERS_TO_INCHES;
    }

    
    public static double convertInchesToMeters(double inches) {
        return inches * INCHES_TO_METERS;
    }

    
    public static double convertInchesToCentimeters(double inches) {
        return inches * INCHES_TO_CM;
    }

    
    public static void main(String[] args) {
        double yards = 5;
        double feet = 15;
        double meters = 2;
        double inches = 10;

        System.out.println(yards + " yards = " + convertYardsToFeet(yards) + " feet");
        System.out.println(feet + " feet = " + convertFeetToYards(feet) + " yards");
        System.out.println(meters + " meters = " + convertMetersToInches(meters) + " inches");
        System.out.println(inches + " inches = " + convertInchesToMeters(inches) + " meters");
        System.out.println(inches + " inches = " + convertInchesToCentimeters(inches) + " cm");
    }
}
