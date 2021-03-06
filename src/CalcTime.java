//===========================================================================
// ~File Name: CalcTime.java
//
// ~Author: APhil311
//
// ~Purpose: Drives the Time class
//============================================================================

import java.util.Scanner;
public class CalcTime {
	public static void main(String[] args) {
		// Objects
		Scanner scan = new Scanner(System.in);
		// Variables
		int distance, min, sec, tempInt, distanceSel;
		int hr = 0;																				// In case not initialized
		boolean pushUnits = false, hours = false;
		String tempStr;
		char units = 'a';																	// Means nothing

		// Distance menu
		Template.distanceMenu();
		System.out.print("Selection: ");
		distanceSel =  scan.nextInt();
		// Custom distance
		if(distanceSel == 9){
			pushUnits = true;
			// Menu
			Template.unitMenu();
			System.out.print("Selection");
			tempInt = scan.nextInt();
			if(tempInt == 1){
				units = 'e';
			}
			else if(tempInt == 2){
				units = 'i';
			}
			else{
				// Error Catching
				while((tempInt!=1)&&(tempInt!=2)){
					System.out.println("Please select either 1 or 2.");
					System.out.print("Selection: ");
					tempInt = scan.nextInt();
				}
			}
			System.out.print("Distance: ");
			distance = scan.nextInt();
		}
		distance = Time.dSelection(distanceSel);
		tempStr = null;
		System.out.print("Time: ");
		tempStr = scan.next();
		scan.close();
		// Seperates given time into hours, minutes, and seconds
		if(tempStr.length() == 4){
			min = Integer.parseInt(tempStr.substring(0,1));
			sec = Integer.parseInt(tempStr.substring(2,4));
		}
		else if(tempStr.length() == 5){
			min = Integer.parseInt(tempStr.substring(0,2));
			sec = Integer.parseInt(tempStr.substring(3,5));
		}
		else if(tempStr.length() == 7){
			hr = Integer.parseInt(tempStr.substring(0,1));
			min = Integer.parseInt(tempStr.substring(2,4));
			sec = Integer.parseInt(tempStr.substring(5,7));
			hours = true;
		}
		else {
			// Error Catching
			System.out.println("Not a valid time");
			min = 0;
			sec = 0;
		}
		// Object Initialization
		Time time1 = new Time(min, sec, distance);
		// If custom distance
		if(pushUnits){
			time1.pushUnits(units);
		}
		// If marathon/half marathon
		if(hours){
			time1.pushHour(hr);
		}

		// Prints
		for(int i = 0; i<8; i++){
			System.out.println(time1.getTime(i));
		}
	}
}
