import java.util.*;
class Storage<T extends WarehouseItem>{
 private ArrayList<T> list=new ArrayList<>();
 public void add(T item){ list.add(item); }
 public static void showAll(List<? extends WarehouseItem> items){
  for(WarehouseItem w:items) System.out.println(w.getClass().getSimpleName());
 }
 public static void main(String[] args){
  Storage<Electronics> s=new Storage<>();
  s.add(new Electronics());
 }
}
