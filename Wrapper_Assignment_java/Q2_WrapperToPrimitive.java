public class Q2_WrapperToPrimitive{
 public static void main(String[] args){
  Double obj=45.67;
  double d=obj.doubleValue();
  int i=(int)(double)obj;
  System.out.println("Double object: "+obj);
  System.out.println("double primitive: "+d);
  System.out.println("int casted: "+i);
 }
}
