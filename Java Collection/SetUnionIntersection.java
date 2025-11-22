import java.util.*;
public class SetUnionIntersection{
 public static <T> Set<T> union(Set<T> a, Set<T> b){
  Set<T> r = new HashSet<>(a); r.addAll(b); return r;
 }
 public static <T> Set<T> intersection(Set<T> a, Set<T> b){
  Set<T> r = new HashSet<>(a); r.retainAll(b); return r;
 }
 public static void main(String[] args){
  Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3));
  Set<Integer> b = new HashSet<>(Arrays.asList(3,4,5));
  System.out.println("Union: "+union(a,b));
  System.out.println("Intersection: "+intersection(a,b));
 }
}
