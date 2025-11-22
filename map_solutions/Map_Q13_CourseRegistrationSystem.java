import java.util.*;
public class Map_Q13_CourseRegistrationSystem{
 public static void main(String[] args){
  Map<String,Integer> courses = new HashMap<>();
  courses.put("CS101",45); courses.put("CS102",55); courses.put("MA101",3); courses.put("PH101",10); courses.put("CS201",60);
  courses.put("CS101", courses.get("CS101")+1);
  courses.put("MA101", Math.max(0, courses.get("MA101")-1));
  System.out.println("Near full (>=50):");
  for(Map.Entry<String,Integer> e: courses.entrySet()) if(e.getValue()>=50) System.out.println(e.getKey());
  System.out.println("Under-subscribed (<5):");
  for(Map.Entry<String,Integer> e: courses.entrySet()) if(e.getValue()<5) System.out.println(e.getKey());
 }
}
