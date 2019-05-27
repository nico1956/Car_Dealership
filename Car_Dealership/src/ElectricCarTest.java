import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ElectricCarTest extends Car {
	
	static ElectricCar ec;
	
	@BeforeAll
	protected static void onlyOnce() {
		ec = new ElectricCar();
	}
	
	@Test
	void testCalcCostPerFill() {
		double pumpCost = 0.11;
		
		ec.setBattSize(30);
		assertEquals(ec.CalcCostPerFill(pumpCost), 3.3);
	}

	@Override
	protected double CalcCostPerFill(double pumpCost) {
		// TODO Auto-generated method stub
		return 0;
	}
}
