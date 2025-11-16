import java.util.*;
class CopyList{
 public static void copyList(List<? super Number> dest,List<? extends Number> src){
  for(Number n:src) dest.add(n);
 }
 public static void main(String[] args){
  List<Number> d=new ArrayList<>();
  copyList(d,Arrays.asList(1,2,3));
  System.out.println(d);
 }
}
