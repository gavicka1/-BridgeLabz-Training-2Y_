import java.util.ArrayList;
import java.util.List;

abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public RideVehicle(String vehicleId,String driverName,double ratePerKm){setVehicleId(vehicleId);setDriverName(driverName);setRatePerKm(ratePerKm);}
    public String getVehicleId(){return vehicleId;}
    public void setVehicleId(String id){if(id==null||id.isEmpty()) throw new IllegalArgumentException(); this.vehicleId=id;}
    public String getDriverName(){return driverName;}
    public void setDriverName(String d){if(d==null||d.isEmpty()) throw new IllegalArgumentException(); this.driverName=d;}
    public double getRatePerKm(){return ratePerKm;}
    public void setRatePerKm(double r){if(r<0) throw new IllegalArgumentException(); this.ratePerKm=r;}
    public abstract double calculateFare(double distance);
    public String getVehicleDetails(){return vehicleId+" Driver:"+driverName;}
}

interface GPS{
    String getCurrentLocation();
    void updateLocation(String loc);
}

class RideCar extends RideVehicle implements GPS{
    private String location="Unknown";
    public RideCar(String id,String driver,double rate){super(id,driver,rate);}
    public double calculateFare(double distance){return getRatePerKm()*distance;}
    public String getCurrentLocation(){return location;}
    public void updateLocation(String loc){this.location=loc;}
}

class RideBike extends RideVehicle implements GPS{
    private String location="Unknown";
    public RideBike(String id,String driver,double rate){super(id,driver,rate);}
    public double calculateFare(double distance){return getRatePerKm()*distance*0.8;}
    public String getCurrentLocation(){return location;}
    public void updateLocation(String loc){this.location=loc;}
}

class RideAuto extends RideVehicle implements GPS{
    private String location="Unknown";
    public RideAuto(String id,String driver,double rate){super(id,driver,rate);}
    public double calculateFare(double distance){return getRatePerKm()*distance*0.6;}
    public String getCurrentLocation(){return location;}
    public void updateLocation(String loc){this.location=loc;}
}

public class RideHailing{
    public static void calculateFares(List<RideVehicle> vehicles,double distance){
        for(RideVehicle v:vehicles){
            System.out.println(v.getVehicleDetails()+" Fare for "+distance+" km: "+v.calculateFare(distance));
            GPS g=(GPS)v;
            g.updateLocation("PointA");
            System.out.println("Location: "+g.getCurrentLocation());
        }
    }
    public static void main(String[] args){
        List<RideVehicle> list=new ArrayList<>();
        list.add(new RideCar("RC01","Anil",15));
        list.add(new RideBike("RB01","Priya",8));
        list.add(new RideAuto("RA01","Suresh",6));
        calculateFares(list,12.5);
    }
}
