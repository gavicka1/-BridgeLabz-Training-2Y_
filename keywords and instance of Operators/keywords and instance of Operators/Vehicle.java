class Vehicle {
    static double registrationFee = 5000;
    final String registrationNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Type: " + vehicleType);
            System.out.println("Registration No: " + registrationNumber);
            System.out.println("Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("Shiva", "Car", "UP01AB1234");
        v.displayDetails();
        Vehicle.updateRegistrationFee(6000);
        v.displayDetails();
    }
}
