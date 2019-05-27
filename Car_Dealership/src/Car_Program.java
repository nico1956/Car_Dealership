/*
 * This program will prompt the user to enter information about the car the he or she would like to purchase.
 * The user can choose between electric or gas, and based on the choice, it will be prompted for different types of informations about the car.
 * The program is based on the inheritance of abstract methods and parameters. It uses the parent class "Car", 
 * and the two child classes "ElectricCar" and "GasCar".
 * 
 * Nico Busatto 05/02/2019
 */

import java.util.Scanner;

public class Car_Program {
	
	static Scanner menuScanner;
	static GasCar gas = new GasCar();
	static ElectricCar electric = new ElectricCar();
	
	public static void main(String[] args) {
		
		boolean ok = true;
		boolean ok2 = true;
		boolean ok3 = true;
		char Again = ' ';
		
		init();
		do {
			input();        
			do {
				do {
					System.out.println("Do you want to insert another car? Y or N ");        
					try {
						Again = menuScanner.next().trim().toUpperCase().charAt(0);               
						ok3 = true;
					} catch (Exception e) {                          //Try/catch for empty entry
						System.out.println("No option has been entered, please try again.");
						System.out.println(" ");
						ok3 = false;    			                //Y or N, empty entry loop control
					}
				} while (ok3 == false);	
				if (Again == 'Y') {
					ok = false;
					ok2 = true;	          
				}
				else if (Again == 'N') {
					ok = true;
					ok2 = true;
				} else {
					System.out.println("Invalid entry, only Y or N allowed.");
					System.out.println(" ");
					ok = true;
					ok2 = false;
				}	
			} while (ok2 == false);	   //Y or N, invalid entry loop control	
		} while (ok == false);      //Program loop control
		exit();
	}
	
	public static void init() {
		
		menuScanner = new Scanner(System.in);               //Init new menu scanner
    	menuScanner.useDelimiter(System.getProperty("line.separator"));		
	}
	
	public static void input() {
		
		int iOption = 0;
    	boolean ok = true;   
      	
    	do {
    		try { 
    			System.out.format("%40s%25s%25s", " ", "NICO'S DEALERSHIP", " ");    //Print heading
    			System.out.println("");
    			System.out.println("Welcome! Please make a selection of what type of car you would like to purchase.");
    			System.out.println("");
    			System.out.println("1 - Gas Car");			     		 //Print menu option 1
    			System.out.println("2 - Electric Car");			     	 //Print menu option 2
    			System.out.println("3 - Exit");                          //Print menu option 3
    			System.out.println("");
    			iOption = Integer.parseInt(menuScanner.next());		
					if (iOption == 1) {    
						instantiateGas();  
						gasOutput();
					}
					else if (iOption == 2) {
						instantiateElectric();  
						electricOutput();
					}
					else if (iOption == 3) {
						exit();				
					}
					else {                         //Input check
						System.out.println("Invalid entry, please retry.");
						ok = false;
					}
    		} catch (Exception e) {                //Catch illegal characters in main menu
    			System.out.println("Invalid entry, please retry.");
			    ok = false;	
    		}
    	} while (!ok);     //main menu valid entry loop control	
	}
	
	public static void instantiateGas() {
		String make = "";
		String model = "";
		String color = "";
		String type = "";
		double size = 0.0;
		double pumpCost = 0.0;
		int year = 0;
		int weight = 0;
		boolean good = true;
		
		//Get car make
		System.out.println("Please enter the make of the car: ");
		make = menuScanner.next();
		if (make.isEmpty()) {
			System.out.println("Empty make is not allowed. Make defaulted to Alfa Romeo, hope you like it!");
		}
		gas.setMake(make);
		
		//Get car model
		System.out.println("Please enter the model: ");
		model = menuScanner.next();
		if (model.isEmpty()) {
			System.out.println("Empty model is not allowed. Model defaulted to Giulia Quadrifoglio, you'll like it! ;)!");
		}
		gas.setModel(model);
		
		//Get car color
		System.out.println("Please enter the color: ");
		color = menuScanner.next();
		if (color.isEmpty()) {
			System.out.println("Empty color is not allowed. Color defaulted to Red, Alfa must be red!");
		}
		gas.setColor(color);
		
		//Get car year
		do {
			try {
				System.out.println("What model year would you like? ");
				year = Integer.parseInt(menuScanner.next());
				if (year <= 0) {
					System.out.println("Year defaulted to latest model.");
					good = true;
				}
				else {
					good = true;
				}
			} catch (Exception e) {
				System.out.println("Only numbers allowed, please retry.");
				good = false;
			}	
		} while (!good);
		gas.setYear(year);
		
		//Get car weight
		do {
			try {
				System.out.println("Inert car weight: ");
				weight = Integer.parseInt(menuScanner.next());
				if (weight <= 0) {
					System.out.println("Car weight defaulted to 4500Lbs");
					good = true;
				}
				else {
					good = true;
				}
			} catch (Exception e) {
				System.out.println("Only numbers allowed, please retry.");
				good = false;
			}	
		} while (!good);
		gas.setWeight(weight);
		
		//Get fuel type
		System.out.println("Insert fuel Type: ");
		type = menuScanner.next();
		if (type.isEmpty()) {
			System.out.println("Fuel type defaulted to gasoline");
		}
		gas.setFuelType(type);
		
		//Get tank size
		do {
			try {
				System.out.println("Insert tank size: ");
				size = Double.parseDouble(menuScanner.next());
				if (size <= 0) {
					System.out.println("Tank defaulted to 19 Gal.");
					good = true;
				}
				else {
					good = true;
				}
			} catch (Exception e) {
				System.out.println("Only numbers allowed, please retry.");
				good = false;
			}	
		} while (!good);
		gas.setTankSize(size);
		
		//Get pump cost
		do {
			try {
				System.out.println("Insert pump cost: ");
				pumpCost = Double.parseDouble(menuScanner.next());
				if (pumpCost <= 0) {
					System.out.println("Pump cost defaulted to $0.11");
					good = true;
				}
				else {
					good = true;
				}
			} catch (Exception e) {
				System.out.println("Only numbers allowed, please retry.");
				good = false;
			}	
		} while (!good);
		electric.CalcCostPerFill(pumpCost);
	}
	
