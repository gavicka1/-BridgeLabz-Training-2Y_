import java.util.*;
class Resume<T extends JobRole>{
 private T role;
 public Resume(T r){ role=r; }
}
class Q16_ResumeScreening{
 public static void screen(List<? extends JobRole> r){
  for(JobRole j:r) System.out.println(j.getClass().getSimpleName());
 }
 public static void main(String[] args){
  screen(Arrays.asList(new SoftwareEngineer(),new DataScientist()));
 }
}
