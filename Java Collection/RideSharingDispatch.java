import java.util.*;
public class RideSharingDispatch{
 public static void main(String[] args){
  Queue<String> requests = new LinkedList<>();
  requests.add("r1"); requests.add("r2");
  Set<String> drivers = new HashSet<>(Arrays.asList("d1","d2"));
  List<String> completed = new ArrayList<>();
  while(!requests.isEmpty()){
   String r = requests.remove();
   if(!drivers.isEmpty()){
    String d = drivers.iterator().next();
    drivers.remove(d);
    completed.add(r+"->"+d);
   }
  }
  System.out.println(completed);
 }
}
