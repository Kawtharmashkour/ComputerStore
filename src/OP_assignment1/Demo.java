//
// Assignment (1)
// © Kawthar Mashkour
// Written by: Kawthar Mashkour (6284305)
//
//Project Description: Computer Inventory input and manage data.


package OP_assignment1;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int maxNumofComp, numOfPotentialInventory, choice, nNewEntries;
		double price;
		String brand;
		
		System.out.println("\n---- Wellcome in Computer invetory management program ----\n");
		System.out.print("Input the maximum number of computers for the store capacity: ");
		maxNumofComp = inputCheck(1,1999999);
		Computer[] inventory = new Computer[maxNumofComp];
		
		do {
			MainMenue();
			choice = inputCheck(1,5);
			
			switch(choice) {
			//Input inventory
			case 1: if(PassCheck()) {
						System.out.print("\nHow many computers you want to enter? ");
						numOfPotentialInventory = maxNumofComp - Computer.findNumberOfCreatedComputers();
						
						if(numOfPotentialInventory > 0) {
							nNewEntries = inputCheck( 1, numOfPotentialInventory);
							InputInventory(inventory, nNewEntries);
							System.out.println("\n--- All Inventory ---");
							printArray(inventory);
						}else {
							System.out.println("Your store is full");
						}
					}
					break;
			//Update inventory
			case 2: if(PassCheck()) {
						if(Computer.findNumberOfCreatedComputers()>0) {
							System.out.println("\n--- All Inventory ---");
							printArray(inventory);
							UpdateInventory(inventory);
						}else {
							System.out.println("\nError: No INVENTORY in the store");
						}
					}
					break;
			// Search by brand		
			case 3: if(Computer.findNumberOfCreatedComputers()>0) {
						System.out.print("Input the brand you want to search: ");
						brand = inputCheck("");
						findComputersByBrand(inventory,brand);
					}else {
						System.out.println("\nError: No inventory in the store.");
					}
					break;
			//Search by price		
			case 4: if(Computer.findNumberOfCreatedComputers()>0) {
						System.out.print("Enter the maximum price you want to search: ");
						price = inputCheck();
						findCheaperThan(inventory,price);
					}else {
						System.out.println("\nError: No inventory in the store.");
					}
					break;
					
			case 5: System.out.println("\nProgram Exit. "); 
					System.exit(0);
			}
		}while(choice<5);
		
	}
	
