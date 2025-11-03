interface VehicleDashboard {
    void displaySpeed();
    default void displayBattery() { System.out.println("Battery at 80%"); }
}

class ElectricCar implements VehicleDashboard {
    public void displaySpeed() { System.out.println("Speed: 60 km/h"); }
}

class PetrolCar implements VehicleDashboard {
    public void displaySpeed() { System.out.println("Speed: 80 km/h"); }
}

public class Main12 {
    public static void main(String[] args) {
        ElectricCar e = new ElectricCar();
        PetrolCar p = new PetrolCar();
        e.displaySpeed(); e.displayBattery();
        p.displaySpeed();
    }
}
