/**
 * 
 */
package test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import helpers.Helper;

/**
 * @author User
 *
 */
public class TestMovement {
	@Before                                         
    public void setUp() throws Exception {
		
    }
	@Test 
    public void testUpperRightCoordinatesValid() {
		int[] expectedValues = {5,5};
		
		assertArrayEquals("Valid Coordinates",expectedValues, Helper.ValidateUpperRightCoordinates("5 5"));          
    }
}
