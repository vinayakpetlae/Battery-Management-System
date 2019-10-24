package com.bmsmain;

import com.globalconstants.GlobalConstants;

public class SOHCalculation {

	public float SOHMonitoringSystem() {

		float capacity[] = calculateCapacity();
		float initial_capacity = capacity[0];
		float final_capacity = capacity[1];
		float soh = (final_capacity * 100) / initial_capacity;
		return soh;
	}

	public float[] calculateCapacity() {
	
		float f[] = new float[2];
		f[0] = GlobalConstants.INITIAL_CAPACITY; // this capacity value is when the car is just out of the factory
		f[1] = calculateInternalResistance(); // current capacity of the battery
		return f;
	}

	public float calculateInternalResistance() {

		float resistance;		
		Sensors sensors = new Sensors();

		float final_voltage = sensors.getVoltage1() - sensors.getVoltage2();
		float final_current = sensors.getCurrent1() - sensors.getCurrent2();
		resistance = final_voltage / final_current;
		return resistance;
	}
}