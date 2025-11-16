import java.util.*;
class FleetManager<T extends Vehicle>{
 private ArrayList<T> list=new ArrayList<>();
 public void addVehicle(T v){ list.add(v); }
 public void showFleet(){
  for(T v:list) System.out.println(v.getClass().getSimpleName());
 }
 public static void main(String[] args){
  FleetManager<Truck> t=new FleetManager<>();
  t.addVehicle(new Truck());
  t.showFleet();
 }
}
