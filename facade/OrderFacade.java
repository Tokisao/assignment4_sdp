package facade;
import datamodel.*;
import subsystem.*;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public String placeOrder(Cart cart, Customer customer) {
        System.out.println("--- OrderFacade: Starting order placement ---");
        
        // 1. Reserve stock
        if (!inventoryService.reserveStock(cart)) {
            notificationService.sendFailureNotice(customer, "Out of stock.");
            return null;
        }

        // 2. Process payment
        if (!paymentProcessor.processPayment(customer, cart.getTotalAmount())) {
            // Rollback: release reserved stock if payment fails
            System.out.println("OrderFacade: Payment failed. Initiating rollback...");
            inventoryService.releaseStock(cart);
            notificationService.sendFailureNotice(customer, "Payment declined.");
            return null;
        }

        // 3. Arrange shipping
        String trackingId = shippingService.arrangeShipping(customer);

        // 4. Send confirmation
        notificationService.sendOrderConfirmation(customer, trackingId);
        
        System.out.println("--- OrderFacade: Order placed successfully! ---");
        return "ORD-" + trackingId;
    }

    public void cancelOrder(String orderId, Cart cart, String trackingId) {
        System.out.println("--- OrderFacade: Canceling order " + orderId + " ---");
        shippingService.cancelShipping(trackingId);
        paymentProcessor.refundPayment(orderId);
        inventoryService.releaseStock(cart);
        System.out.println("--- OrderFacade: Order canceled successfully ---");
    }
}