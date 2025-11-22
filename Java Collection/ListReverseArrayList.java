import java.util.*;
public class ListReverseArrayList{
 public static List<Integer> reverse(List<Integer> a){
  List<Integer> r = new ArrayList<>();
  for(int i=a.size()-1;i>=0;i--) r.add(a.get(i));
  return r;
 }
 public static void main(String[] args){
  List<Integer> a = Arrays.asList(1,2,3,4,5);
  System.out.println(reverse(a));
 }
}
