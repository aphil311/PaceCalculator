//============================================================================
// ~File Name: Time.java
//
// ~Purpose: Take a time and distance, and use it to return equivalent times
//============================================================================

public class Time {
	// Instance data
	private char units;
	private int totalTime;
	private int totalDistance;
	private double distances[] = {1600.0, 3200.0, 5000.0, 1609.0, 3218.0, 4828.0, 21082.0, 42164.0};
	private String distanceS[] = {"1600", "3200", "5000", "1 Mile", "2 Mile", "3 Mile", "Half", "Full"};

	//--------------------------------------------------------------------------
	// Constructor -- Assigns variables for time and distance
	//--------------------------------------------------------------------------
	public Time(int min, int sec, int distance){
		totalTime = min*60+sec;
    totalDistance = distance;
	}

	//--------------------------------------------------------------------------
	// Calculate -- Returns total seconds per race
	//--------------------------------------------------------------------------
  private int calculate(int x){
		double num = distances[x]/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}

	//--------------------------------------------------------------------------
	// GetTime -- Divides total seconds out to larger units
	//--------------------------------------------------------------------------
	public String getTime(int x){
		if((distanceS[x].equals("Half"))||(distanceS[x].equals("Full"))){
			int tempS = this.calculate(x) % 60;
	    int totalMinutes = this.calculate(x) / 60;
	    int tempM = totalMinutes % 60;
	    int tempH = totalMinutes / 60;
			if(tempS<9){
				if(tempM<9){
					return(distanceS[x]+": "+tempH+":0"+tempM+":0"+tempS);
				}
				else{
					return(distanceS[x]+": "+tempH+":"+tempM+":0"+tempS);
				}
			}
			else{
				if(tempM<9){
					return(distanceS[x]+": "+tempH+":0"+tempM+":"+tempS);
				}
				else{
					return(distanceS[x]+": "+tempH+":"+tempM+":"+tempS);
				}
			}
		}
		else{
			int tempM = this.calculate(x)/60;
			int tempS = this.calculate(x)%60;
			if(tempS<9){
				return(distanceS[x]+": "+tempM+":0"+tempS);
			}
			else{
				return (distanceS[x]+": "+tempM+":"+tempS);
			}
		}
	}
	public int getTime(){
		return totalTime;
	}
	public void pushUnits(char iOrE){
		// Miles = i, Meters = e;
		if((iOrE == 'i')||(iOrE =='e'))
			units = iOrE;
		else
			System.out.println("Error: Not a valid character");
	}

	//--------------------------------------------------------------------------
	// PushHour -- Adds hours from main class to Time class
	//--------------------------------------------------------------------------
	public void pushHour(int hour){
		totalTime = totalTime+(hour*60*60);
	}

	//--------------------------------------------------------------------------
	// DSelection -- Returns the distance selected by the user
	//--------------------------------------------------------------------------
	public static int dSelection(int selection){
		int tempDistance;
		switch(selection){
			case 1:	tempDistance = 1600;
			break;
			case 2: tempDistance = 3200;
			break;
			case 3:	tempDistance = 5000;
			break;
			case 4:	tempDistance = 1609;		// One Mile
			break;
			case 5: tempDistance = 3218;		// Two Mile
			break;
			case 6: tempDistance = 4828;		// Three Mile
			break;
			case 7:	tempDistance = 21082;		// Half Marathon
			break;
			case 8:	tempDistance =  42164;	// Full Marathon
			break;
   		default:tempDistance = 5000;		// Defaults to a 5k for XC season
    	break;
		}
		return tempDistance;
	}

	//--------------------------------------------------------------------------
	// ToString -- Returns origional distance and time
	//--------------------------------------------------------------------------
	public String toString(){
    int min = totalTime/60;
    int sec = totalTime%60;
    if(sec<9)
      return totalDistance+" | "+min+":0"+sec;
    else
      return totalDistance+" | "+min+":"+sec;
	}
}
