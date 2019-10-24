package jUnitTesting;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.bmsmain.GUI;

class dfg3Test {
	
	GUI guiObj = new GUI();

	@Test
	void test() {
		try	{
			guiObj.displayAlert(8, null);
			assertTrue(true);
		}
		catch (Exception e) {
			fail("Could not implement method: displayAlert");
			assertFalse(true);
		}
	}

}
