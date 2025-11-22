import java.util.*;
public class QueueReverse{
 public static <T> Queue<T> reverse(Queue<T> q){
  LinkedList<T> s = new LinkedList<>();
  while(!q.isEmpty()) s.push(q.remove());
  while(!s.isEmpty()) q.add(s.pop());
  return q;
 }
 public static void main(String[] args){
  Queue<Integer> q = new LinkedList<>(Arrays.asList(10,20,30));
  System.out.println(reverse(q));
 }
}
