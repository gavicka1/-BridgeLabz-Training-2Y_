import java.util.ArrayList;
import java.util.Collections;
public class Q7_WrapperObjectsInCollections{
 public static void main(String[] args){
  double[] prices={10.5,20.0,35.75,5.5};
  ArrayList<Double> list=new ArrayList<>();
  for(double p:prices) list.add(p);
  double max=Collections.max(list);
  double sum=0;
  for(Double d:list) sum+=d;
  double avg=sum/list.size();
  System.out.println("Highest: "+max);
  System.out.println("Average: "+avg);
 }
}
