package com.bmsmain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	
	public float reqCharge;
	public static String dest;
	public SOCCalculation socCalculation = new SOCCalculation();
	public SOHCalculation sohCalculation = new SOHCalculation();
	public GUI gui = new GUI();
	float stateOfCharge;
	public BufferedReader br;
	public boolean startedVehicle = true;
	float soh;

	
	public static void main(String[] args) throws IOException {
		MainClass mainClass = new MainClass();
		mainClass.initializeVar();
		mainClass.startVehicle();
	}
	
	public void initializeVar()	{
		//Returns the current state of charge of the battery
		stateOfCharge = socCalculation.SOCMonitoringSystem();
		soh = sohCalculation.SOHMonitoringSystem();	
	}

	public boolean startVehicle() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		if (startedVehicle) {
			System.out.println("Engine has started.");
			gui.displaySOC(0, stateOfCharge);
			
			if(soh<20)	{
				gui.displayAlert(8, soh); 	//Requirement #11
			}

			//Ask for destination from the driver
			gui.enterDestination();
			dest = br.readLine();
			
			while(dest == null || dest.equals(""))	{
				gui.enterDestination();
				dest = br.readLine();
			}
			
			//Distance is calculated by the navigation system.
			Devices devices = new Devices();
			double distance = devices.getDistanceToDestination();
			gui.displayAlert(0, distance);
			
			// checking if SOC is adequate to reach destination
			reqCharge = socCalculation.chargeRequired(distance);
			gui.displayAlert(1, reqCharge);
			
			if (stateOfCharge > 5 && stateOfCharge < 101) {
				if (reqCharge > stateOfCharge && stateOfCharge <= 40 && stateOfCharge > 30) {
					//Check if charge is between 30% and 40%
					action(40);
				}
				else if (reqCharge > stateOfCharge && stateOfCharge <= 30 && stateOfCharge > 20) {
					//Check if charge is between 20% and 30%
					action(30);
				}
				else if (reqCharge > stateOfCharge && stateOfCharge <= 20) {
					//Check if charge is between 5% and 20%
					action(20);
				}
				else {
					//Requirement #3
					gui.displayAlert(2, null);
					System.out.println("No action needs to be taken");
					continueJourney();
				}
			} 
			else {
				//if SOC < 5%, the autonomous car is parked at a safe place
				park();		//Requirement #7
			}
		} 
		else {
			System.out.println("Engine is off");
			startedVehicle = false;
		}
		br.close();
		return startedVehicle;
	}
	
	public void action(int socValue) throws IOException {
		
		if(socValue == 20)	{
			//If SOC < 20%, BMS would alert the driver about it
			//and suggest to search for nearest charging station
			gui.displaySOC(1, stateOfCharge);
			gui.voiceAlert(0);
			String userInput1 = br.readLine();
			if (userInput1.equalsIgnoreCase("y")) {
				gui.displayAlert(3, null);
			} else {
				continueJourney();
			}
		}
		else if(socValue == 30)	{
			//If SOC < 20%, BMS would alert the driver about it
			//and suggest to switch the car to manual mode
			gui.displaySOC(1, stateOfCharge);
			park();
			gui.displayAlert(4, null);
			String response = br.readLine();
			if(response.equals("y"))	{
				startManualMode();	//Requirement #8
			}
			continueJourney();
		}
		else if(socValue == 40)	{
			//If SOC is less than 40%, BMS will analyse all loads currently running.
			//If it is running, BMS will check if any priority processes are going on
			//If no priority processes are running, BMS will alert driver to switch off the loads
			
			PriorityAnalysis priorityAnalysis = new PriorityAnalysis();
			gui.displaySOC(1, stateOfCharge);
			System.out.println("Running Priority Analysis...");
			boolean isRunning = priorityAnalysis.analysePriority();	//Requirement #4
			
			if(!isRunning)	{
				alertToSwitchOffLoads();	//Requirement #5
			}
			continueJourney();

			System.out.println(".........");
			System.out.println(".........");
			System.out.println(".........");
			System.out.println(".........");
			System.out.println(".........");
			System.out.println(".........");

			System.out.println("Destination has arrived");
			park();		//Requirement #9
		}
	}
	
	public void startManualMode() {
		System.out.println("The car is now in manual mode.");
	}
	
	public void alertToSwitchOffLoads() throws IOException {
	
		gui.displayAlert(5, null);
		String userInput = br.readLine();
		if (userInput.equalsIgnoreCase("y")) {
			System.out.println("\n");
			System.out.println("Loads turned off");

			// assuming loads save 12% extra charge
			float newReqCharge = reqCharge - 12;
			
			System.out.println("After turning off loads, the battery charge required to reach destination is "
							+ (int)newReqCharge + " %");
			System.out.println("Battery State Of Charge is enough to reach destination");

		} else {
			gui.displayAlert(6, null);
		}
	}

	public void park() {
		System.out.println("Car Parked");
	}

	public void continueJourney() {
		System.out.println("Journey Continues....");
		stateOfCharge = socCalculation.newSOC();
		gui.displayAlert(7, stateOfCharge);
	}

	public float getSoh() {
		return soh;
	}

	public void setSoh(float soh) {
		this.soh = soh;
	}

	public float getStateOfCharge() {
		return stateOfCharge;
	}

	public void setStateOfCharge(float stateOfCharge) {
		this.stateOfCharge = stateOfCharge;
	}

	
}
