package jUnitTesting;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.bmsmain.Sensors;

class sensorTest {
	
	Sensors sensorTestObj = new Sensors();
	float voltOutput = sensorTestObj.getVoltage1();
	float currOutput = sensorTestObj.getCurrent1();
	float socOutput = sensorTestObj.getStateOfCharge();

	@Test
	void test1Current() {
		assertTrue(currOutput > 299);
		/*Since current is a range from 300-600*/
	}
	
	@Test
	void test2Current() {
		assertTrue(currOutput >= 300);
	}
	
	@Test
	void test3Current() {
		assertTrue(currOutput < 599);
	}
	
	@Test
	void test4Current() {
		assertTrue(currOutput <= 600);
	}
	
	@Test
	void test1Voltage() {
		assertTrue(voltOutput > 9);
		/*Since voltage is a range from 10-15*/
	}
	
	@Test
	void test2Voltage() {
		assertTrue(voltOutput >= 10);
	}
	
	@Test
	void test3Voltage() {
		assertTrue(voltOutput < 16);
	}
	
	@Test
	void test4Voltage() {
		assertTrue(voltOutput <= 15);
	}
	
	@Test
	void test1Soc() {
		assertFalse(socOutput < 0);
	}
	
	@Test
	void test2Soc() {
		assertFalse(socOutput > 100);
	}

}
