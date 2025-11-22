import java.util.*;
public class Map_Q8_VotingCount{
 public static void main(String[] args){
  String[] votes = {"Alice","Bob","Alice","Carol","Bob","Bob","Alice","Carol","Bob","Alice"};
  Map<String,Integer> counts = new HashMap<>();
  for(String v: votes) counts.put(v, counts.getOrDefault(v,0)+1);
  String winner=null; int mv=0;
  for(Map.Entry<String,Integer> e: counts.entrySet()) if(e.getValue()>mv){ mv=e.getValue(); winner=e.getKey(); }
  System.out.println("Votes: "+counts);
  System.out.println("Winner: "+winner);
 }
}
