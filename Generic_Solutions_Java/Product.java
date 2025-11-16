class Product{
 double price;
 public Product(double p){ price=p; }
 public double getPrice(){ return price; }
}
class Mobile extends Product{
 public Mobile(double p){ super(p); }
}
class Laptop extends Product{
 public Laptop(double p){ super(p); }
}
