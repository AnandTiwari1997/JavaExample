package com.impetus.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.impetus.exception.InvalidLength;

/**
 * This class will take input matrix input and find 2x2 square matrix.
 * 
 * @author anand.tiwari
 *
 */
public class Matrix {

	/** static declaration of logger. */
	private static final Logger LOGGER = Logger.getLogger(Matrix.class);
	private static final Scanner SCANNER = new Scanner(System.in);
	public static final int SIZE = 4;

	private int rows = 0;
	private int columns = 0;

	/**
	 * Getting dimension of matrix input from user.
	 * 
	 * @return character matrix.
	 */
	public int[] getDimension() {

		// Taking correct input i.e. rows and columns from the user.
		do {
			try {
				if (rows == 0) {
					LOGGER.info("Enter the number of rows of matrix : ");
					rows = SCANNER.nextInt();
				}
				if (columns == 0) {
					LOGGER.info("Enter the number of columns of matrix : ");
					columns = SCANNER.nextInt();
				}
			} catch (InputMismatchException e) {
				SCANNER.next();
				LOGGER.error("Please enter correct input (Only Integers).");
			}
		} while (rows == 0 || columns == 0);

		return new int[] { rows, columns };

	}

	/**
	 * This method will get matrix from user.
	 * 
	 * @param rows
	 *            number of rows.
	 * @param columns
	 *            number of columns.
	 * @return character array.
	 */
	public char[][] getMatrix(int rows, int columns) {
		LOGGER.info("Enter the Element of the matrix : ");
		char[][] array = new char[rows][columns];
		int row = 0;

		do {
			int col = 0;
			do {
				try {
					array[row][col] = SCANNER.next().charAt(0);
					col++;
				} catch (InputMismatchException e) {
					SCANNER.next();
					LOGGER.error("Please enter correct input (Only Character).");
				}
			} while (columns > col);
			row++;
		} while (rows > row);

		return array;
	}

	/**
	 * Get String whose 2x2 square matrix we are searching.
	 * 
	 * @return string.
	 */
	public String getString() {

		LOGGER.info("Enter String you want to search : ");
		return SCANNER.next();
	}

	/**
	 * This method will find index of element of string in matrix.
	 * 
	 * @param array
	 *            character matrix.
	 * @param search
	 *            a string to search.
	 * @return String index.
	 */
	public String find2x2Matrix(char[][] array, String search) {
		
		
		if (search.length() == 0 || array == null) throw new NullPointerException("Search string and matrix can not be null");
		if (search.length() < SIZE) {
			try {
				throw new InvalidLength("Length of string must be 4 or more.");
			} catch (InvalidLength e) {
				e.getMessage();
			}
		}

		Set<String> set = new HashSet<>();
		Map<Character, IndexWrapper> map = new HashMap<>();
		
		if (rows == 0 || columns == 0) {
			rows = array.length;
			columns = array[0].length;
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				for (int k = 0; k < search.length(); k++) {
					if (array[i][j] == search.charAt(k)) {

						String lowerRight = null;
						String lowerLeft = null;
						String upperRight = null;
						String upperLeft = null;

						if (i == 0) {

							if (j == 0) {
								lowerRight = findLowerRightMatrix(array, i, j, search);
							} else if (j > 0 && j == columns - 1) {
								lowerLeft = findLowerLeftMatrix(array, i, j, search);
							} else {
								lowerRight = findLowerRightMatrix(array, i, j, search);
								lowerLeft = findLowerLeftMatrix(array, i, j, search);
							}

						} else if (i > 0 && i == rows - 1) {

							if (j == 0) {
								upperRight = findUpperRightMatrix(array, i, j, search);
							} else if (j > 0 && j == columns - 1) {
								upperLeft = findUpperLeftMatrix(array, i, j, search);
							} else {
								upperRight = findUpperRightMatrix(array, i, j, search);
								upperLeft = findUpperLeftMatrix(array, i, j, search);
							}

						} else {

							if (j == 0) {
								upperRight = findUpperRightMatrix(array, i, j, search);
								lowerRight = findLowerRightMatrix(array, i, j, search);
							} else if (j > 0 && j == columns - 1) {
								upperLeft = findUpperLeftMatrix(array, i, j, search);
								lowerLeft = findLowerLeftMatrix(array, i, j, search);
							} else {
								upperRight = findUpperRightMatrix(array, i, j, search);
								upperLeft = findUpperLeftMatrix(array, i, j, search);
								lowerRight = findLowerRightMatrix(array, i, j, search);
								lowerLeft = findLowerLeftMatrix(array, i, j, search);
							}

						}

						if (upperRight != null && upperRight.length() == SIZE) {
							set.add(upperRight);
							map.put(array[i][j], new IndexWrapper(i, j));
						}

						if (upperLeft != null && upperLeft.length() == SIZE) {
							set.add(upperLeft);
							map.put(array[i][j], new IndexWrapper(i, j));
						}

						if (lowerRight != null && lowerRight.length() == SIZE) {
							set.add(lowerRight);
							map.put(array[i][j], new IndexWrapper(i, j));
						}

						if (lowerLeft != null && lowerLeft.length() == SIZE) {
							set.add(lowerLeft);
							map.put(array[i][j], new IndexWrapper(i, j));
						}
					}
				}
			}
		}

