import java.util.ArrayList;
public class Q3_AutoboxingUnboxing{
 public static void main(String[] args){
  ArrayList<Integer> list=new ArrayList<>();
  list.add(5);
  list.add(10);
  list.add(8);
  list.add(12);
  list.add(20);
  int sum=0;
  for(Integer x:list) sum+=x;
  System.out.println("Sum of numbers = "+sum);
 }
}
