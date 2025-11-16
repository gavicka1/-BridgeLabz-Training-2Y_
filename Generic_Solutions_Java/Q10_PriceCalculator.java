import java.util.*;
class Q10_PriceCalculator{
 public static double calculateTotal(List<? extends Product> items){
  double t=0;
  for(Product p:items) t+=p.getPrice();
  return t;
 }
 public static void main(String[] args){
  System.out.println(calculateTotal(Arrays.asList(new Mobile(10000),new Mobile(20000))));
 }
}
