package subsystem;
import datamodel.*;

public class InventoryService {
    public boolean reserveStock(Cart cart) {
        System.out.println("InventoryService: Reserving stock for items: " + cart.getItems());
        return true; 
    }

    public void releaseStock(Cart cart) {
        System.out.println("InventoryService: Releasing stock for items: " + cart.getItems());
    }
}
