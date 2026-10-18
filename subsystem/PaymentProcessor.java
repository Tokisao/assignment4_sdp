package subsystem;
import datamodel.*;
public class PaymentProcessor {
    public boolean processPayment(Customer customer, double amount) {
        System.out.println("PaymentProcessor: Processing payment of $" + amount + " for " + customer.getName());
        return true; 
    }

    public void refundPayment(String orderId) {
        System.out.println("PaymentProcessor: Refunding payment for order: " + orderId);
    }
}