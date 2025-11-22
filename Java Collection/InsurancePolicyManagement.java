import java.util.*;
import java.time.*;
class Policy implements Comparable<Policy>{
 String number; String holder; LocalDate expiry; String type; double premium;
 Policy(String n,String h,LocalDate e,String t,double p){number=n;holder=h;expiry=e;type=t;premium=p;}
 public int compareTo(Policy o){ return expiry.compareTo(o.expiry); }
 public String toString(){ return number+":"+holder+":"+expiry+":"+type+":"+premium; }
}
public class InsurancePolicyManagement{
 public static void main(String[] args){
  Policy p1 = new Policy("P1","Alice",LocalDate.now().plusDays(10),"Health",1000);
  Policy p2 = new Policy("P2","Bob",LocalDate.now().plusDays(40),"Auto",1500);
  Policy p3 = new Policy("P3","Charlie",LocalDate.now().plusDays(20),"Home",1200);
  Set<Policy> hs = new HashSet<>(Arrays.asList(p1,p2,p3));
  Set<Policy> lhs = new LinkedHashSet<>(Arrays.asList(p1,p2,p3));
  Set<Policy> ts = new TreeSet<>(Arrays.asList(p1,p2,p3));
  System.out.println("All unique: "+hs);
  System.out.println("Expiring within 30 days:");
  for(Policy p: hs) if(!p.expiry.isAfter(LocalDate.now().plusDays(30))) System.out.println(p);
  System.out.println("Type=Health:");
  for(Policy p: hs) if(p.type.equals("Health")) System.out.println(p);
 }
}
