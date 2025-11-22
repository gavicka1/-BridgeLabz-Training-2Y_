import java.util.*;
public class CircularBuffer{
 int[] a; int start=0, size=0;
 CircularBuffer(int cap){ a=new int[cap]; }
 public void add(int x){
  if(size<a.length){ a[(start+size)%a.length]=x; size++; }
  else{ a[start]=x; start=(start+1)%a.length; a[(start+size-1)%a.length]=x; }
 }
 public List<Integer> toList(){
  List<Integer> r=new ArrayList<>();
  for(int i=0;i<size;i++) r.add(a[(start+i)%a.length]);
  return r;
 }
 public static void main(String[] args){
  CircularBuffer b=new CircularBuffer(3);
  b.add(1); b.add(2); b.add(3); b.add(4);
  System.out.println(b.toList());
 }
}
