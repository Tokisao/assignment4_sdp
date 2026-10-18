package subsystem;
import datamodel.*;
public class NotificationService {
    public void sendOrderConfirmation(Customer customer, String trackingId) {
        System.out.println("NotificationService: Sending order confirmation to " + customer.getEmail() + ". Tracking: " + trackingId);
    }

    public void sendFailureNotice(Customer customer, String reason) {
        System.out.println("NotificationService: Sending failure notice to " + customer.getEmail() + ". Reason: " + reason);
    }
}