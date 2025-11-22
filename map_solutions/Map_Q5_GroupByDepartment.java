import java.util.*;
class Emp{ String name, dept; Emp(String n,String d){name=n;dept=d;} public String toString(){return name;} }
public class Map_Q5_GroupByDepartment{
 public static Map<String,List<Emp>> group(List<Emp> list){
  Map<String,List<Emp>> r = new HashMap<>();
  for(Emp e: list) r.computeIfAbsent(e.dept, k->new ArrayList<>()).add(e);
  return r;
 }
 public static void main(String[] args){
  List<Emp> emps = Arrays.asList(new Emp("Alice","HR"), new Emp("Bob","IT"), new Emp("Carol","HR"));
  System.out.println(group(emps));
 }
}
