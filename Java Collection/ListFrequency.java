import java.util.*;
public class ListFrequency{
 public static Map<String,Integer> freq(List<String> a){
  Map<String,Integer> m = new LinkedHashMap<>();
  for(String s: a) m.put(s, m.getOrDefault(s,0)+1);
  return m;
 }
 public static void main(String[] args){
  List<String> a = Arrays.asList("apple","banana","apple","orange");
  System.out.println(freq(a));
 }
}
