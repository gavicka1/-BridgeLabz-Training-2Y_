import java.util.*;
public class StackUsingQueues{
 Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
 public void push(int x){ q2.add(x); while(!q1.isEmpty()) q2.add(q1.remove()); Queue<Integer> t=q1; q1=q2; q2=t; }
 public int pop(){ return q1.remove(); }
 public int top(){ return q1.peek(); }
 public static void main(String[] args){
  StackUsingQueues s = new StackUsingQueues();
  s.push(1); s.push(2); s.push(3);
  System.out.println(s.pop());
 }
}
