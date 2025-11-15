import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Q10_EmployeeDataProcessing{
 public static void main(String[] args){
  int[] ages={23,45,19,34,28};
  ArrayList<Integer> list=new ArrayList<>();
  for(int a:ages) list.add(a);
  System.out.println("Youngest: "+Collections.min(list));
  System.out.println("Oldest: "+Collections.max(list));
 }
}
