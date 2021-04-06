/**
 * 
 */
package test;

import helpers.Helper;
import model.Direction;
import model.Position;
import model.Rover;
import model.World;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author User
 *
 */
public class TestInput {
	

	//Upper Right coordinates Tests
	@Before                                         
    public void setUp() throws Exception {
		
    }
	@Test 
    public void testUpperRightCoordinatesValid() {
		int[] expectedValues = {5,5};
		
		assertArrayEquals("Valid Coordinates",expectedValues, Helper.ValidateUpperRightCoordinates("5 5"));          
    }
	@Test 
    public void testUpperRightCoordinatesInvalid() {
		int[] expectedValues = {0,0};
		
		assertArrayEquals("Invalid Coordinates",expectedValues, Helper.ValidateUpperRightCoordinates("5 x"));          
    }
	@Test 
    public void testUpperRightCoordinatesEmpty() {
		int[] expectedValues = {0,0};
		
		assertArrayEquals("Invalid Coordinates",expectedValues, Helper.ValidateUpperRightCoordinates(""));          
    }
	
	//Test Rover Position Input 
	@Test 
    public void testRoverPositionValid() {
		Position expectedValue = new Position(5,5,Direction.NORTH);
		
		//create test world and deploy a rover
		World world = new World(5,5);
		world.AddRover(new Rover(new Position(2,2,Direction.NORTH),"MMRM"));//this rover has not yet moved
		
		Position position =Helper.ValidatePosition(world,"5 5 N");
		
		assertEquals("X coord",expectedValue.getX(), position.getX());
		assertEquals("y coord",expectedValue.getY(), position.getY());
		assertEquals("direction",expectedValue.getDirection(), position.getDirection());
    }
	@Test 
    public void testRoverPositionInvalid1() {
		
		//create test world and deploy a rover
		World world = new World(5,5);
		world.AddRover(new Rover(new Position(5,5,Direction.NORTH),"MMRM"));//this rover has not yet moved
		
		Position position =Helper.ValidatePosition(world,"5 5 N");
		assertEquals("same position rover deployment",null,position);
    }
	@Test 
	public void testRoverPositionInvalid2() {
		
		//create test world and deploy a rover
	    World world = new World(5,5);
		world.AddRover(new Rover(new Position(5,5,Direction.NORTH),"MMRM"));//this rover has not yet moved
		
		Position position =Helper.ValidatePosition(world,"5 x N");
		
		assertEquals("null position",null, position);
    }
	@Test 
	public void testRoverPositionInvali3() {
		
		//create test world and deploy a rover
	    World world = new World(5,5);
		world.AddRover(new Rover(new Position(5,5,Direction.NORTH),"MMRM"));//this rover has not yet moved
		
		Position position =Helper.ValidatePosition(world,"5 -5 N");
		
		assertEquals("null position",null, position);
    }
	
	//Test Rover Instructions Input 
	@Test 
	public void testRoverInstructionsValid() {
		
		assertEquals("null position",true,  Helper.IsValidInstructions("MMRMMLLMRRM"));
    }
	@Test 
	public void testRoverInstructionsValid2() {
		
		assertEquals("null position",true,  Helper.IsValidInstructions("rMRMMlLMRRM"));
    }
	@Test 
	public void testRoverInstructionsInvalid1() {
		
		assertEquals("null position",false,  Helper.IsValidInstructions("rMRMxlLMRRM"));
    }
	@Test 
	public void testRoverInstructionsinvalid2() {
		
		assertEquals("null position",false,  Helper.IsValidInstructions("5tRMMlLMRRM"));
    }
	
	
}
