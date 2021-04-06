/**
 * 
 */
package model;

import java.awt.Color;

/**
 * @author User
 * Mars Rover
 */
public class Rover {
	Position startPosition;
	Position endPosition;
	String instructions;
	Boolean hasMoved;
	/**
	 * @param startPosition
	 * @param instructions
	 */
	public Rover(Position startPosition, String instructions) {
		super();
		this.startPosition = startPosition;
		this.instructions = instructions;
		hasMoved = false;
	}
	
	/**
	 * getters and setters
	 */
	public Position getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}
	public Position getEndPosition() {
		return endPosition;
	}
	public Boolean hasMoved() {
		return hasMoved;
	}
	public void setEndPosition(Position endPosition) {
		this.endPosition = endPosition;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public void setInstructions(Boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	public String ToString() {
		StringBuilder strBuilder = new StringBuilder();
		if(!this.hasMoved) {
			strBuilder.append("Start Position: "+this.startPosition.getX()+" "+this.startPosition.getY()+" "+this.startPosition.getDirection()+" \n");
		}else {
			strBuilder.append("End Position: "+this.endPosition.getX()+" "+this.endPosition.getY()+" "+this.endPosition.getDirection()+" \n");
		}
		
		return strBuilder.toString();
		
	}
}
