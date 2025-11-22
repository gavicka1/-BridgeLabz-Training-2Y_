import java.util.*;
public class Map_Q9_LibraryCatalog{
 public static void main(String[] args){
  Map<String,String> catalog = new TreeMap<>();
  catalog.put("978-111","Clean Code");
  catalog.put("978-222","Algorithms");
  catalog.put("978-333","Java Basics");
  System.out.println(catalog.getOrDefault("978-222","Book not found"));
  catalog.remove("978-333");
  System.out.println("All: "+catalog);
  String search="Algorithms";
  for(Map.Entry<String,String> e: catalog.entrySet()) if(e.getValue().equals(search)) System.out.println("Found ISBN: "+e.getKey());
 }
}
