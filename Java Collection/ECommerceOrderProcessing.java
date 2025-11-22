import java.util.*;
class Order{ String id; Order(String i){id=i;} public String toString(){return id;} }
public class ECommerceOrderProcessing{
 public static void main(String[] args){
  List<Order> all = new ArrayList<>(Arrays.asList(new Order("o1"),new Order("o2"),new Order("o1")));
  Set<String> seen = new HashSet<>();
  List<Order> valid = new ArrayList<>();
  for(Order o: all) if(seen.add(o.id)) valid.add(o);
  Queue<Order> q = new LinkedList<>(valid);
  Stack<Order> failed = new Stack<>();
  while(!q.isEmpty()){
   Order o=q.remove();
   if(o.id.equals("o2")) failed.push(o);
  }
  while(!failed.isEmpty()) q.add(failed.pop());
  System.out.println("Processed");
 }
}
