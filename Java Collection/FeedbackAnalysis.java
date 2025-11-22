import java.util.*;
public class FeedbackAnalysis{
 public static void main(String[] args){
  List<String> fb = new ArrayList<>(Arrays.asList("a","b","a"));
  Set<String> unique = new HashSet<>(fb);
  Queue<String> q = new LinkedList<>(fb);
  Stack<String> recent = new Stack<>();
  System.out.println(unique);
 }
}
