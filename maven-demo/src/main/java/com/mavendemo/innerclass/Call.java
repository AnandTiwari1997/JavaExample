package com.mavendemo.innerclass;

import java.util.Scanner;

import com.mavendemo.innerclass.interfaces.Calling;

public class Call {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public Call() {}
	
	public Call(Calling calling) {
		calling.calling();
	}
	
	public void makeCall() {
		System.out.println("Calling...");
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter the number to call : ");
		String number = scanner.nextLine();
		
		Call call = new Call(new Calling() {
			
			@Override
			public void calling() {
				System.out.println("Calling " + number);
				
			}
		});
		
		Call call2 = new Call() {
			
			public void makeCall() {
				System.out.println("Calling " + number);
			}
		};
		call2.makeCall();
		
	}	

}
