import java.util.*;
public class Map_Q7_InventoryManagement{
 public static void main(String[] args){
  Map<String,Integer> stock = new HashMap<>();
  stock.put("Milk",10); stock.put("Bread",5); stock.put("Eggs",0);
  stock.put("Bread", stock.get("Bread") - 3);
  stock.put("Milk", stock.get("Milk") + 20);
  List<String> out = new ArrayList<>();
  for(Map.Entry<String,Integer> e: stock.entrySet()){
   if(e.getValue()<=0) out.add(e.getKey());
  }
  System.out.println("Stock: "+stock);
  System.out.println("Out of stock: "+out);
 }
}