		return returnIndex(map, set);

	}

	/**
	 * This method will return the index.
	 * 
	 * @param map
	 *            map contain index information of each element.
	 * @param set
	 *            set contain the matrix string.
	 * @return String index.
	 */
	private String returnIndex(Map<Character, IndexWrapper> map, Set<String> set) {

		List<Character> characters = new ArrayList<>();

		if (!set.isEmpty()) {
			set.forEach(string -> characters.add(string.charAt(0)));

			IndexWrapper indexWrapper = map.get(characters.get(0));
			int i = indexWrapper.getI();
			int j = indexWrapper.getJ();

			if (characters.size() > 1) {
				for (Character character : characters) {
					IndexWrapper indexWrapper2 = map.get(character);
					if (i > indexWrapper2.getI()) {
						i = indexWrapper2.getI();
					} else if (i == indexWrapper2.getI() && j > indexWrapper2.getJ()) {
						j = indexWrapper2.getJ();
					}
				}
			}

			return "Found at index " + i + "-" + j;
		} else {
			return "Not Found";
		}

	}

	/**
	 * This method will find UpperLeft Matrix of from given indexes.
	 * 
	 * @param array
	 *            character matrix.
	 * @param i
	 *            row index.
	 * @param j
	 *            column index.
	 * @param search
	 *            string inputed by user.
	 * @return string of 2x2 matrix.
	 */
	private String findUpperLeftMatrix(char[][] array, int i, int j, String search) {

		String current = String.valueOf(array[i][j]);

		if (search.contains(String.valueOf(array[i][j - 1])))
			current = array[i][j - 1] + current;
		if (search.contains(String.valueOf(array[i - 1][j])))
			current = array[i - 1][j] + current;
		if (search.contains(String.valueOf(array[i - 1][j - 1])))
			current = array[i - 1][j - 1] + current;

		return current;
	}

	/**
	 * This method will find UpperRight Matrix of from given indexes.
	 * 
	 * @param array
	 *            character matrix.
	 * @param i
	 *            row index.
	 * @param j
	 *            column index.
	 * @param search
	 *            string inputed by user.
	 * @return string of 2x2 matrix.
	 */
	private String findUpperRightMatrix(char[][] array, int i, int j, String search) {

		String current = String.valueOf(array[i][j]);

		if (search.contains(String.valueOf(array[i - 1][j + 1])))
			current = array[i - 1][j + 1] + current;
		if (search.contains(String.valueOf(array[i - 1][j])))
			current = array[i - 1][j] + current;
		if (search.contains(String.valueOf(array[i][j + 1])))
			current += array[i][j + 1];

		return current;
	}

	/**
	 * This method will find LowerLeft Matrix of from given indexes.
	 * 
	 * @param array
	 *            character matrix.
	 * @param i
	 *            row index.
	 * @param j
	 *            column index.
	 * @param search
	 *            string inputed by user.
	 * @return string of 2x2 matrix.
	 */
	private String findLowerLeftMatrix(char[][] array, int i, int j, String search) {

		String current = String.valueOf(array[i][j]);

		if (search.contains(String.valueOf(array[i][j - 1])))
			current = array[i][j - 1] + current;
		if (search.contains(String.valueOf(array[i + 1][j - 1])))
			current += array[i + 1][j - 1];
		if (search.contains(String.valueOf(array[i + 1][j])))
			current += array[i + 1][j];

		return current;
	}

	/**
	 * This method will find LowerRight Matrix of from given indexes.
	 * 
	 * @param array
	 *            character matrix.
	 * @param i
	 *            row index.
	 * @param j
	 *            column index.
	 * @param search
	 *            string inputed by user.
	 * @return string of 2x2 matrix.
	 */
	private String findLowerRightMatrix(char[][] array, int i, int j, String search) {

		String current = String.valueOf(array[i][j]);

		if (search.contains(String.valueOf(array[i][j + 1])))
			current += array[i][j + 1];
		if (search.contains(String.valueOf(array[i + 1][j])))
			current += array[i + 1][j];
		if (search.contains(String.valueOf(array[i + 1][j + 1])))
			current += array[i + 1][j + 1];

		return current;
	}

}
