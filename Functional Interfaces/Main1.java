interface SmartDevice {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevice {
    public void turnOn() { System.out.println("Light is ON"); }
    public void turnOff() { System.out.println("Light is OFF"); }
}

class AC implements SmartDevice {
    public void turnOn() { System.out.println("AC is ON"); }
    public void turnOff() { System.out.println("AC is OFF"); }
}

class TV implements SmartDevice {
    public void turnOn() { System.out.println("TV is ON"); }
    public void turnOff() { System.out.println("TV is OFF"); }
}

public class Main1 {
    public static void main(String[] args) {
        SmartDevice s1 = new Light();
        SmartDevice s2 = new AC();
        SmartDevice s3 = new TV();
        s1.turnOn(); s2.turnOff(); s3.turnOn();
    }
}
