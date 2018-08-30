package com.example.basics;

public class Loops {
	
	private int globalSum;
	
	public void runWhile() {
		
		int localSum = 0;
		
		while(localSum != globalSum) {
			localSum = localSum + 1;
		}
		
		System.out.println(localSum);
		
	}
	
	public void runDoWhile() {
		
		int localSum = 0;
		
		do {
			localSum = localSum + 1;
		}while(localSum != globalSum);
		
		System.out.println(localSum);
		
	}
	
	public void runFor() {
		
		int localSum = 0;
		
		for(; localSum != globalSum; localSum++);
		
		System.out.println(localSum);
		
	}
	
	public static void main(String[] args) {
		
		Loops loops = new Loops();
		loops.globalSum = 10;
		
		loops.runDoWhile();
		loops.runWhile();
		loops.runFor();
		
	}

}
