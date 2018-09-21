package com.impetus.matrix;

/**
 * Wrapper class to wrap the index values of a element in a string.
 * @author anand.tiwari
 *
 */
public class IndexWrapper {
	
	private int i;
	private int j;
	
	/**
	 * Parameterized Constructor.
	 * @param i index of row
	 * @param j index of column
	 */
	public IndexWrapper(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}


	/**
	 * Getter for row index.
	 * @return row index i.
	 */
	public int getI() {
		return i;
	}


	/**
	 * Setter for row index.
	 * @param i row index
	 */
	public void setI(int i) {
		this.i = i;
	}


	/**
	 * Getter for column index.
	 * @return column index.
	 */
	public int getJ() {
		return j;
	}


	/**
	 * Setter for column index.
	 * @param j column index.
	 */
	public void setJ(int j) {
		this.j = j;
	}

}
