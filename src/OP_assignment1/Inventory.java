package OP_assignment1;

import java.util.Arrays;

public class Inventory {
	private Computer[] inventory;
	//assuming the store could afford 25,000 computers
	private final static int MAX_INVENTORY = 25000;
	private final static int MIN_INVENTORY = 1;
	private static int maxNumofComp;
	
	public Inventory(int maxNumofComp) {
		this.maxNumofComp = maxNumofComp;
		inventory = new Computer[maxNumofComp];
	}
	


	//Getters and setters
	public static int getMaxInventory() {
		return MAX_INVENTORY;
	}
	public static int getMinInventory() {
		return MIN_INVENTORY;
	}

	public Computer[] getInventory() {
		return inventory;
	}

	public void setInventory(Computer[] inventory) {
		this.inventory = inventory;
	}
	
	public static int getMaxNumofComp() {
		return maxNumofComp;
	}

	public static void setMaxNumofComp(int maxNumofComp) {
		Inventory.maxNumofComp = maxNumofComp;
	}



	public void InputInventory(int nNewEnt){
		int i;
		int nComp = Computer.findNumberOfCreatedComputers();
		Double price;
		String brand, model;
		
		for(i=0; i<nNewEnt; i++) {
			System.out.println("Computer # "+ (i+1));
			System.out.print("Input Brand: ");
			brand = Demo.inputCheck("");
			System.out.print("Input Model: ");
			model = Demo.inputCheck("");
			System.out.print("Input Price: ");
			price = Demo.inputCheck();
			
			inventory[nComp+i] = new Computer(brand, model, price);
		}
		
		return;
	}
	
	public void UpdateInventory() {
		int choice, compNum = 0;
		int numOfComp = Computer.findNumberOfCreatedComputers();
		String brand,model;
		double price;
		long serialNum = 0;
				
		//Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.print("\nWhich computer would like to change? ");
			
			try {
				compNum = NumValidationException.isInteger(Demo.inputCheck());
				NumValidationException.isGreaterThan(compNum,1);
				NumValidationException.isLessThan(compNum, numOfComp);
				break;
			}catch(NumValidationException e) {
				System.out.print(e.getMessage()+" Try again: ");
			}
			
			Demo.SubMenue();
			
			do {
				try {
					choice = NumValidationException.isInteger(Demo.inputCheck());
					NumValidationException.isGreaterThan(choice,1);
					NumValidationException.isLessThan(choice, 5);
					break;
				}catch(NumValidationException e) {
					System.out.print(e.getMessage()+" Try again: ");
				}
			}while(true);
			
			switch(choice) {
			case 1:	
					System.out.print("Input Brand: ");
					brand = Demo.inputCheck("");
					inventory[compNum-1].setBrand(brand);
					System.out.print("\n--- after Update ---\n");
					inventory[compNum-1].toString();
					break;
			case 2: System.out.print("Input Model: ");
					model = Demo.inputCheck("");
					inventory[compNum-1].setModel(model);
					System.out.print("\n--- after Update ---\n");
					inventory[compNum-1].toString();
					break;
			case 3: 
					do{
						System.out.print("Input Serial number: ");
						//assuming our serial number could begin from 1 
						//max long number = 9223372036854775807L
						try {
							serialNum = NumValidationException.isInteger(Demo.inputCheck());
							NumValidationException.isGreaterThan(serialNum,1);
							NumValidationException.isLessThan(serialNum, Long.MAX_VALUE);
							break;
						}catch(NumValidationException e) {
							System.out.print(e.getMessage()+" Try again: ");
						}
						if(!Demo.IsFoundSerialNum(serialNum, inventory, numOfComp)) {
							inventory[compNum-1].setSerialNum(serialNum);
							break;
						}else {
							System.out.println("This serial number already exist");
						}
					}while(true);
					System.out.print("\n--- after Update ---\n");
					inventory[compNum-1].toString();
					break;
			case 4: System.out.print("Input Price: ");
					price = Demo.inputCheck();
					inventory[compNum-1].setPrice(price);
					System.out.print("\n--- after Update ---\n");
					inventory[compNum-1].toString();
					break;
			case 5: System.out.print("Go to Main Menue"); 
			}
			
		}while(choice<5);
	}

	public void findCheaperThan( double price){
		int i;
		int nComputers = Computer.findNumberOfCreatedComputers();
		boolean found = false;
		Computer[] compBrandMatch = new Computer[0];
		
		for(i=0; i<nComputers; i++) {
			if(inventory[i].getPrice() < price) {
				System.out.println("\nComputer # "+ (i+1));
				inventory[i].toString();
				found = true;
			}
		}
		
		if(!found) {
			System.out.println("No result match your input.");
		}
		
	}
//		
//	
//	
	public void findComputersByBrand(String brand) {
		int i;
		int nComputers = Computer.findNumberOfCreatedComputers();
		boolean found = false;
		Computer[] compBrandMatch = new Computer[0];
		
		for(i=0; i<nComputers; i++) {
			if(inventory[i].getBrand().equals(brand)) {
				System.out.println("\nComputer # "+ (i+1));
				inventory[i].toString();
				found = true;
			}
		}

		if(!found) {
			System.out.println(" No result match your input.");
		}
		
	}


	@Override
	public String toString() {
		int i;
		int n = Computer.findNumberOfCreatedComputers();
		
		for(i=0; i<n; i++){
			System.out.println("\nComputer # "+ (i+1));
			inventory[i].toString();
		} 
		return null;
	}
	
	
	
}
