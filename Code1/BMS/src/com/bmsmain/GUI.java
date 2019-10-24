package com.bmsmain;

public class GUI {
	
	public void displaySOC(int index, float stateOfCharge)	{
		if(index == 0)	{
			System.out.println("Initial State of Charge of the battery = "+ stateOfCharge + "%");
		}
		else	{
			System.out.println("Battery low! Charge remaining is "+stateOfCharge+"%");
		}
	}
	
	public void enterDestination()	{
		//Requirement #1
		System.out.print("Enter destination (Eg:Limerick):");
	}
	
	public void displayAlert(int index, Object parameter)	{
		if(index == 0)	{
			System.out.println("Total distance till " + MainClass.dest + " is "+ parameter + " km");
		}
		else if(index == 1)	{
			System.out.println("Total charge required to reach " + MainClass.dest+ " is " + parameter + "%" + "\n");
		}
		else if(index == 2)	{
			System.out.println("Remaining charge is enough to reach destination");
		}
		else if(index == 3)	{
			System.out.println("Activating GoogleMaps...");
			System.out.println("Searching for nearest charging point...");
			System.out.println("Charging station found! (Location Shared)");
		}
		else if(index == 4)	{
			System.out.print("Switch to manual mode?[y/n] ");
		}
		else if(index == 5)	{
			System.out.println("Battery low! Please turn off all entertainment devices and WiFi.");
			System.out.print("Turn off loads? [y/n] ");
		}
		else if(index == 6)	{
			System.out.println("WARNING! Remaining battery charge is not enough to reach destination");
		}
		else if(index == 7)	{
			System.out.println("Remaining charge is: "+ parameter + "%");
		}
		else if(index == 8)	{
			System.out.println("State Of Health of battery is low! -> "+parameter);
		}
	}
	
	public void voiceAlert(int index)	{
		if(index == 0)	{
			System.out.print("Voice Alert:: Search for nearest charging point? [y/n] ");
		}
	}

}
