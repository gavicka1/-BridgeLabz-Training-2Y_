public class Q11_UserInputValidation{
 public static boolean validAndAdult(String s){
  try{
    int a=Integer.parseInt(s);
    return a>=18;
  }catch(Exception e){
    return false;
  }
 }
 public static void main(String[] args){
  String[] tests={"17","18","abc","25"};
  for(String t:tests) System.out.println(t+" -> "+validAndAdult(t));
 }
}
