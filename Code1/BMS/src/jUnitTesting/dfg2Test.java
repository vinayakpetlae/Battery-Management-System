package jUnitTesting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.bmsmain.PriorityAnalysis;

class dfg2Test {
	
	PriorityAnalysis pa = new PriorityAnalysis();

	@Test
	void test1() {
		pa.setTotalProcessesRunning(0);
		boolean output = pa.analysePriority();
		assertFalse(output);
	}
	
	@Test
	void test2() {
		pa.setTotalProcessesRunning(5);
		boolean output = pa.analysePriority();
		assertTrue(output);
	}

}
