class TravelDetails {
    String fromCity;
    String toCity;
    double distance;

    TravelDetails(String fromCity, String toCity, double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    void displayTravelInfo() {
        System.out.println("Traveling from " + fromCity + " to " + toCity + " covers " + distance + " km.");
    }
}

class Main {
    public static void main(String[] args) {
        TravelDetails travel = new TravelDetails("Chennai", "Bangalore", 345.6);
        travel.displayTravelInfo();
    }
}
