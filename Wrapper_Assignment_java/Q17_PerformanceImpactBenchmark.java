import java.util.ArrayList;
public class Q17_PerformanceImpactBenchmark{
 public static void main(String[] args){
  int n=1000000;
  int[] arr=new int[n];
  for(int i=0;i<n;i++) arr[i]=i;
  long t1=System.currentTimeMillis();
  long sum1=0;
  for(int v:arr) sum1+=v;
  long t2=System.currentTimeMillis();
  ArrayList<Integer> list=new ArrayList<>();
  for(int i=0;i<n;i++) list.add(i);
  long t3=System.currentTimeMillis();
  long sum2=0;
  for(Integer v:list) sum2+=v;
  long t4=System.currentTimeMillis();
  System.out.println("int[] time ms: "+(t2-t1));
  System.out.println("ArrayList<Integer> time ms: "+(t4-t3));
 }
}
