package com.bmsmain;

import com.globalconstants.GlobalConstants;

public class Sensors {
	
	public float getTemperature()	{
		return GlobalConstants.TEMPERATURE;
	}
	
	public float getCurrent1()	{
		return GlobalConstants.CURRENT1;
	}
	
	public float getCurrent2()	{
		return GlobalConstants.CURRENT2;
	}
	
	public float getVoltage1()	{
		return GlobalConstants.VOLTAGE1;
	}
	
	public float getVoltage2()	{
		return GlobalConstants.VOLTAGE2;
	}
	
	public float getStateOfCharge()	{
		//Change this value for different charge scenarios
		return GlobalConstants.INITIAL_SOC;
	}
	
}
