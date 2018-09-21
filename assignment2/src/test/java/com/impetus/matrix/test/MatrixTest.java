/**
 * 
 */
package com.impetus.matrix.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.impetus.exception.InvalidLength;
import com.impetus.matrix.Matrix;

/**
 * @author anand.tiwari
 *
 */
public class MatrixTest {
	
	/** static declaration of logger. */
	private static final Logger LOGGER = Logger.getLogger(Matrix.class);
	public static final int SIZE = 3;
	private static int  rows;
	private static int columns;
	private static char[][] charMatrix;
	private static Matrix matrix;

	/**
	 * @throws java.lang.Exception an Exception Object.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		matrix = new Matrix();
		rows = SIZE;
		columns = SIZE;
		charMatrix = new char[rows][columns];
		matrix.getDimension();
	}

	/**
	 * Test method for {@link com.impetus.matrix.Matrix#getMatrix()}.
	 */
	@Test
	public void testGetMatrix() {
		charMatrix = matrix.getMatrix(rows, columns);
	}


	/**
	 * Test method for {@link com.impetus.matrix.Matrix#find2x2Matrix(char[][], java.lang.String)}.
	 */
	@Test (expected = NullPointerException.class)
	public void testFind2x2MatrixFailed1() {
		String string = "";
		char[][] charMatrix = {
				{'a', 'b', 'c', 'd'},
				{'e', 'f', 'g', 'h' }
		};
		matrix.find2x2Matrix(charMatrix, string);
	}
	
	/**
	 * Test method for {@link com.impetus.matrix.Matrix#find2x2Matrix(char[][], java.lang.String)}.
	 */
	@Test (expected = InvalidLength.class)
	public void testFind2x2MatrixFailed2() {
		String string = "abc";
		char[][] charMatrix = {
				{'a', 'b', 'c', 'd'},
				{'e', 'f', 'g', 'h' }
		};
		matrix.find2x2Matrix(charMatrix, string);
	}
	
	/**
	 * Test method for {@link com.impetus.matrix.Matrix#find2x2Matrix(char[][], java.lang.String)}.
	 */
	@Test 
	public void testFind2x2MatrixSuccess1() {
		String string = "123456";
		char[][] charMatrix = {
				{'a', 'b', 'c', 'd'},
				{'e', 'f', 'g', 'h' }
		};
		assertEquals("Not Found", matrix.find2x2Matrix(charMatrix, string));
	}
	
	/**
	 * Test method for {@link com.impetus.matrix.Matrix#find2x2Matrix(char[][], java.lang.String)}.
	 */
	@Test 
	public void testFind2x2MatrixSuccess2() {
		String string = "abcdef";
		char[][] charMatrix = {
				{'a', 'b', 'c', 'd'},
				{'e', 'f', 'g', 'h' }
		};
		assertEquals("Found at index 0-0", matrix.find2x2Matrix(charMatrix, string));
	}

}
