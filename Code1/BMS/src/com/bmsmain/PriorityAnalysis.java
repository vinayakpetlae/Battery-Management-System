package com.bmsmain;

import com.globalconstants.*;

public class PriorityAnalysis {
	
	MainClass mainClass = new MainClass();
	Devices devices = new Devices();
	
	//Get count of priority processes running
	int totalProcessesRunning=devices.getProcesses();

	public boolean analysePriority() {
		
		boolean priorityRunning;
	
		System.out.println("Total "+totalProcessesRunning+" processes are running in the background");
		if(totalProcessesRunning > 0){
			System.out.println("Checking for priority processes.....");
			System.out.println("Priority process running in the background is "+GlobalConstants.PROCESS_A);
			System.out.println("No action taken");
			mainClass.continueJourney();
			priorityRunning = true;
		}
		else{
			System.out.println("Checking for priority processes.....");
			System.out.println("No priority processes running\n");
			priorityRunning = false;
		}
		return priorityRunning;
	}
	
	public int getTotalProcessesRunning() {
		return totalProcessesRunning;
	}

	public void setTotalProcessesRunning(int totalProcessesRunning) {
		this.totalProcessesRunning = totalProcessesRunning;
	}
}
