package test;

import static org.junit.Assert.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result inputResult = JUnitCore.runClasses(TestInput.class);
		Result moveResult = JUnitCore.runClasses(TestMovement.class);
		
	    for (Failure failure : inputResult.getFailures()) {
	       System.out.println(failure.toString());
	    }
	    for (Failure failure : moveResult.getFailures()) {
		       System.out.println(failure.toString());
		}
	    System.out.println("Input Test Result=="+inputResult.wasSuccessful());
	    System.out.println("Movement Test Result=="+moveResult.wasSuccessful());

	}

}
