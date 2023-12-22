package OP_assignment1;

public class NumValidationException extends RuntimeException{
	//Constructors
	public NumValidationException() {
		super();
	}
			
	public NumValidationException(String message) {
		super(message);
	}
			
	public String getMessage() {
		return super.getMessage();
	}
	
	
	public static Double isNumeric(String str) {
		// Handle empty string 
		if (str == null || str.trim().isEmpty()) {
        
			throw new NumValidationException("Error: No Input.");
        }
		
        try {
        	
            Double x = Double.parseDouble(str);
            return x;
        } catch (NumberFormatException e) {
        	
        	throw new NumValidationException("Error: Input is not a number");
            
        }
    }
	
	//The Number class is an abstract class that is the superclass of all numeric classes 
	//such as Integer, Double, Long, etc. It provides common methods like intValue(), doubleValue()
	public static void isPositve(Number x) {
		//Math.signum returns -1.0 if number is negative;
		//this used with all number format(integer,float, double...)
		if(Math.signum((double)x) == -1.0) {
			throw new NumValidationException("Error: Input is negative number");
		}	
	}
	
	public static void isGreaterThan(Number x, double num) {
		//The doubleValue() method is a method provided by the Number class, 
		//and it is applicable to all subclasses of Number, including integers (Integer, Long, etc.).
		if(x.doubleValue() < num) {
			isPositve(x.doubleValue());
			throw new NumValidationException("Error1: Input is out of range.");
		}
	}

	public static void isLessThan(Number x, double num) {
		//The doubleValue() method is a method provided by the Number class, 
		//and it is applicable to all subclasses of Number, including integers (Integer, Long, etc.).
		if(x.doubleValue() > num) {
			throw new NumValidationException("Error2: Input is out of range");
		}
	}

	
	public static int isInteger(Number x) {
		
		//Double x = isNumeric(x);
		
		double doubleValue = x.doubleValue();
		
		if(doubleValue != (int) doubleValue) {
			throw new NumValidationException("Error: Input is not integer number.");
		}
		
		return (int) doubleValue;
	}
}
