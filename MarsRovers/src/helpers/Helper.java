/**
 * 
 */
package helpers;

import model.Direction;
import model.Position;
import model.Rover;
import model.World;

/**
 * @author User
 *extra helper methods
 */
public class Helper{
	public static int[] ValidateUpperRightCoordinates(String coordinates){
		int[] dimensions = {0,0};
		try {
			String[] parts = coordinates.split(" ");
			if(parts.length != 2) throw new Exception();
			dimensions[0] = Integer.parseInt(parts[0]);
			dimensions[1] = Integer.parseInt(parts[1]);
			if(dimensions[0] <=0 || dimensions[1] <= 0) throw new Exception();
			return dimensions;
		}catch(Exception e) {
			dimensions[0] = 0;
			dimensions[1] = 0;
			return dimensions;
		}
	}
	public static Position ValidatePosition(World world,String coordinates){
		Position position;
		try {
			String[] parts = coordinates.split(" ");
			int x = Integer.parseInt(parts[0]);
			int y = Integer.parseInt(parts[1]);
			if(x<0 || y<0 || x> world.getWidth() || y > world.getHeight()) throw new Exception();//ensure rove doesnt move outside plateau baundries
			
			Direction dir = getValueOfDirection(parts[2].charAt(0));
			
			position = new Position(x,y,dir);
			if(!IsPositionAvailable(world,position,null))throw new Exception(); //check if position is empty(no rover on the same position)
			
			return position;
		}catch(Exception e) {
			return null;
		}
	}
	public static Direction getValueOfDirection(char dir) throws Exception{
		switch(dir) {
		case 'N':
		case 'n':
			return Direction.NORTH;
		case 'E':
		case 'e':
			return Direction.EAST;
		case 'S':
		case 's':
			return Direction.SOUTH;
		case 'W':
		case 'w':
			return Direction.WEST;
			default:
				throw new Exception();
			
		}
	}
	public static Boolean IsPositionAvailable(World world,Position newPosition,Rover currentRover){
		for(int i = 0;i<world.GetRoversCount();i++) {
			Position tempPosition ;
			Rover rover = world.GetRover(i);
			
			if(!rover.hasMoved()) { //if the rover has already executed its intsuction we only consider the end position
				tempPosition = rover.getStartPosition(); 
			}else {
				tempPosition = rover.getEndPosition();
			}
			if(rover != currentRover && (newPosition.getX() ==  tempPosition.getX() && newPosition.getY() == tempPosition.getY())) {
				return false;
			}
			if(PositionOutOfBounds(world,newPosition)) {
				return false;
			}
		}
		return true;
	}
	public static Boolean PositionOutOfBounds(World world,Position position) {
		return position.getX() < 0 || position.getX() > world .getWidth() || position.getY() <0 || position.getY() >world.getHeight();
	}
	public static Boolean IsValidInstructions(String instructions){
		for(char c : instructions.toCharArray()) {
			switch(c) {
			case 'M':
			case 'm':
			case 'R':
			case 'r':
			case 'L':
			case 'l':
				break;
				default:
					return false;
			}
		}
		return true;
	}


}
