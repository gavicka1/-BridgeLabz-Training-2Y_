import java.nio.file.*;
import java.util.*;
public class Map_Q1_WordFrequencyCounter{
 public static Map<String,Integer> freq(String s){
  s = s.replaceAll("[^a-zA-Z0-9\\s]","").toLowerCase();
  String[] parts = s.split("\\s+");
  Map<String,Integer> m = new HashMap<>();
  for(String w: parts) if(!w.isEmpty()) m.put(w, m.getOrDefault(w,0)+1);
  return m;
 }
 public static void main(String[] args) throws Exception{
  String text = "Hello world, hello Java!";
  System.out.println(freq(text));
 }
}
