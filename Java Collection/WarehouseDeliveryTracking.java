import java.util.*;
public class WarehouseDeliveryTracking{
 public static void main(String[] args){
  Queue<String> pending = new LinkedList<>(Arrays.asList("p1","p2"));
  Set<String> ids = new HashSet<>();
  List<String> delivered = new ArrayList<>();
  Stack<String> returned = new Stack<>();
  while(!pending.isEmpty()) delivered.add(pending.remove());
  System.out.println(delivered);
 }
}
