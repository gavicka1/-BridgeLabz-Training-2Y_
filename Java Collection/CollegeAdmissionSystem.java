import java.util.*;
public class CollegeAdmissionSystem{
 public static void main(String[] args){
  List<String> applicants = new ArrayList<>(Arrays.asList("s1","s2"));
  Set<String> shortlist = new HashSet<>(Arrays.asList("s2"));
  Queue<String> interview = new LinkedList<>(shortlist);
  TreeSet<String> merit = new TreeSet<>();
  merit.addAll(Arrays.asList("s2","s1"));
  System.out.println(merit);
 }
}
