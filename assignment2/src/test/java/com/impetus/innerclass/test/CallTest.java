/**
 * 
 */
package com.impetus.innerclass.test;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.impetus.exception.InvalidNumber;
import com.impetus.innerclass.Call;
import com.impetus.innerclass.Calling;

/**
 * @author anand.tiwari
 *
 */
public class CallTest {
	
	/**
	 * Some Private and Static declaration.
	 */
	private static final Logger LOGGER = Logger.getLogger(CallTest.class);
	private static Call call;

	/**
	 * @throws java.lang.Exception Exception object.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		call = new Call();
	}

	/**
	 * Test method for {@link com.impetus.innerclass.Call#Call(com.impetus.innerclass.Calling)}.
	 */
	@Test
	public void testCallCallingSuccess() {
		
		// Success test
		String number = "1234567890";
		call.callAnonymous(number);
		
		
		call.makeCall(number);
		
	}
	
	/**
	 * Test method for {@link com.impetus.innerclass.Call#Call(com.impetus.innerclass.Calling)}.
	 */
	@Test (expected = InvalidNumber.class )
	public void testCallCallingFailed() {		
		
		// failure test 1 : null value passed
		String number = null;
		call.callAnonymous(number);
		
		//failure test 2 : alphabet passed
		number = "12345ABC";
		call.callAnonymous(number);
	}

}
