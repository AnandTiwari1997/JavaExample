/**
 * 
 */
package com.impetus.reflection.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.impetus.reflection.FieldWrapper;
import com.impetus.reflection.FindPrivateMember;
import com.impetus.reflection.MethodWrapper;

/**
 * @author anand.tiwari
 *
 */
public class FindPrivateMemberTest {
	
	/**
	 * Some Private and Static declaration.
	 */
	private static final Logger LOGGER = Logger.getLogger(FindPrivateMemberTest.class);
	private static FindPrivateMember findPrivateMember;
	private static List<MethodWrapper> methodWrappers = new ArrayList<>(); 
	private static List<FieldWrapper> fieldWrappers = new ArrayList<>(); 
	private MethodWrapper methodWrapper;
	private FieldWrapper fieldWrapper;

	/**
	 * @throws java.lang.Exception Exception.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		findPrivateMember = new FindPrivateMember();
		Class cls;
		try {
			cls = Class.forName("java.util.Date");
			methodWrappers = findPrivateMember.findPrivateMethod(cls);
			fieldWrappers = findPrivateMember.findPrivateField(cls);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Class Not Found.");
		}	
	}

	/**
	 * Test method for {@link com.impetus.reflection.FindPrivateMember#getUserInput()}.
	 */
	@Test
	public void testGetUserInput() {
		findPrivateMember.getUserInput();
	}

	/**
	 * Test method for {@link com.impetus.reflection.FindPrivateMember#showPrivateMethod()}.
	 */
	@Test
	public void testShowPrivateMethod() {
		findPrivateMember.showPrivateMethod();
	}
	
	
	/**
	 * Test method for {@link com.impetus.reflection.FindPrivateMember#showPrivateField()}.
	 */
	@Test
	public void testShowPrivateField() {
		findPrivateMember.showPrivateField();
	}

	/**
	 * Test method for {@link com.impetus.reflection.FindPrivateMember#invokeMethod(com.impetus.reflection.MethodWrapper)}.
	 */
	@Test 
	public void testInvokeMethodSuccess() {
		methodWrapper = methodWrappers.get(6);
		findPrivateMember.invokeMethod(methodWrapper);
	}
		
	/**
	 * Test method for {@link com.impetus.reflection.FindPrivateMember#findPrivateField(java.lang.Class)}.
	 */
	@Test
	public void testFindPrivateFieldSuccess() {
		Class cls;
		try {
			cls = Class.forName("java.util.Date");
			fieldWrappers = findPrivateMember.findPrivateField(cls);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Class Not Found.");
		}
	}
	
	
	/**
	 * Test method for {@link com.impetus.reflection.FindPrivateMember#findPrivateField(java.lang.Class)}.
	 */
	@Test (expected = ClassNotFoundException.class)
	public void testFindPrivateFieldFailed() {
		Class cls;
		try {
			cls = Class.forName("com.impetus.Permutation");
			fieldWrappers = findPrivateMember.findPrivateField(cls);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Class Not Found.");
		}
	}

	
	/**
	 * Test method for {@link com.impetus.reflection.FindPrivateMember#findPrivateMethod(java.lang.Class)}.
	 */
	@Test
	public void testFindPrivateMethodSuccess() {
		Class cls;
		try {
			cls = Class.forName("java.util.Date");
			methodWrappers = findPrivateMember.findPrivateMethod(cls);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Class Not Found.");
		}		
	}
	
	
	/**
	 * Test method for {@link com.impetus.reflection.FindPrivateMember#findPrivateMethod(java.lang.Class)}.
	 */
	@Test (expected = ClassNotFoundException.class)
	public void testFindPrivateMethodFailed() {
		Class cls;
		try {
			cls = Class.forName("com.impetus.Permutation");
			methodWrappers = findPrivateMember.findPrivateMethod(cls);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Class Not Found.");
		}		
	}

}
