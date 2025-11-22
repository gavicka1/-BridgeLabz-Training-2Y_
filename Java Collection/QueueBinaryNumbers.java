import java.util.*;
public class QueueBinaryNumbers{
 public static List<String> generate(int n){
  List<String> r = new ArrayList<>();
  Queue<String> q = new LinkedList<>();
  q.add("1");
  while(r.size()<n){
   String s = q.remove();
   r.add(s);
   q.add(s+"0"); q.add(s+"1");
  }
  return r;
 }
 public static void main(String[] args){
  System.out.println(generate(5));
 }
}
