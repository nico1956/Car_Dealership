
public class GasCar extends Car{
	
	private String fuelType;
	private double tankSize;
	double filledTankCost;
	
	//Getters
	public String getFuelType() {
		return fuelType;
	}
	
	public double getTankSize() {
		return tankSize;
	}
		
	//Setters
	/**
	 * Set fuel type. String.
	 */
	public void setFuelType(String type) {
		if (fuelType.isEmpty()) {
			fuelType = "Gasoline";
		}
		else {
			fuelType = type;
		}
	}
	
	/**
	 * Set tank size. Double.
	 */
	public void setTankSize(double size) {
		if (tankSize <= 0) { 
			tankSize = 19.8;
		}
		else {
			tankSize = size;
		}
	}
		
	//Default constructor
	public GasCar() {
		super();
		fuelType = "Gasoline";
		tankSize = 19.8;
	}
	
	//Overloaded Constructor
	public GasCar(String mk, String md, String cl, int yr, int wgh, String type, int size, double pump) {
		super(mk, md, cl, yr, wgh, pump);
		setFuelType(type);
		setTankSize(size);
	}
	
	/**
	 * Calculate the cost to fill a gas tank. Returns a Double.
	 */
	@Override
	protected double CalcCostPerFill(double pumpCost) {
		
		return filledTankCost = tankSize * pumpCost;
	}
	
	/**
	 * Override toString(). Prints all the parameters from the abstract class Car plus child class parameters GasCar. String
	 */
	public String toString() {
		return super.toString() + "\n" + "Fuel type: " + fuelType + "\n" + "Fuel tank size: " + tankSize + " Gal." + "\n" +
				"Pump cost: " + pumpCost + "$" + "\n" + "Cost to fill the tank: " + filledTankCost + "$";
	}	
}

