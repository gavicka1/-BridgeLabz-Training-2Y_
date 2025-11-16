class Pair<T,U>{
 private T first;
 private U second;
 public Pair(T f,U s){ first=f; second=s; }
 public T getFirst(){ return first; }
 public U getSecond(){ return second; }
 public static void main(String[] args){
  Pair<String,Integer> p=new Pair<>("Amol",20);
  System.out.println(p.getFirst());
  System.out.println(p.getSecond());
 }
}
