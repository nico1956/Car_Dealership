import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GasCarTest extends Car {
	
	static GasCar gc;
	
	@BeforeAll
	protected static void onlyOnce() {
		gc = new GasCar();
	}
	
	@Test
	void testCalcCostPerFill() {
		double pumpCost = 3.0;

		gc.setTankSize(20);
		assertEquals(gc.CalcCostPerFill(pumpCost), 60.0);
	}

	@Override
	protected double CalcCostPerFill(double pumpCost) {
		
		return 0;
	}

}