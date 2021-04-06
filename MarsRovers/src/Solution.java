import java.util.Scanner;

import gui.UserInterface;
import helpers.Helper;
import model.Position;
import model.Rover;
import model.World;

/**
 * 
 */

/**
 * @author User
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);//initialise system scanner
		World plateau;
		
		System.out.println(UserInterface.DisplayUpperRightCoordsHint());//display input hint
		
		while(true) {
			System.out.print(UserInterface.ENTER_UPPER_RIGHT_COORDS);//ask user for input
			
			String coordsInputStr = sc.nextLine();   //reads input
			int[] Coords = Helper.ValidateUpperRightCoordinates(coordsInputStr);
			
			if(Coords[0] == 0 || Coords[1] == 0) {
				System.out.print(UserInterface.INVALID_INPUT_MESSAGE);
			}else {//create world/plateau
				plateau = new World(Coords[0],Coords[1]);
				break;
			}
		}
		
		
		//Add rovers to world/plateau
		System.out.println(UserInterface.DisplayRoverDeploymentDetailsHint(plateau));
		Boolean exitLoop = false;
		for(int i = 0;i<plateau.GetMaxRovers();i++) {
			int step =0; //step 0:ask for position, step 1 ask for instructions/movements, step 3 deploy Rover
			Position position = null;
			String instructions = "";
			if(exitLoop)break;
			while(step <3) {
				if(step == 0) {
					System.out.println(UserInterface.RoverDeploymentDetailsRequest(plateau, "position"));
					String positionStr = sc.nextLine();   //reads input
					if(plateau.GetRoversCount()>0 && positionStr.toUpperCase().charAt(0) =='Z') {
						exitLoop =true;
						break;
					}
					System.out.println("input position: "+positionStr);
					
					position = Helper.ValidatePosition(plateau, positionStr);
					if(position == null) {
						System.out.print(UserInterface.INVALID_INPUT_MESSAGE);
					}else {
						if(!Helper.IsPositionAvailable(plateau, position)) {
							System.out.print(UserInterface.POSITION_NOT_AVAILABLE);
						}else {
							step ++;
						}
					}
					
				}else if(step ==1) {
					System.out.println(UserInterface.RoverDeploymentDetailsRequest(plateau, "Instructions"));
					String InstructionsStr = sc.nextLine();   //reads input
					if(plateau.GetRoversCount()>0 && InstructionsStr.toUpperCase().charAt(0) =='Z') {
						exitLoop =true;
						continue;
					}
					System.out.println("input instructions: "+InstructionsStr);
					if(!Helper.IsValidInstructions(InstructionsStr)) {
						System.out.print(UserInterface.INVALID_INPUT_MESSAGE);
					}else {
						instructions = InstructionsStr;
						step++;
					}
				}else if(step == 2) {
					Rover rover = new Rover(position,instructions);
					plateau.AddRover(rover);
					step ++;
				}
			}
			
		}
		
		
		System.out.println(plateau.ToString());
		System.out.println(UserInterface.EXECUTING_ROVERS_INSTRUCTIONS);
		
		plateau.ExecuteRoversInstructions();
		System.out.println(plateau.ToString());
		System.out.println("Mars Exploration Complete");
		
	}
	

}
