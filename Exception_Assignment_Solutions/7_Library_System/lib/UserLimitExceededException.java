package lib;
public class UserLimitExceededException extends Exception {
    public UserLimitExceededException(String msg) { super(msg); }
}
