import library.books.*;
import library.members.*;
import library.transactions.*;
public class MainApp {
    public static void main(String[] args) {
        Book b = new Book();
        Member m = new Member();
        Transaction t = new Transaction();
        b.addBook("Java Basics", "James");
        m.addMember("Shiva");
        t.issueBook("Java Basics", "Shiva");
    }
}