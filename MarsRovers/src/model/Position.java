/**
 * 
 */
package model;

/**
 * @author User
 * Position in a 2D world
 */

public class Position {
	int x;
	int y;
	Direction direction;
	/**
	 * @param x coordinate
	 * @param y coordinate
	 * @param direction
	 */
	public Position(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}

