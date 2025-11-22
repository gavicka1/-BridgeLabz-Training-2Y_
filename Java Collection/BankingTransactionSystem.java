import java.util.*;
public class BankingTransactionSystem{
 public static void main(String[] args){
  List<String> transactions = new ArrayList<>(Arrays.asList("t1","t2"));
  Queue<String> q = new LinkedList<>(transactions);
  Set<String> accounts = new HashSet<>(Arrays.asList("a1","a2"));
  Stack<String> rollback = new Stack<>();
  while(!q.isEmpty()){
   String t = q.remove();
   if(accounts.contains("a1")) rollback.push(t);
  }
  if(!rollback.isEmpty()) rollback.pop();
  System.out.println("Done");
 }
}
