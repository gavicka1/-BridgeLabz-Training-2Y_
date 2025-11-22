import java.util.*;
public class Map_Q12_CountryCapitalLookup{
 public static void main(String[] args){
  Map<String,String> m = new TreeMap<>();
  m.put("India","New Delhi"); m.put("Japan","Tokyo"); m.put("France","Paris");
  m.put("Brazil","Brasilia"); m.put("Canada","Ottawa"); m.put("Egypt","Cairo");
  m.put("Kenya","Nairobi"); m.put("Australia","Canberra");
  System.out.println("Capital of Japan: "+m.getOrDefault("Japan","Unknown country"));
  for(Map.Entry<String,String> e: m.entrySet()) System.out.println(e.getKey()+" -> "+e.getValue());
 }
}
