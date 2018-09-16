package com.mavendemo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FindPrivateMember {

	private static Scanner scanner = new Scanner(System.in);
	private List<MethodWrapper> methodIntance = new ArrayList<>();
	private List<FieldWrapper> fieldWrappers = new ArrayList<>();

	public void getUserInput() {

		Class cls = null;
		String className = null;

		System.out.println("Enter name of the class with full package name : ");

		do {
			try {
				className = scanner.next();
				cls = Class.forName(className);
			} catch (ClassNotFoundException e) {
				scanner.nextLine();
				e.printStackTrace();
			}
		} while (cls == null);

		System.out.println("");

		System.out.println("Package Name : " + cls.getName());
		System.out.println("Class NAme : " + cls.getSimpleName());

		System.out.println("");

		System.out.println("What You want to Access ?");
		System.out.println("1. Private Fields");
		System.out.println("2. Private Methods");

		int result = scanner.nextInt();
		System.out.println("");

		switch (result) {
		case 1:
			findPrivateField(cls);
			showPrivateField();
			break;
		case 2:
			findPrivateMethod(cls);
			showPrivateMethod();
			break;
		default:
			System.out.println("Please Privide valid Input in 1 or 2.");
		}	
	}
	
	private void showPrivateField() {
		int sNo = 1;
		System.out.println("");
		System.out.println("All Private Fields are : ");
		System.out.println("");
		for (FieldWrapper wrapper : fieldWrappers) {
			System.out.println(sNo + ". " + wrapper);
			sNo++;
		}
	}

	public void showPrivateMethod() {
		int sNo = 1;
		System.out.println("");
		System.out.println("All Private Methods are : ");
		System.out.println("");
		for (MethodWrapper wrapper : methodIntance) {
			System.out.println(sNo + ". " + wrapper);
			sNo++;
		}
		
		System.out.println("");
		System.out.println("Enter the Method number you want to invoke : ");
		int number = 0;
		do {
			try {
			number = scanner.nextInt();
			} catch(InputMismatchException e) {
				scanner.next();
				System.out.println("Please Provide valid Input (Only Integer).");
			}
		}while ( number == 0);
		invokeMethod(methodIntance.get(number - 1));
		
	}
	
	public void invokeMethod(MethodWrapper methodWrapper) {
		
		Method method = methodWrapper.getMethod();
		String name = methodWrapper.getName();
		Class[] paramTypes = methodWrapper.getParamTypes();
		
		int paramNo = 1;
		
		for (Class paramType : paramTypes) {
			System.out.println("Enter the parameter " + paramNo + " of type " + paramType.getName());
			System.out.println(paramType.getTypeName());
			
			paramNo++;
		}
		
	}

	public void findPrivateField(Class cls) {
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			String modifiers = Modifier.toString(field.getModifiers());
			if (modifiers.contains("private")) {
				field.setAccessible(true);
				String type = field.getType().getSimpleName();
				FieldWrapper fieldWrapper = new FieldWrapper(field, modifiers, type, name);
				fieldWrappers.add(fieldWrapper);
			}
		}
	}

	public void findPrivateMethod(Class cls) {
		Method[] methods = cls.getDeclaredMethods();

		for (Method m : methods) {
			
			String name = m.getName();
			String modifier = Modifier.toString(m.getModifiers());
			if (modifier.contains("private")) {
				m.setAccessible(true);
				String retType = m.getReturnType().getSimpleName();
				Class<?>[] paramTypes = m.getParameterTypes();
				StringBuilder paramType = new StringBuilder();
				for (int i = 0; i < paramTypes.length; i++) {
					if (i > 0) {
						paramType.append(", ");
					}
					paramType.append(paramTypes[i].getName());
				}
				MethodWrapper methodWrapper = new MethodWrapper(m, modifier, retType, name, paramType, paramTypes);
				methodIntance.add(methodWrapper);
			}
		}
	}
	
	
	
}
