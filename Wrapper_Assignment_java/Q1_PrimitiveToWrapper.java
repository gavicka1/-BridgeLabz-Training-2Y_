import java.util.Scanner;
public class Q1_PrimitiveToWrapper{
 public static void main(String[] args){
  Scanner s=new Scanner(System.in);
  int n=10;
  Integer obj=Integer.valueOf(n);
  System.out.println("primitive: "+n);
  System.out.println("wrapper: "+obj);
  s.close();
 }
}
