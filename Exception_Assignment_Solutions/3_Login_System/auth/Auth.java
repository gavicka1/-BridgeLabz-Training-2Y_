package auth;
public class Auth {
    private String validUser = "user";
    private String validPass = "pass";
    public void validate(String user, String pass) throws InvalidCredentialsException {
        if (!validUser.equals(user) || !validPass.equals(pass)) throw new InvalidCredentialsException("Invalid username or password");
        System.out.println("Login successful");
    }
}
