import java.util.*;
public class ListNthFromEnd{
 public static <T> T nthFromEnd(LinkedList<T> l,int n){
  Iterator<T> it = l.iterator();
  LinkedList<T> win = new LinkedList<>();
  while(it.hasNext()){
   win.add(it.next());
   if(win.size()>n) win.removeFirst();
  }
  return win.getFirst();
 }
 public static void main(String[] args){
  LinkedList<String> l = new LinkedList<>(Arrays.asList("A","B","C","D","E"));
  System.out.println(nthFromEnd(l,2));
 }
}
