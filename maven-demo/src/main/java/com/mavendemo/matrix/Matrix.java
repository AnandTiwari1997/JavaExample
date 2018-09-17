package com.mavendemo.matrix;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {

	private static Scanner scanner = new Scanner(System.in);
	
	private int rows = 0;
	private int columns = 0;
	

	public char[][] getMatrix() {
		
		// Taking correct input i.e. rows and columns from the user.
		do {
			try {
				if (rows == 0) {
					System.out.println("Enter the number of rows of matrix : ");
					rows = scanner.nextInt();
				}
				if (columns == 0) {
					System.out.println("Enter the number of columns of matrix : ");
					columns = scanner.nextInt();
				}
			} catch(InputMismatchException e) {
				scanner.next();
				System.out.println("Please enter correct input (Only Integers).");
			}
		} while (rows == 0 || columns == 0);
		
		
		System.out.println("Enter the Element of the matrix : ");
		char[][] array = new char[rows][columns];
		int row = 0;
		
		
		do {
			int col = 0;
			do {
				try{
					array[row][col] = scanner.next().charAt(0);
					col++;
				} catch (InputMismatchException e) {
					scanner.next();
					System.out.println("Please enter correct input (Only Character).");
				}
			}while(columns > col);
			row++;
		}while (rows > row );
		
		return array;
		
	}
	
	public String getString() {
		
		System.out.println("Enter String you want to search : ");
		String search = scanner.next();
		return search;
	}
	
	
	public void findPattern(char[][] array, String search) {
		
		HashMap<Character, IndexWrapper> hashMap = new HashMap<>();
		
		for (int  i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++) {
				for (int k = 0; k < search.length(); k++) {
					if (array[i][j] == search.charAt(k)) {
						IndexWrapper wrapper = new IndexWrapper(i, j);
						hashMap.put(search.charAt(k), wrapper);
						break;
					}
				}
			}
		}
		
		System.out.println(hashMap);
		
	}

}
