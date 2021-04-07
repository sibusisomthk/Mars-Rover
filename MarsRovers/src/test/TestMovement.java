/**
 * 
 */
package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import helpers.Helper;
import model.Direction;
import model.Position;
import model.Rover;
import model.World;

/**
 * @author User
 *
 */
public class TestMovement {
	private World world;
	@Before                                         
    public void setUp() throws Exception {
    }
	@Test 
    public void testRotateRightValid() {
		World world = new World(5,5);
		world.AddRover(new Rover(new Position(0,0,Direction.NORTH),"R"));
		
		assertEquals("Valid Position Direction",new Position(0,0,Direction.EAST).getDirection(), world.ExecuteInstruction(world.GetRover(0).getStartPosition(), 'R',world.GetRover(0)).getDirection());          
    }
	@Test 
    public void testRotateRightValid2() {
		World world = new World(5,5);
		world.AddRover(new Rover(new Position(0,0,Direction.WEST),"R"));
		
		assertEquals("Valid Position Direction",new Position(0,0,Direction.NORTH).getDirection(), world.ExecuteInstruction(world.GetRover(0).getStartPosition(), 'R',world.GetRover(0)).getDirection());          
    }
	@Test 
    public void testRotateLeftValid() {
		World world = new World(5,5);
		world.AddRover(new Rover(new Position(0,0,Direction.NORTH),"L"));
		
		assertEquals("Valid Position Direction",new Position(0,0,Direction.WEST).getDirection(), world.ExecuteInstruction(world.GetRover(0).getStartPosition(), 'l',world.GetRover(0)).getDirection());          
    }
	@Test 
    public void testRotateLeftValid2() {
		World world = new World(5,5);
		world.AddRover(new Rover(new Position(0,0,Direction.WEST),"L"));
		
		assertEquals("Valid Position Direction",new Position(0,0,Direction.SOUTH).getDirection(), world.ExecuteInstruction(world.GetRover(0).getStartPosition(), 'L',world.GetRover(0)).getDirection());          
    }
	@Test 
    public void testRotateMoveValid() {
		World world = new World(5,5);
		world.AddRover(new Rover(new Position(0,0,Direction.WEST),"M"));
		
		
		assertEquals("cannot move out of Grid Boundry",null, world.ExecuteInstruction(world.GetRover(0).getStartPosition(), 'M',world.GetRover(0)));          
    }
	@Test 
    public void testRotateMoveValid2() {
		World world = new World(5,5);
		world.AddRover(new Rover(new Position(1,0,Direction.WEST),"M"));
		
		
		assertEquals("cannot move out of Grid Boundry",0, world.ExecuteInstruction(world.GetRover(0).getStartPosition(), 'M',world.GetRover(0)).getX());          
    }
}
