package datamodel;

public class Cart {
    private String items;
    private double totalAmount;

    public Cart(String items, double totalAmount) {
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    
    public String getItems() {
        return items;
    }
}