import java.util.*;
public class LibraryManagement{
 public static void main(String[] args){
  List<String> books = new ArrayList<>(Arrays.asList("b1","b2"));
  Set<String> members = new HashSet<>();
  Queue<String> waiting = new LinkedList<>();
  Stack<String> returned = new Stack<>();
  System.out.println(books);
 }
}
