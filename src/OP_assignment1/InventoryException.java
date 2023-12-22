package OP_assignment1;

public class InventoryException extends RuntimeException{
	
	
	
	public InventoryException(String message) {
		super(message);
		
	}
	
	public static void isExceedMaxIntentory(int quantity) {
		if((quantity + Computer.findNumberOfCreatedComputers()) > Inventory.getMaxNumofComp()) {
			throw new InventoryException("Error: Exceeds Max. inventory ("+ Inventory.getMaxNumofComp()+").");
		}
	}
	
	public static void isStorageFull(int quantity) {
		if(Computer.findNumberOfCreatedComputers() == Inventory.getMaxInventory()) {
			throw new InventoryException("Inventory is full.");
		}
	}
	
	public static void isBelowMinIntentory(int quantity) {
		if(quantity < Inventory.getMinInventory()) {
			throw new InventoryException("Error: Less than Min. inventory ("+ Inventory.getMinInventory()+").");
		}
	}
	
	public String getMessage() {
        return super.getMessage();
}
}
