package com.bmsmain;

import com.globalconstants.GlobalConstants;

public class SOCCalculation {
	
	public float SOCMonitoringSystem() {
    	
    	//Get temperature, voltage and current from sensors
    	Sensors sensors = new Sensors();
    	return sensors.getStateOfCharge();
	}

    public float chargeRequired(Double distance) {
		//This formula is calculated on the basis that, for 100% charge, a car can travel 200km distance
		float reqdCharge;
		if(distance != null)	{
			reqdCharge = (float) ((100 * distance) / GlobalConstants.DIST_FULL_CHARGE);
		}
		else	{
			reqdCharge = 0f;
		}
		return reqdCharge;
	}

	public float newSOC(){
    	//SOC will be calculated in the time frame of 10 minutes/ 600 seconds
    	//assuming 2% SOC reduces every 10 minutes while the car is running
    	return SOCMonitoringSystem() - 2;
    }

}
