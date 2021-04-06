/**
 * 
 */
package gui;

import model.World;

/**
 * @author User
 *
 */
public class UserInterface {
	//constants
	public static String INVALID_INPUT_MESSAGE = "Invalid input, please try again. \n";
	public static String POSITION_NOT_AVAILABLE = "The specified Position is not available, please use different coordinates. \n";
	public static String ENTER_UPPER_RIGHT_COORDS = "enter upper-right coordinates : ";
	public static String EXECUTING_ROVERS_INSTRUCTIONS = "Execution rovers instructions, please wait... : ";
	
	//heper methods
	public static String  DisplayUpperRightCoordsHint() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("\n");
		strBuilder.append("---------------------------");
		strBuilder.append("\n");
		strBuilder.append("COORDINATES EXAMPLE");
		strBuilder.append("\n");
		strBuilder.append("Correct   : 5 5");
		strBuilder.append("\n");
		strBuilder.append("Correct   : 10 5");
		strBuilder.append("\n");
		strBuilder.append("Incorrect   : 0 5");
		strBuilder.append("\n");
		strBuilder.append("Incorrect : 55 ");
		strBuilder.append("\n");
		strBuilder.append("Incorrect : -5 5 ");
		strBuilder.append("\n");
		strBuilder.append("Incorrect : x 6");
		strBuilder.append("\n");
		strBuilder.append("Incorrect :    ");
		strBuilder.append("\n");
		strBuilder.append("---------------------------");
		return strBuilder.toString();
	}
	public static String RoverDeploymentDetailsRequest(World world,String details) {
		String displayMessage = "Enter Rover "+(world.GetRoversCount()+1)+"/"+world.GetMaxRovers()+"'s "+ details;
		if(world.GetRoversCount()>0) {
			displayMessage += " /  Enter Z to Continue";
		}
		return displayMessage+": ";
	}
	
	public static String  DisplayRoverDeploymentDetailsHint(World world) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("\n");
		strBuilder.append("===========================");
		strBuilder.append("\n");
		strBuilder.append("POSITION RESTRICTION");

		strBuilder.append("\n");
		strBuilder.append("Position: x y X");
		strBuilder.append("\n");
		strBuilder.append(" Where  0 <= x <= "+world.getWidth());
		strBuilder.append("\n");
		strBuilder.append(" Where  0 <= y <= "+world.getHeight());
		strBuilder.append("\n");
		strBuilder.append(" Where  X is Element of{N,E,S,W} only");
		strBuilder.append("\n");
		strBuilder.append("Movement Instructtions Restrictions");
		strBuilder.append("\n");
		strBuilder.append("Movement Intrsctions : XXXXXXXXXXXXXXXXX");
		strBuilder.append("\n");
		strBuilder.append(" Where  X is Element of{M,R,L} only");
		strBuilder.append("\n");
		strBuilder.append(" Where  M-> Move, R-> rotate 90* to right, L-> rotate 90* to Left");
		strBuilder.append("\n");
		strBuilder.append("===========================");
		strBuilder.append("\n");
		strBuilder.append("---------------------------");
		strBuilder.append("\n");
		strBuilder.append("Rover Deployment Details Example");
		strBuilder.append("\n");
		strBuilder.append("Correct Position   : "+getRandomNumber(0,world.getWidth())+" "+getRandomNumber(0,world.getHeight())+" E");
		strBuilder.append("\n");
		strBuilder.append("Correct Position   : "+getRandomNumber(0,world.getWidth())+" "+getRandomNumber(0,world.getHeight())+" N");
		strBuilder.append("\n");
		strBuilder.append("Incorrect : -5 5 E ");
		strBuilder.append("\n");
		strBuilder.append("Incorrect : 5 6 x");
		strBuilder.append("\n");
		strBuilder.append("Incorrect : 4 E");
		strBuilder.append("\n");
		strBuilder.append("Incorrect :    ");
		strBuilder.append("\n");
		strBuilder.append("---------------------------");
		return strBuilder.toString();
	}
	public static int getRandomNumber(int min, int max){
	    int x = (int) ((Math.random()*((max-min)+1))+min);
	    return x;
	}

}

