class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(int q) {
        quantity += q;
    }

    void removeItem(int q) {
        if (q <= quantity) quantity -= q;
    }

    void displayTotalCost() {
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + (price * quantity));
    }

    public static void main(String[] args) {
        CartItem c = new CartItem("Book", 200, 2);
        c.addItem(1);
        c.removeItem(1);
        c.displayTotalCost();
    }
}
