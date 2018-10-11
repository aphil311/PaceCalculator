import java.util.Scanner;
public class CalcTime {
	public static void main(String[] args) {
		// Objects
		Scanner scan = new Scanner(System.in);
		// Variables
		int distance, min, sec, tempInt, distanceSel;
		int hr = 0;																				// In case not initialized
		boolean pushUnits = false, hours = false;
		final boolean METRIC = true;											// Toggles meters/miles
		int tempS, tempM;																	// Allows cycling times
		String tempStr;
		char units = 'a';
		System.out.println("-------------");
		System.out.println("| 1. 1600m  |");
		System.out.println("| 2. 3200m  |");
		System.out.println("| 3. 5000m  |");
		System.out.println("| 4. 1 Mile |");
		System.out.println("| 5. 2 Mile |");
		System.out.println("| 6. 3 Mile |");
		System.out.println("| 7. Half   |");
		System.out.println("| 8. Full   |");
		System.out.println("| 9. Custom |");
		System.out.println("-------------");
		System.out.print("Selection: ");
		distanceSel =  scan.nextInt();
		// Custom distance
		if(distanceSel == 9){
			pushUnits = true;
			// Menu
			System.out.println("-------------");
			System.out.println("| 1. Meters |");
			System.out.println("| 2. Miles  |");
			System.out.println("-------------");
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
		switch(distanceSel){
			case 1:	distance = 1600;
			break;
			case 2: distance = 3200;
			break;
			case 3:	distance = 5000;
			break;
			case 4:	distance = 1609;		// One Mile
			break;
			case 5: distance = 3218;		// Two Mile
			break;
			case 6: distance = 4828;		// Three Mile
			break;
			case 7:	distance = 21082;		// Half Marathon
			break;
			case 8:	distance = 42164;		// Full Marathon
			break;
   		default:distance = 5000;		// Defaults to a 5k for XC season
    	break;
		}
		tempStr = null;
		System.out.print("Time: ");
		tempStr = scan.next();
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
		if(METRIC){
			System.out.println(time1.get1600());
			System.out.println(time1.get5k());
		}
	}
}
