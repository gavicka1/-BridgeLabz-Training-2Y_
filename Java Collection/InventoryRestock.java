import java.util.*;
public class InventoryRestock{
 public static void main(String[] args){
  Set<String> products = new HashSet<>(Arrays.asList("milk","bread"));
  List<String> details = new ArrayList<>();
  Queue<String> toRestock = new LinkedList<>(Arrays.asList("milk"));
  Stack<String> recent = new Stack<>();
  while(!toRestock.isEmpty()){
   String p=toRestock.remove();
   recent.push(p);
  }
  System.out.println(recent);
 }
}
