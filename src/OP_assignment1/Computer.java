package OP_assignment1;

public class Computer {
	private String brand;
	private String model;
	private double price;
	private long SerialNum;
	private static long SerialNumCounter = 1000000;
	private static int NumofComputers = 0;
	
	
	//Constructors
	
	public Computer(String br, String mo, double pr) {
		brand = br;
		model = mo;
		price = pr;
		SerialNum = SerialNumCounter;
		SerialNumCounter++;
		NumofComputers++;
		
	}

	//Accessors & Mutators
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getSerialNum() {
		return SerialNum;
	}
	
	public void setSerialNum(long serialNum) {
		SerialNum = serialNum;
	}
	

	public static int findNumberOfCreatedComputers(){
	
		return NumofComputers;
	}
	
	public boolean IsEqual(Object  obj){
		//compares the memory addresses of two objects
		if (this == obj) return true;
		//compare if they are same classes
        if (obj == null || getClass() != obj.getClass()) return false;

        Computer computer = (Computer) obj;

        return brand.equals(computer.brand) && model.equals(computer.model) && price == computer.price;
    }
		

	//printing method
	@Override
	public String toString() {
		System.out.println("Brand= " + brand + " of this\ncomputerModel= "
							+ model + "\nSerialNum= " + SerialNum + " of this\n"
							+ "computerPrice= " + price);
		
		return null;
	}

	

	
	
	
	

}
