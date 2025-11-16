interface Category{}
class BookCategory implements Category{}
class ClothingCategory implements Category{}
class GadgetCategory implements Category{}

class Product2<T extends Category>{
 double price;
 T category;
 public Product2(double p,T c){
  price=p; category=c;
 }
 public double getPrice(){ return price; }
}

class Q13_OnlineMarketplace{
 public static <T extends Product2<?>> void applyDiscount(T p,double per){
  double np=p.getPrice()-(p.getPrice()*per/100);
  System.out.println(np);
 }
 public static void main(String[] args){
  applyDiscount(new Product2<>(500,new BookCategory()),10);
 }
}