//	private static Computer[] appendToArray(Computer[] arr, Computer element) {	
//		Computer[] newArr = Arrays.copyOf(arr, arr.length + 1);
//        newArr[arr.length] = element;
//        System.out.println("newArr : "+Arrays.toString(newArr));
//        return newArr;
//    }
	
	private static void findCheaperThan(Computer[] inven, double price){
		int i;
		int nComputers = Computer.findNumberOfCreatedComputers();
		boolean found = false;
		Computer[] compBrandMatch = new Computer[0];
		
		for(i=0; i<nComputers; i++) {
			if(inven[i].getPrice() < price) {
				System.out.println("\nComputer # "+ (i+1));
				inven[i].toString();
				found = true;
			}
		}
		
		if(!found) {
			System.out.println("No result match your input.");
		}
		
	}
		
	
	
	public static void findComputersByBrand(Computer[] inven, String brand) {
		int i;
		int nComputers = Computer.findNumberOfCreatedComputers();
		boolean found = false;
		Computer[] compBrandMatch = new Computer[0];
		
		for(i=0; i<nComputers; i++) {
			if(inven[i].getBrand().equals(brand)) {
				System.out.println("\nComputer # "+ (i+1));
				inven[i].toString();
				found = true;
			}
		}

		if(!found) {
			System.out.println(" No result match your input.");
		}
		
	}
	
	public static void UpdateInventory(Computer[] inventory) {
		int choice, compNum;
		int numOfComp = Computer.findNumberOfCreatedComputers();
		String brand,model;
		double price;
		long serialNum;
				
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.print("\nWhich computer would like to change? ");
			compNum = inputCheck(1,numOfComp);
			
			SubMenue();
			choice = inputCheck(1,5);
			
			switch(choice) {
			case 1:	
					System.out.print("Input Brand: ");
					brand = inputCheck("");
					inventory[compNum-1].setBrand(brand);
					System.out.print("\n--- after Update ---\n");
					inventory[compNum-1].toString();
					break;
			case 2: System.out.print("Input Model: ");
					model = inputCheck("");
					inventory[compNum-1].setModel(model);
					System.out.print("\n--- after Update ---\n");
					inventory[compNum-1].toString();
					break;
			case 3: 
					do{
						System.out.print("Input Serial number: ");
						//assuming our serial number could begin from 1 
						//max long number = 9223372036854775807L
						serialNum = inputCheck(1,Long.MAX_VALUE);
						if(!IsFoundSerialNum(serialNum, inventory, numOfComp)) {
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
					price = inputCheck();
					inventory[compNum-1].setPrice(price);
					System.out.print("\n--- after Update ---\n");
					inventory[compNum-1].toString();
					break;
			case 5: System.out.print("Go to Main Menue"); 
			}
			
		}while(choice<5);
	}
	
	
	public static boolean IsFoundSerialNum(long sn, Computer[] arr, int n) {
		int i;
		for(i=0; i<n; i++) {
			if(arr[i].getSerialNum() == sn) {
				return true;
			}
		}
		return false;
	}
	
	public static void InputInventory(Computer[] invent, int nNewEnt){
		int i;
		int nComp = Computer.findNumberOfCreatedComputers();
		double price;
		String brand, model;
		
		for(i=0; i<nNewEnt; i++) {
			System.out.println("Computer # "+ (i+1));
			System.out.print("Input Brand: ");
			brand = inputCheck("");
			System.out.print("Input Model: ");
			model = inputCheck("");
			System.out.print("Input Price: ");
			price = inputCheck();
			
			invent[nComp+i] = new Computer(brand, model, price);
		}
		
		return;
	}
	
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
	
	//overload method
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
	
	public static double inputCheck(){
		boolean flag;
		double num;
		Scanner sc = new Scanner(System.in);

		do  {
			num = sc.nextDouble();
		
			if(num <= 0){
				System.out.print("Your input should be a number more than (0): ");
				flag = true;
			}else {
				flag = false;
			}

		}while(flag);
		
		return (num);
	}
	
	public static long inputCheck(long range1, long range2) {
		boolean flag;
		double num;
		String str;

		Scanner sc = new Scanner(System.in);

		do  {
			str = sc.nextLine().trim();
			num = Double.parseDouble(str);
			
			//re-convert num to str to handle error out-of-range of long value
			//this instead of using try and catch error handling
			str = Double.toString(num);
		
			if((num < range1 || num > range2) || (num%1 > 0) || str.contains("E")){
				System.out.print("Your input should be integer in this range ["+ range1 + "-" + range2 + "] : ");
				flag = true;
			}else {
				flag = false;
			}

		}while(flag);
		
		return ((long)num);
	}
	
	public static int inputCheck( int range1, int range2){
		boolean flag;
		double num;

		Scanner sc = new Scanner(System.in);

		do  {
			num = sc.nextDouble();
		
			if((num < range1 || num > range2) || (num%1 > 0)){
				System.out.print("Your input should be integer in this range ["+ range1 + "-" + range2 + "] : ");
				flag = true;
			}else {
				flag = false;
			}

		}while(flag);
		
		return ((int)num);
	}
	
	public static void printArray(Computer[] a) {
		int i;
		int n = Computer.findNumberOfCreatedComputers();
		
		for(i=0; i<n; i++){
			System.out.println("\nComputer # "+ (i+1));
			a[i].toString();
		} 
	}
	
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
