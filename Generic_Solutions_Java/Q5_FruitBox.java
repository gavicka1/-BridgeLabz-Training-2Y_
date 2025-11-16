import java.util.*;
class FruitBox<T extends Fruit>{
 private ArrayList<T> list=new ArrayList<>();
 public void add(T f){ list.add(f); }
 public void show(){
  for(T f:list) System.out.println(f.getClass().getSimpleName());
 }
 public static void main(String[] args){
  FruitBox<Apple> a=new FruitBox<>();
  a.add(new Apple());
  a.show();
 }
}
