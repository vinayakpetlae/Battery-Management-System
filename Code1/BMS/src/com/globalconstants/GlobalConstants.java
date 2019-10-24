package com.globalconstants;

public class GlobalConstants {

	/*****************/
	public static final int INITIAL_SOC=18;
	/*****************/

	public static final double DISTANCE = 100;
	public static final boolean START_VEHICLE = true;
	public static final float STATE_OF_HEALTH = 80;
	public static final float  DIST_FULL_CHARGE=200;
	
	//for priority analysis
	public static final int TOTAL_RUNNING_PROCESSES=0;
	public static final boolean PRIORITY_RUNNING=false; // change this to TRUE to change flow of program with priority processes
	public static final boolean PRIORITY_PROCESS_A_RUNNING=true; 
	public static final boolean PRIORITY_PROCESS_B_RUNNING=true; 
	public static final String PROCESS_A="ABS";
	public static final String PROCESS_B="EXTREME WEATHER CONDITIONS";
	
	//calculation of SOC and SOH
	public static final float TEMPERATURE=10;
	public static final float VOLTAGE1=15;
	public static final float VOLTAGE2=2;
	public static final float CURRENT1=450;
	public static final float CURRENT2=435;
	
	public static final float INITIAL_CAPACITY=3;
	
}
