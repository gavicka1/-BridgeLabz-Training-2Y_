import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber,String type,double rentalRate){setVehicleNumber(vehicleNumber);setType(type);setRentalRate(rentalRate);}
    public String getVehicleNumber(){return vehicleNumber;}
    public void setVehicleNumber(String v){if(v==null||v.isEmpty()) throw new IllegalArgumentException(); this.vehicleNumber=v;}
    public String getType(){return type;}
    public void setType(String t){if(t==null||t.isEmpty()) throw new IllegalArgumentException(); this.type=t;}
    public double getRentalRate(){return rentalRate;}
    public void setRentalRate(double r){if(r<0) throw new IllegalArgumentException(); this.rentalRate=r;}
    public abstract double calculateRentalCost(int days);
}

interface Insurable{
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable{
    private double insurance;
    public Car(String num,double rate,double insurance){super(num,"Car",rate);this.insurance=insurance;}
    public double calculateRentalCost(int days){return getRentalRate()*days;}
    public double calculateInsurance(){return insurance;}
    public String getInsuranceDetails(){return "Car Insurance";}
}

class Bike extends Vehicle implements Insurable{
    private double insurance;
    public Bike(String num,double rate,double insurance){super(num,"Bike",rate);this.insurance=insurance;}
    public double calculateRentalCost(int days){return getRentalRate()*days*0.6;}
    public double calculateInsurance(){return insurance;}
    public String getInsuranceDetails(){return "Bike Insurance";}
}

class Truck extends Vehicle implements Insurable{
    private double insurance;
    public Truck(String num,double rate,double insurance){super(num,"Truck",rate);this.insurance=insurance;}
    public double calculateRentalCost(int days){return getRentalRate()*days*1.4;}
    public double calculateInsurance(){return insurance;}
    public String getInsuranceDetails(){return "Truck Insurance";}
}

public class VehicleRental{
    public static void main(String[] args){
        List<Vehicle> vehicles=new ArrayList<>();
        vehicles.add(new Car("KA01A1234",2000,15000));
        vehicles.add(new Bike("KA02B5678",500,3000));
        vehicles.add(new Truck("KA03C9012",5000,45000));
        for(Vehicle v:vehicles){
            System.out.println(v.getType()+" "+v.getVehicleNumber()+" Rent(3 days): "+v.calculateRentalCost(3));
            Insurable ins=(Insurable)v;
            System.out.println("Insurance: "+ins.calculateInsurance()+" Details: "+ins.getInsuranceDetails());
        }
    }
}
