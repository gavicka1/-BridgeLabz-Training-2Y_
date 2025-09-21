class Device {
    int deviceId;
    String status;
    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    void displayStatus() {
        System.out.println("Device ID: " + deviceId + " Status: " + status);
    }
}

class Thermostat extends Device {
    int temperatureSetting;
    Thermostat(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature: " + temperatureSetting);
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Thermostat t = new Thermostat(101, "ON", 24);
        t.displayStatus();
    }
}
