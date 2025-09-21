import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private String productId;
    private String name;
    private double price;
    public Product(String id,String name,double price){setProductId(id);setName(name);setPrice(price);}
    public String getProductId(){return productId;}
    public void setProductId(String id){if(id==null||id.isEmpty()) throw new IllegalArgumentException(); this.productId=id;}
    public String getName(){return name;}
    public void setName(String name){if(name==null||name.isEmpty()) throw new IllegalArgumentException(); this.name=name;}
    public double getPrice(){return price;}
    public void setPrice(double price){if(price<0) throw new IllegalArgumentException(); this.price=price;}
    public abstract double calculateDiscount();
}

interface Taxable{
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable{
    public Electronics(String id,String name,double price){super(id,name,price);}
    public double calculateDiscount(){return getPrice()*0.05;}
    public double calculateTax(){return getPrice()*0.18;}
    public String getTaxDetails(){return "GST 18%";}
}

class Clothing extends Product implements Taxable{
    public Clothing(String id,String name,double price){super(id,name,price);}
    public double calculateDiscount(){return getPrice()>1000?getPrice()*0.15:getPrice()*0.05;}
    public double calculateTax(){return getPrice()*0.12;}
    public String getTaxDetails(){return "GST 12%";}
}

class Groceries extends Product{
    public Groceries(String id,String name,double price){super(id,name,price);}
    public double calculateDiscount(){return getPrice()>500?50:10;}
}

public class ECommerce{
    public static void printFinalPrice(List<Product> products){
        for(Product p:products){
            double price=p.getPrice();
            double discount=p.calculateDiscount();
            double tax= p instanceof Taxable?((Taxable)p).calculateTax():0;
            double finalPrice=price+tax-discount;
            System.out.println(p.getName()+" Base:"+price+" Tax:"+tax+" Disc:"+discount+" Final:"+finalPrice);
        }
    }
    public static void main(String[] args){
        List<Product> list=new ArrayList<>();
        list.add(new Electronics("E01","Smartphone",20000));
        list.add(new Clothing("C01","Jacket",2500));
        list.add(new Groceries("G01","Rice",600));
        printFinalPrice(list);
    }
}
*