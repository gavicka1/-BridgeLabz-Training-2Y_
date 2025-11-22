import java.util.*;
public class ListRotate{
 public static <T> List<T> rotate(List<T> a,int k){
  int n=a.size();
  k=((k%n)+n)%n;
  List<T> r = new ArrayList<>();
  for(int i=0;i<n;i++) r.add(a.get((i+k)%n));
  return r;
 }
 public static void main(String[] args){
  List<Integer> a = Arrays.asList(10,20,30,40,50);
  System.out.println(rotate(a,2));
 }
}
