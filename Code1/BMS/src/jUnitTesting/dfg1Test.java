package jUnitTesting;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.bmsmain.MainClass;

class dfg1Test {

	MainClass mc = new MainClass();
	
	@Test
	void test1() throws Exception {

		mc.startedVehicle = false;
		boolean output = mc.startVehicle();
		assertFalse(output);
	}
	
	@Test
	void test2() throws Exception {

		mc.startedVehicle = false;
		boolean output = mc.startVehicle();
		assertFalse(output);
	}
	
	@Test
	void test3() throws Exception {
		mc.setStateOfCharge(500);
		boolean output = mc.startVehicle();
		assertFalse(output);
	}
	
}
