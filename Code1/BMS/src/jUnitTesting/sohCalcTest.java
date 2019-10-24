package jUnitTesting;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.bmsmain.SOHCalculation;

class sohCalcTest {
	
	SOHCalculation sohCalc = new SOHCalculation();
	float sohOutput = sohCalc.SOHMonitoringSystem();

	@Test
	void test1Soh() {
		assertFalse(sohOutput < 0);
	}
	
	@Test
	void test2Soh() {
		assertFalse(sohOutput > 100);
	}

}
