interface SecurityUtils {
    static boolean isStrong(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }
}

public class Main7 {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrong("Pass1234"));
    }
}
