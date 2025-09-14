class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateCost() {
        return rentalDays * 1000;
    }

    public static void main(String[] args) {
        CarRental c = new CarRental("Shiva", "SUV", 5);
        System.out.println(c.customerName + " " + c.carModel + " " + c.calculateCost());
    }
}
