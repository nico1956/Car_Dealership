
public class ElectricCar extends Car{
	
	private String batteryType;
	private double batterySize;
	double filledTankCost;
	
	//Getters
	public String getBattType() {
		return batteryType;
	}
	
	public double getBattSize() {
		return batterySize;
	}
	
	//Setters
	/**
	 * Set Battery type. String.
	 */
	public void setBattType(String type) {
		if (batteryType.isEmpty()) {
			batteryType = "Lithium-ion";
		}
		else {
			batteryType = type;
		}
	}
	
	public void setBattSize(double size) {
		if (batterySize <= 0) {
			batterySize = 30;
		}
		else {
			batterySize = size;
		}
	}
		
	//Default constructor
	public ElectricCar() {
		super();
		batteryType = "Lithium-ion";
		batterySize = 30;
	}
	
	//Overloaded Constructor
	public ElectricCar(String mk, String md, String cl, int yr, int wgh, String type, double size, double pump) {
		super(mk, md, cl, yr, wgh, pump);
		setBattType(type);
		setBattSize(size);
	}
	
	/**
	 * Calculate the cost to recharge a car battery. Returns a Double.
	 */
	@Override
	protected double CalcCostPerFill(double pumpCost) {
		
		return filledTankCost = batterySize * pumpCost;
	}
	
	/**
	 * Override toString(). Prints all the parameters from the abstract class Car plus child class parameters ElectricCar. String
	 */
	public String toString() {
		return super.toString() + "\n" + "Battery type: " + batteryType + "\n" + "Battery Size: " + batterySize + "Kwh " + "\n" + 
				"Pump Cost: " + pumpCost + "$" + "\n" + "Cost to fill the tank: " + filledTankCost + "$";
	}


}