	public static void instantiateElectric() {
		String make = "";
		String model = "";
		String color = "";
		String type = "";
		double size = 0.0;
		double pumpCost = 0.0;
		int year = 0;
		int weight = 0;
		boolean good = true;
		
		//Get car make
		System.out.println("Please enter the make of the car: ");
		make = menuScanner.next();
		if (make.isEmpty()) {
			System.out.println("Empty make is not allowed. Make defaulted to Alfa Romeo, hope you like it!");
		}
		electric.setMake(make);
		
		//Get car model
		System.out.println("Please enter the model: ");
		model = menuScanner.next();
		if (model.isEmpty()) {
			System.out.println("Empty model is not allowed. Model defaulted to Giulia Quadrifoglio, you'll like it! ;)!");
		}
		electric.setModel(model);
		
		//Get car color
		System.out.println("Please enter the color: ");
		color = menuScanner.next();
		if (color.isEmpty()) {
			System.out.println("Empty color is not allowed. Color defaulted to Red, Alfa must be red!");
		}
		electric.setColor(color);
		
		//Get car year
		do {
			try {
				System.out.println("What model year would you like? ");
				year = Integer.parseInt(menuScanner.next());
				if (year <= 0) {
					electric.setYear(year);
					System.out.println("Year defaulted to latest model.");
					good = true;
				}
				else {
					good = true;
				}
			} catch (Exception e) {
				System.out.println("Only numbers allowed, please retry.");
				good = false;
			}	
		} while (!good);
		electric.setYear(year);
		
		//Get car weight
		do {
			try {
				System.out.println("Insert car weight: ");
				weight = Integer.parseInt(menuScanner.next());
				if (weight <= 0) {
					System.out.println("Weight defaulted to 3806Lbs");
					good = true;
				}
				else {
					good = true;
				}
			} catch (Exception e) {
				System.out.println("Only numbers allowed, please retry.");
				good = false;
			}	
		} while (!good);
		electric.setWeight(weight);
		
		//Get battery type
		System.out.println("Insert battery Type: ");
		type = menuScanner.next();
		if (type.isEmpty()) {
			System.out.println("Battery type defaulted to Lithium");
		}
		electric.setBattType(type);
		
		//Get battery size
		do {
			try {
				System.out.println("Insert battery size: ");
				size = Double.parseDouble(menuScanner.next());
				if (size <= 0) {
					System.out.println("Battery size defaulted to 19.8");
					good = true;
				}
				else {
					good = true;
				}
			} catch (Exception e) {
				System.out.println("Only numbers allowed, please retry.");
				good = false;
			}	
		} while (!good);
		electric.setBattSize(size);
		
		//Get pump cost
		do {
			try {
				System.out.println("Insert pump cost: ");
				pumpCost = Double.parseDouble(menuScanner.next());
				if (pumpCost <= 0) {
					System.out.println("Pump cost defaulted to $0.11");
					good = true;
				}
				else {
					good = true;
				}
			} catch (Exception e) {
				System.out.println("Only numbers allowed, please retry.");
				good = false;
			}	
		} while (!good);
		electric.setPumpCost(pumpCost);
		electric.CalcCostPerFill(pumpCost);
	}
	
	public static void gasOutput() {
		System.out.println("");
		System.out.println("Your car specs are the following: ");                        //Print output including gas car results
		System.out.println(gas.toString());
	}
	
	public static void electricOutput() {
		System.out.println("");
		System.out.println("Your car specs are the following: ");                       //Print output including electric car results
		System.out.println(electric.toString());
	}
	
	public static void exit() {
		System.out.println("Program ending, have a great day!");                        //Print closing message and terminate process.
    	System.exit(0);
	}
}