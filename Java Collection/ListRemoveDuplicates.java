import java.util.*;
public class ListRemoveDuplicates{
 public static <T> List<T> removeDup(List<T> a){
  Set<T> seen = new LinkedHashSet<>();
  for(T x: a) seen.add(x);
  return new ArrayList<>(seen);
 }
 public static void main(String[] args){
  List<Integer> a = Arrays.asList(3,1,2,2,3,4);
  System.out.println(removeDup(a));
 }
}
