import java.util.ArrayList;
public class Q13_SensorDataLogger{
 public static void acceptPrimitive(double d){
  Double x=d;
  System.out.println(x);
 }
 public static void acceptWrapper(Double d){
  double x=d;
  System.out.println(x);
 }
 public static void main(String[] args){
  acceptPrimitive(36.6);
  acceptWrapper(37.2);
  ArrayList<Double> list=new ArrayList<>();
  list.add(36.6);
  list.add(37.2);
  for(Double v:list) System.out.println(v);
 }
}
