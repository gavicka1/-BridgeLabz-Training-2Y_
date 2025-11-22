import java.util.*;
public class Map_Q6_StudentGradeTracker{
 public static void main(String[] args){
  Map<String,Double> grades = new TreeMap<>();
  grades.put("Ravi",85.0); grades.put("Asha",92.0); grades.put("Kiran",76.5);
  grades.put("Asha",95.0);
  grades.remove("Kiran");
  for(Map.Entry<String,Double> e: grades.entrySet()) System.out.println(e.getKey()+" -> "+e.getValue());
 }
}
