import java.util.*;
class Course<T extends CourseType>{
 private T type;
 public Course(T t){ type=t; }
}
class Q14_CourseManagement{
 public static void show(List<? extends CourseType> c){
  for(CourseType x:c) System.out.println(x.getClass().getSimpleName());
 }
 public static void main(String[] args){
  show(Arrays.asList(new ExamCourse(),new ResearchCourse()));
 }
}
