interface SensitiveData {}

class UserInfo implements SensitiveData {
    String name = "Shiva";
    String password = "1234";
}

public class Main15 {
    public static void main(String[] args) {
        UserInfo u = new UserInfo();
        if (u instanceof SensitiveData) System.out.println("Encrypt before storing");
    }
}
