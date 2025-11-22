import java.util.*;
public class Map_Q11_StudentAttendanceTracker{
 public static void main(String[] args){
  List<String> students = Arrays.asList("S1","S2","S3","S4","S5");
  Map<String,Integer> att = new HashMap<>();
  for(String s: students) att.put(s,0);
  List<List<String>> days = new ArrayList<>();
  days.add(Arrays.asList("S1","S2","S3"));
  days.add(Arrays.asList("S2","S4"));
  days.add(Arrays.asList("S1","S3","S5"));
  days.add(Arrays.asList("S1","S2","S4","S5"));
  days.add(Arrays.asList("S3","S4"));
  for(List<String> present: days) for(String p: present) att.put(p, att.getOrDefault(p,0)+1);
  System.out.println("Attendance: "+att);
  System.out.println("Under-attending (<2):");
  for(Map.Entry<String,Integer> e: att.entrySet()) if(e.getValue()<2) System.out.println(e.getKey());
 }
}
