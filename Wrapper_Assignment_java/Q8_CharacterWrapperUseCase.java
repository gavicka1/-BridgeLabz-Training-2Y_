public class Q8_CharacterWrapperUseCase{
 public static void main(String[] args){
  String s="Hello123! @ World45";
  int letters=0,digits=0,special=0;
  for(char c:s.toCharArray()){
    if(Character.isLetter(c)) letters++;
    else if(Character.isDigit(c)) digits++;
    else if(!Character.isWhitespace(c)) special++;
  }
  System.out.println("Letters: "+letters);
  System.out.println("Digits: "+digits);
  System.out.println("Special: "+special);
 }
}
