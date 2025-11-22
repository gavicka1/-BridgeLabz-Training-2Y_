import java.util.*;
public class SetSymmetricDifference{
 public static <T> Set<T> symDiff(Set<T> a, Set<T> b){
  Set<T> r = new HashSet<>(a);
  for(T x: b){
   if(!r.add(x)) r.remove(x);
  }
  return r;
 }
 public static void main(String[] args){
  Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3));
  Set<Integer> b = new HashSet<>(Arrays.asList(3,4,5));
  System.out.println(symDiff(a,b));
 }
}
