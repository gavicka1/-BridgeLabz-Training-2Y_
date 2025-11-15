import java.util.ArrayList;
import java.util.Objects;
public class Q14_ProductRatingsAnalyzer{
 public static void main(String[] args){
  int[] prim={4,5,3,0};
  ArrayList<Integer> obj=new ArrayList<>();
  obj.add(5);
  obj.add(null);
  obj.add(4);
  ArrayList<Integer> all=new ArrayList<>();
  for(int v:prim) all.add(v);
  for(Integer v:obj) if(Objects.nonNull(v)) all.add(v);
  double sum=0;
  for(Integer v:all) sum+=v;
  System.out.println("Average: "+(sum/all.size()));
 }
}
