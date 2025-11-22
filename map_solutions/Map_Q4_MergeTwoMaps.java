import java.util.*;
public class Map_Q4_MergeTwoMaps{
 public static Map<String,Integer> merge(Map<String,Integer> a, Map<String,Integer> b){
  Map<String,Integer> r = new HashMap<>(a);
  for(Map.Entry<String,Integer> e: b.entrySet()) r.put(e.getKey(), r.getOrDefault(e.getKey(),0)+e.getValue());
  return r;
 }
 public static void main(String[] args){
  Map<String,Integer> m1 = Map.of("A",1,"B",2);
  Map<String,Integer> m2 = Map.of("B",3,"C",4);
  System.out.println(merge(m1,m2));
 }
}
