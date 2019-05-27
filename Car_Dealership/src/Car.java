
public abstract class Car {
	private String make, model, color;
	private int year, weight;
	protected double pumpCost;
	
	//Getters
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public double getPumpCost() {
		return pumpCost;
	}
	
	//Setters
	/**
	 * Set car make. String.
	 */
	public void setMake(String mk) {
		if (make.isEmpty()) {
			make = "Alfa Romeo";
		}
		else {
			make = mk;
		}
	}
	
	/**
	 * Set car model. String.
	 */
	public void setModel(String md) {
		if (model.isEmpty()) {
			model = "Giulia Quadrifoglio";
		}
		else {
			model = md;
		}
	}
	
	/**
	 * Set car color. String.
	 */
	public void setColor(String cl) {
		if (color.isEmpty()) {
			color = "Red";
		}
		else {
			color = cl;
		}
	}
	
	/**
	 * Set model year. Integer.
	 */
	public void setYear(int yr) {
		if (year <= 0) {
			year = 2019;
		}
		else {
			year = yr;
		}
	}
	
	/**
	 * Set car weight. Integer.
	 */
	public void setWeight(int wgh) {
		if (weight <= 0) {
			weight = 3806;
		}
		else {
			weight = wgh;
		}	
	}
	
	/**
	 * Set pump cost. Double.
	 */
	public void setPumpCost(double pump) {
		if (pumpCost <= 0) {
			pumpCost = 0.11;
		}
		else {
			pumpCost = pump;
		}
	}
	
	//Default Constructor
	public Car() {
		make = "Alfa Romeo";
		model = "Giulia Quadrifoglio";
		color = "Red";
		year = 2019;
		weight = 3806;
		pumpCost = 0.11;
	}
	
	//Overloaded Constructor
	public Car(String mk, String md, String cl, int yr, int wgh, double pump) {
		setMake(mk);
		setModel(md);
		setColor(cl);
		setYear(yr);
		setWeight(wgh);
		setPumpCost(pump);
	}
	
	public String toString() {
		return "Make: " + make + "\n" + "Model: " + model + "\n" + "Color: " + color + "\n" + "Year: " + year + "\n" + "Weight: " + weight + "Lbs"; 
	}

	protected abstract double CalcCostPerFill(double pumpCost);
}
