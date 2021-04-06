/**
 * 
 */
package model;

import java.util.ArrayList;

import helpers.Helper;

/**
 * @author User
 *2 Dimensional world
 */
public class World {
	int height;
	int width;
	int maxRovers;
	ArrayList<Rover> rovers;
	/**
	 * @param height
	 * @param width
	 * @param rovers
	 * maxRovers maximum number of rovers allowed on the grid/world
	 */
	public World(int height, int width) {
		super();
		this.height = height;
		this.width = width;
		this.maxRovers = (this.height * this.width)/2;
		this.rovers = new ArrayList<>();
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * method to sequential execute each rover's NASA instructions 
	 */
	public void RollOutRovers() {
		System.out.println("moving rovers");
		for(int i = 0;i<rovers.size()-1;i++) {
			
		}
	}
	/**
	 * method to get maximum number of rovers allowed
	 */
	public int GetMaxRovers() {
		return maxRovers;
	}
	/**
	 * method to current number of rovers on the grid/world
	 */
    public int GetRoversCount() {
		return rovers.size();
	}
    /**
	 * method to add a new rover on the grid/world
	 */
    public void AddRover(Rover rover) {
    	rovers.add(rover);
    }
    public Rover GetRover(int i) {
    	return rovers.get(i);
    }
    public String ToString() {
    	StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("\n");
		strBuilder.append("Plateau Details \n");
		strBuilder.append("UpperRight: X-> "+this.width+", Y-> "+this.height+" \n");
		strBuilder.append("BottomLeft: X-> 0, Y-> 0 \n");
		strBuilder.append("Rovers Count-> "+this.rovers.size()+", Maximum Rovers(size/3)-> "+this.maxRovers+ "\n");
		strBuilder.append("=================================== \n");
		strBuilder.append("Rovers Details \n");
		for(int i =0;i<rovers.size();i++) {
			strBuilder.append("Rover "+(i+1)+"/"+rovers.size()+"\n");
			strBuilder.append(rovers.get(i).ToString());
		}
    	return strBuilder.toString();
    }
    public Position ExecuteInstruction(Position position,char c) {
    	if(c =='R' || c == 'r') {//Rotate rover
    		switch(position.getDirection()) {
    		case NORTH:
    			position.setDirection(Direction.EAST);
    		case EAST:
    		position.setDirection(Direction.SOUTH);
    		case SOUTH:
    			position.setDirection(Direction.WEST);
    		case WEST:
    			position.setDirection(Direction.NORTH);
    		}
    	}else if(c=='L' || c=='l') {//Rotate rover
    		switch(position.getDirection()) {
    		case NORTH:
    			position.setDirection(Direction.WEST);
    		case EAST:
    		position.setDirection(Direction.NORTH);
    		case SOUTH:
    			position.setDirection(Direction.EAST);
    		case WEST:
    			position.setDirection(Direction.SOUTH);
    		}
    	}else {//Move Rover
    		switch(position.getDirection()) {
    		case NORTH:
    			position.setY(position.getY()+1);
    		case EAST:
    			position.setX(position.getX()+1);
    		case SOUTH:
    			position.setY(position.getY()-1);
    		case WEST:
    			position.setX(position.getX()-1);
    		}
    		if(!Helper.IsPositionAvailable(this, position)) position = null;//this will trigger end of rover movement.
    	}
    	return position;
    }
    public void ExecuteRoversInstructions() {
    	for(int i = 0;i<rovers.size();i++) {
    	   Rover tempRover = rovers.get(i);
    	   tempRover.endPosition = tempRover.startPosition;
    	   tempRover.hasMoved =true;//start using end position 
    	   rovers.set(i, tempRover);//update element
    	   
    	   char[] instructions= tempRover.instructions.toCharArray();
    	   for(int s = 0;s<instructions.length;s++) {
    		  Position newPosition = ExecuteInstruction(new Position(tempRover.endPosition.getX(),tempRover.endPosition.getY(),tempRover.endPosition.getDirection()),instructions[s]);
    		  if(newPosition == null) {//obsticle ahead, rover can noloner move.
    			  break;
    		  }
    		  tempRover.endPosition = newPosition;
    		  rovers.set(i, tempRover);//update element
    	   }
    	}
    }
    
}
