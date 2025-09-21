import java.util.ArrayList;
import java.util.List;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName,double price,int quantity){setItemName(itemName);setPrice(price);setQuantity(quantity);}
    public String getItemName(){return itemName;}
    public void setItemName(String n){if(n==null||n.isEmpty()) throw new IllegalArgumentException(); this.itemName=n;}
    public double getPrice(){return price;}
    public void setPrice(double p){if(p<0) throw new IllegalArgumentException(); this.price=p;}
    public int getQuantity(){return quantity;}
    public void setQuantity(int q){if(q<0) throw new IllegalArgumentException(); this.quantity=q;}
    public abstract double calculateTotalPrice();
    public String getItemDetails(){return getItemName()+" x"+getQuantity()+" Unit:"+getPrice();}
}

interface Discountable{
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable{
    public VegItem(String name,double price,int qty){super(name,price,qty);}
    public double calculateTotalPrice(){return getPrice()*getQuantity();}
    public double applyDiscount(){double t=calculateTotalPrice(); return t>500? t*0.1:0;}
    public String getDiscountDetails(){return "Veg discount if total>500";}
}

class NonVegItem extends FoodItem implements Discountable{
    public NonVegItem(String name,double price,int qty){super(name,price,qty);}
    public double calculateTotalPrice(){return getPrice()*getQuantity()+50;}
    public double applyDiscount(){return 0;}
    public String getDiscountDetails(){return "No discount but extra charge for non-veg";}
}

public class FoodDelivery{
    public static double calculateOrderTotal(List<FoodItem> items){
        double total=0;
        for(FoodItem f:items){
            double price=f.calculateTotalPrice();
            double disc= f instanceof Discountable?((Discountable)f).applyDiscount():0;
            total += price - disc;
            System.out.println(f.getItemDetails()+" Price:"+price+" Disc:"+disc);
        }
        return total;
    }
    public static void main(String[] args){
        List<FoodItem> order=new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala",250,2));
        order.add(new NonVegItem("Chicken Biryani",300,1));
        System.out.println("Order Total: "+calculateOrderTotal(order));
    }
}
