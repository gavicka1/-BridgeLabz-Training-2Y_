import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    Product(String n, double p, double r) { name = n; price = p; rating = r; }
}

public class Main2 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Phone", 50000, 4.7));
        list.add(new Product("Laptop", 80000, 4.5));
        list.add(new Product("Watch", 10000, 4.8));
        list.sort((a, b) -> Double.compare(a.price, b.price));
        for (Product p : list) System.out.println(p.name + " " + p.price);
    }
}
