import java.util.*;
public class ListReverseLinkedList{
 public static LinkedList<Integer> reverse(LinkedList<Integer> l){
  LinkedList<Integer> res = new LinkedList<>();
  for(Integer v: l) res.addFirst(v);
  return res;
 }
 public static void main(String[] args){
  LinkedList<Integer> l = new LinkedList<>(Arrays.asList(1,2,3,4,5));
  System.out.println(reverse(l));
 }
}
