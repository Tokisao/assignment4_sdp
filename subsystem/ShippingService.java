package subsystem;
import datamodel.*;
public class ShippingService {
    public String arrangeShipping(Customer customer) {
        String trackingId = "TRK-" + (int)(Math.random() * 10000);
        System.out.println("ShippingService: Arranging shipping for " + customer.getName() + ". Tracking ID: " + trackingId);
        return trackingId;
    }

    public void cancelShipping(String trackingId) {
        System.out.println("ShippingService: Canceling shipping for tracking ID: " + trackingId);
    }
}