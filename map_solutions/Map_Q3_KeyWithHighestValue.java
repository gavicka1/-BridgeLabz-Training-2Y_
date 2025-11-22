import java.util.*;
public class Map_Q3_KeyWithHighestValue{
 public static String maxKey(Map<String,Integer> m){
  String best = null; int bv = Integer.MIN_VALUE;
  for(Map.Entry<String,Integer> e: m.entrySet()){
   if(e.getValue()>bv){ bv=e.getValue(); best=e.getKey(); }
  }
  return best;
 }
 public static void main(String[] args){
  Map<String,Integer> m = Map.of("A",10,"B",20,"C",15);
  System.out.println(maxKey(m));
 }
}
