import java.util.*;
import lib.BookNotAvailableException;
import lib.InvalidReturnException;
import lib.UserLimitExceededException;
public class MainApp {
    public static void main(String[] args) {
        Map<String, Boolean> books = new HashMap<>();
        books.put("Java", true);
        books.put("DS", true);
        Map<String, List<String>> userLoans = new HashMap<>();
        try {
            borrowBook("Shiva", "Java", books, userLoans);
            borrowBook("Shiva", "DS", books, userLoans);
            borrowBook("Shiva", "Java", books, userLoans);
        } catch (Exception e) {
            System.out.println("Library error: " + e.getMessage());
        }
        try {
            returnBook("Shiva", "OS", books, userLoans);
        } catch (InvalidReturnException e) {
            System.out.println("Return error: " + e.getMessage());
        }
    }
    static void borrowBook(String user, String title, Map<String, Boolean> books, Map<String, List<String>> userLoans) throws BookNotAvailableException, UserLimitExceededException {
        if (!books.containsKey(title) || !books.get(title)) throw new BookNotAvailableException(title + " not available");
        List<String> loans = userLoans.getOrDefault(user, new ArrayList<>());
        if (loans.size() >= 5) throw new UserLimitExceededException("User limit exceeded");
        loans.add(title);
        userLoans.put(user, loans);
        books.put(title, false);
        System.out.println(user + " borrowed " + title);
    }
    static void returnBook(String user, String title, Map<String, Boolean> books, Map<String, List<String>> userLoans) throws InvalidReturnException {
        List<String> loans = userLoans.get(user);
        if (loans == null || !loans.contains(title)) throw new InvalidReturnException("Invalid return: " + title);
        loans.remove(title);
        books.put(title, true);
        System.out.println(user + " returned " + title);
    }
}
