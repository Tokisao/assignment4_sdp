import datamodel.*;
import facade.*;
public class Client {
    public static void main(String[] args) {
        // getting ready data
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        Cart cart = new Cart("Laptop, Wireless Mouse", 1250.50);

        //facade using
        OrderFacade orderFacade = new OrderFacade();
        
        //palcing order
        String orderId = orderFacade.placeOrder(cart, customer);
        
        System.out.println("\n[Later that day...]\n");
        
        //decline
        if (orderId != null) {
            String trackingId = orderId.replace("ORD-", "");
            orderFacade.cancelOrder(orderId, cart, trackingId);
        }
    }
}