import java.util.ArrayList;
public class Q16_StudentMarksReport{
 public static void main(String[] args){
  Object[] inputs={"85",95,Integer.valueOf(88),"null","abc"};
  ArrayList<Integer> valid=new ArrayList<>();
  for(Object o:inputs){
    try{
      if(o==null) continue;
      if(o instanceof String){
        String s=(String)o;
        if(s.equals("null")) continue;
        valid.add(Integer.parseInt(s));
      }else if(o instanceof Integer) valid.add((Integer)o);
    }catch(Exception e){}
  }
  double sum=0;
  for(Integer v:valid) sum+=v;
  System.out.println("Average: "+(sum/valid.size()));
 }
}
