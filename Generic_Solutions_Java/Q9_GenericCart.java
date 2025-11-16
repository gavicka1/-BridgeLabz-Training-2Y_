import java.util.*;
class Cart<T>{
 private ArrayList<T> list=new ArrayList<>();
 public void addItem(T item){ list.add(item); }
 public void removeItem(T item){ list.remove(item); }
 public void displayItems(){
  for(T i:list) System.out.println(i);
 }
 public static void main(String[] args){
  Cart<String> c1=new Cart<>();
  c1.addItem("Laptop");
  c1.displayItems();
 }
}
