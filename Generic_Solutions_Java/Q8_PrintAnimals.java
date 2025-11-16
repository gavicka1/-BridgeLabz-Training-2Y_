import java.util.*;
class Q8_PrintAnimals{
 public static void printAnimals(List<? extends Animal> a){
  for(Animal x:a) System.out.println(x.getClass().getSimpleName());
 }
 public static void main(String[] args){
  printAnimals(Arrays.asList(new Dog(),new Dog()));
  printAnimals(Arrays.asList(new Cat(),new Cat()));
 }
}
