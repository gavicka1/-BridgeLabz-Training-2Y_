import java.util.*;
public class Map_Q10_WordFrequencySentence{
 public static void main(String[] args){
  String s = "Java is fun and Java is powerful";
  s = s.replaceAll("[^a-zA-Z0-9\\s]","").toLowerCase();
  String[] w = s.split("\\s+");
  Map<String,Integer> m = new HashMap<>();
  for(String x: w) m.put(x, m.getOrDefault(x,0)+1);
  for(Map.Entry<String,Integer> e: m.entrySet()) System.out.println(e.getKey()+" -> "+e.getValue());
 }
}
