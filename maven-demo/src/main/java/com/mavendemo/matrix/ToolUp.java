package com.mavendemo.matrix;

public class ToolUp {

	public static void main(String[] args) {
		
		
		
		Matrix matrix = new Matrix();
		char[][] array = matrix.getMatrix();
		String string = matrix.getString();
		matrix.findPattern(array, string);
		
	}

}
