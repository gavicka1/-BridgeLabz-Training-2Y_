import java.util.Arrays;
public class Q15_GameScoreboard{
 public static void main(String[] args){
  Integer[] scores={10,null,20,null,5};
  int nulls=0;
  int sum=0;
  for(Integer s:scores){
    if(s==null) nulls++;
    else sum+=s;
  }
  System.out.println("Not played: "+nulls);
  System.out.println("Total score: "+sum);
 }
}
