import java.util.*;
public class Map_Q14_EmployeeSalaryDirectory{
 public static void main(String[] args){
  Map<String,Double> emp = new HashMap<>();
  emp.put("A",50000.0); emp.put("B",75000.0); emp.put("C",60000.0);
  emp.put("D",90000.0); emp.put("E",45000.0); emp.put("F",90000.0);
  emp.put("C", emp.get("C") * 1.10);
  double sum=0; double max=Double.MIN_VALUE;
  for(double v: emp.values()){ sum+=v; if(v>max) max=v;}
  System.out.println("Average: "+(sum/emp.size()));
  System.out.println("Highest-paid:");
  for(Map.Entry<String,Double> e: emp.entrySet()) if(e.getValue()==max) System.out.println(e.getKey());
 }
}
