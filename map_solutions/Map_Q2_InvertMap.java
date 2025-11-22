import java.util.*;
public class Map_Q2_InvertMap{
 public static <K,V> Map<V,List<K>> invert(Map<K,V> m){
  Map<V,List<K>> r = new HashMap<>();
  for(Map.Entry<K,V> e: m.entrySet()){
   r.computeIfAbsent(e.getValue(), k->new ArrayList<>()).add(e.getKey());
  }
  return r;
 }
 public static void main(String[] args){
  Map<String,Integer> m = new LinkedHashMap<>();
  m.put("A",1); m.put("B",2); m.put("C",1);
  System.out.println(invert(m));
 }
}
