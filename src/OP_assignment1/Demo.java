
// Assignment (1)
// © Kawthar Mashkour
// Written by: Kawthar Mashkour (6284305)
//
//Project Description: Computer store inventory input and manage data.


package OP_assignment1;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Integer maxNumofComp, numOfPotentialInventory, choice = 0, nNewEntries;
		double price;
		String brand;
		Inventory inventory= null;
		
		System.out.println("\n---- Wellcome in Computer invetory management program ----\n");
		System.out.print("Input the maximum number of computers for the store capacity: ");
		
		do {
			try {
				maxNumofComp = NumValidationException.isInteger(inputCheck());
				NumValidationException.isGreaterThan(maxNumofComp,1);
				NumValidationException.isLessThan(maxNumofComp, Inventory.getMaxInventory());
				inventory= new Inventory(maxNumofComp);
				break;
			}catch(NumValidationException e) {
				System.out.println(e.getMessage());
				System.out.print("Try again: ");
			}catch(InventoryException e) {
				System.out.println(e.getMessage());
				System.out.print("Try again: ");
			}
		}while(true);
		
		do {
			MainMenue();
			do {
				try {
					choice = NumValidationException.isInteger(inputCheck());
					NumValidationException.isGreaterThan(choice,1);
					NumValidationException.isLessThan(choice, 5);
					break;
				}catch(NumValidationException e) {
					System.out.print(e.getMessage()+" Try again: ");
				}
			}while(true);
			
			switch(choice) {
			//Input inventory
			case 1: if(PassCheck()) {
						System.out.print("\nHow many computers you want to enter? ");
						numOfPotentialInventory = maxNumofComp - Computer.findNumberOfCreatedComputers();
						
						try {
							InventoryException.isStorageFull(numOfPotentialInventory);
							nNewEntries =  NumValidationException.isInteger(inputCheck());
							InventoryException.isExceedMaxIntentory(nNewEntries);
							inventory.InputInventory(nNewEntries);
							System.out.println("\n--- All Inventory ---");
							inventory.toString();
						}catch(InventoryException e) {
							System.out.println(e.getMessage());
						}catch(NumValidationException e) {
							System.out.println(e.getMessage());
						}
					}
					break;
//			//Update inventory
			case 2: if(PassCheck()) {
						if(Computer.findNumberOfCreatedComputers()>0) {
							System.out.println("\n--- All Inventory ---");
							inventory.toString();
							inventory.UpdateInventory();
						}else {
							System.out.println("\nError: No INVENTORY in the store");
						}
					}
					break;
//			// Search by brand		
			case 3: if(Computer.findNumberOfCreatedComputers()>0) {
						System.out.print("Input the brand you want to search: ");
						brand = inputCheck("");
						inventory.findComputersByBrand(brand);
					}else {
						System.out.println("\nError: No inventory in the store.");
					}
					break;
			//Search by price		
			case 4: if(Computer.findNumberOfCreatedComputers()>0) {
						System.out.print("Enter the maximum price you want to search: ");
						price = inputCheck();
						inventory.findCheaperThan(price);
					}else {
						System.out.println("\nError: No inventory in the store.");
					}
					break;
					
			case 5: System.out.println("\nProgram Exit. "); 
					System.exit(0);
			}
		}while(choice<5);
		
	}
//	
////	private static Computer[] appendToArray(Computer[] arr, Computer element) {	
////		Computer[] newArr = Arrays.copyOf(arr, arr.length + 1);
////        newArr[arr.length] = element;
////        System.out.println("newArr : "+Arrays.toString(newArr));
////        return newArr;
////    }
//	
	
//	
//	
//	
//	
	public static boolean IsFoundSerialNum(long sn, Computer[] arr, int n) {
		int i;
		for(i=0; i<n; i++) {
			if(arr[i].getSerialNum() == sn) {
				return true;
			}
		}
		return false;
	}
//	
//	
//	
	public static boolean PassCheck(){
		int i;
		String pass;
		final String PASSWORD = "password";

		for(i=0; i<3; i++) {
			
			System.out.print("Input password: ");
			pass = inputCheck("");
		
			if(pass.equals(PASSWORD)){
				return true;
			}else {
				System.out.println("Error: wrong password.");
			}

		}
		
		System.out.println("Error: you did 3 trials, access denied!");
		return false;
	}
//	
//	//overload method
	public static String inputCheck(String s){
		
		Scanner sc = new Scanner(System.in);
		
		do {
            s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.print("Your input should be a non-empty string, try again: ");
            }
        }while (s.isEmpty());
		
        return s;
	}
//	
//	

	public static Double inputCheck(){
		String input="";
		Double num = 0.0;

		Scanner sc = new Scanner(System.in);

		do  {
				try {
					input = sc.next();
					num = NumValidationException.isNumeric(input);
					return num;
				}catch(NumValidationException e) {
					System.out.print(e.getMessage()+"\n Try again: ");
				}
			
			}while(true);
			
	}
//	
//	
//	
	public static void SubMenue() {
		System.out.print("\nWhat information would you like to change?\r\n"
				+ "1. brand\r\n"
				+ "2. model\r\n"
				+ "3. SN\r\n"
				+ "4. price\r\n"
				+ "5. Quit\r\n"
				+ "Enter your choice > ");
		return;
	}
	
	public static void MainMenue(){
		
		System.out.print("\nWhat do you want to do?\n" 
							+ "1. Enter new computers (password required)\n"
							+ "2. Change information of a computer (password required)\n"
							+ "3. Display all computers by a specific brand\n"
							+ "4. Display all computers under a certain a price.\n"
							+ "5. Quit\n"
							+ "Please enter your choice > ");
		return ;
	}
	
	

}
