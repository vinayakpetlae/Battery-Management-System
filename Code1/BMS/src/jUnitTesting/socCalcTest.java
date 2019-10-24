package jUnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bmsmain.SOCCalculation;

class socCalcTest {
	
	SOCCalculation socCal = new SOCCalculation();
	float charge1 = socCal.chargeRequired(null);
	float charge2 = socCal.chargeRequired(100.0);

	@Test
	void test1() {
		assertTrue(charge1 >= 0);
	}
	
	@Test
	void test2()	{
		assertTrue(charge1 <= 100);
	}
	
	@Test
	void test3()	{
		assertTrue(charge2 >= 0);
	}
	
	@Test
	void test4()	{
		assertTrue(charge2 <= 100);
	}

}
