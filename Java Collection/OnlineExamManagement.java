import java.util.*;
public class OnlineExamManagement{
 public static void main(String[] args){
  List<String> questions = new ArrayList<>(Arrays.asList("Q1","Q2","Q3"));
  Collections.shuffle(questions);
  Set<String> students = new HashSet<>();
  students.add("s1"); students.add("s2"); students.add("s1");
  Queue<String> q = new LinkedList<>(students);
  Stack<String> history = new Stack<>();
  System.out.println(questions);
 }
}
