package com.impetus.matrix;

import org.apache.log4j.Logger;

/**
 * This the driver class which will create object of the Matrix class.
 * @author anand.tiwari
 *
 */
public class ToolUp {
	
	/** static declaration of logger. */
	private static final Logger LOGGER = Logger.getLogger(Matrix.class);

	/**
	 * Main Method.
	 * @param args some arguments.
	 */
	public static void main(String[] args) {
		
		Matrix matrix = new Matrix();
		int[] dimension = matrix.getDimension();
		char[][] array = matrix.getMatrix(dimension[0], dimension[1]);
		String string = matrix.getString();
		LOGGER.info(matrix.find2x2Matrix(array, string));
		
	}
}
