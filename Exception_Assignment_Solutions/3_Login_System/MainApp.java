import auth.Auth;
import auth.InvalidCredentialsException;
public class MainApp {
    public static void main(String[] args) {
        Auth a = new Auth();
        try {
            a.validate("user", "wrong");
        } catch (InvalidCredentialsException e) {
            System.out.println("Login failed: " + e.getMessage());
            System.out.println("Please try again");
        }
    }
}
