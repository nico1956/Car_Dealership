
public class CarTest {

	public static void main(String[] args) {
		
		double pumpCost = 2.5;
		double pumpCost1 = 0.11;
		
		GasCar gc1 = new GasCar();
		ElectricCar ec1 = new ElectricCar();
		
		gc1.setMake("Lamborghini");
		gc1.setModel("Urus");
		gc1.setColor("");
		gc1.setYear(2019);
		gc1.setWeight(4850);
		gc1.setFuelType("Gasoline");
		gc1.setTankSize(19.8);
		gc1.CalcCostPerFill(pumpCost);
		
		System.out.println(gc1.toString());
		System.out.println("");
		
		ec1.setMake("Tesla");
		ec1.setModel("Model 3");
		ec1.setColor("");
		ec1.setYear(2019);
		ec1.setWeight(4850);
		ec1.setBattType("Lithium");
		ec1.setBattSize(100);
		ec1.CalcCostPerFill(pumpCost1);
		
		System.out.println(ec1.toString());
		System.out.println("");
	}
}