package com.impetus.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * This class implements a way to access and invoke Private Members of a class.
 * 
 * @author anand.tiwari
 *
 */
public class FindPrivateMember {

	/**
	 * Some Private and Static declaration.
	 */
	private static final Logger LOGGER = Logger.getLogger(FindPrivateMember.class);
	private static Scanner scanner = new Scanner(System.in);
	private List<MethodWrapper> methodIntance = new ArrayList<>();
	private List<FieldWrapper> fieldWrappers = new ArrayList<>();

	/**
	 * Getting input from users.
	 */
	public void getUserInput() {

		@SuppressWarnings("rawtypes")
		Class cls = null;
		String className = null;

		LOGGER.info("Enter name of the class with full package name : ");

		do {
			try {
				className = scanner.next();
				cls = Class.forName(className);
			} catch (ClassNotFoundException e) {
				scanner.nextLine();
				LOGGER.error("Please Provide valid input (i.e. java.util.Date) ");
			}
		} while (cls == null);

		LOGGER.info("");

		LOGGER.info("Package Name : " + cls.getName());
		LOGGER.info("Class NAme : " + cls.getSimpleName());

		LOGGER.info("");

		LOGGER.info("What You want to Access ?");
		LOGGER.info("1. Private Fields");
		LOGGER.info("2. Private Methods");

		int result = scanner.nextInt();
		LOGGER.info("");

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
			LOGGER.info("Please Privide valid Input in 1 or 2.");
		}
	}

	/**
	 * Showing the Private Fields.
	 */
	public void showPrivateField() {
		int sNo = 1;
		LOGGER.info("");
		LOGGER.info("All Private Fields are : ");
		LOGGER.info("");
		for (FieldWrapper wrapper : fieldWrappers) {
			LOGGER.info(sNo + ". " + wrapper);
			sNo++;
		}
	}

	/**
	 * Showing the Private Methods.
	 */
	public void showPrivateMethod() {
		int sNo = 1;
		LOGGER.info("");
		LOGGER.info("All Private Methods are : ");
		LOGGER.info("");
		for (MethodWrapper wrapper : methodIntance) {
			LOGGER.info(sNo + ". " + wrapper);
			sNo++;
		}

		LOGGER.info("");
		LOGGER.info("Enter the Method number you want to invoke : ");
		int number = 0;
		do {
			try {
				number = scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.next();
				LOGGER.error("Please Provide valid Input (Only Integer).");
			}
		} while (number == 0);
		invokeMethod(methodIntance.get(number - 1));

	}

	/**
	 * Invoking the Selected Method.
	 * 
	 * @param methodWrapper
	 *            a object of MethodWrapper.
	 */
	public void invokeMethod(MethodWrapper methodWrapper) {

		if (methodWrapper != null) {
			Method method = methodWrapper.getMethod();
			@SuppressWarnings("rawtypes")
			Class[] paramTypes = methodWrapper.getParamTypes();
			Object[] objects = new Object[paramTypes.length];
	
			int paramNo = 1;
	
			for (@SuppressWarnings("rawtypes")
			Class paramType : paramTypes) {
				LOGGER.info("Enter the parameter " + paramNo + " of type " + paramType.getName());
	
				if (paramType.getSimpleName() == "int")
					objects[paramNo - 1] = (Object) scanner.nextInt();
				else if (paramType.getSimpleName() == "String")
					objects[paramNo - 1] = scanner.next();
				else if (paramType.getSimpleName() == "float")
					objects[paramNo - 1] = scanner.nextFloat();
				else if (paramType.getSimpleName() == "double")
					objects[paramNo - 1] = scanner.nextDouble();
				else
					objects[paramNo - 1] = scanner.nextLine();
	
				paramNo++;
			}
	
			try {
				if (methodWrapper.getModifier().contains("static")) {
					LOGGER.info(method.invoke(null, objects));
				} else {
					LOGGER.info(method.invoke(method.getClass().newInstance(), objects));
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
				LOGGER.error("Unable to invoke method because " + e);
			}
		} else {
			throw new NullPointerException("No Method to invoke.");
		}

	}

	/**
	 * Finding Private Fields of specified class.
	 * 
	 * @param cls
	 *            a Class Instance.
	 * 
	 * @return List containing FieldWrapper objects.
	 */
	public List<FieldWrapper> findPrivateField(@SuppressWarnings("rawtypes") Class cls) {
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
		LOGGER.info("Successfully Find all Private Fields.");
		return fieldWrappers;
	}

	/**
	 * Finding Private Methods of specified class.
	 * 
	 * @param cls
	 *            a Class Instance.
	 * 
	 * @return List containing MethodWrapper objects.
	 */
	public List<MethodWrapper> findPrivateMethod(@SuppressWarnings("rawtypes") Class cls) {
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
		LOGGER.info("Successfully Find all Private Methods.");
		return methodIntance;
	}

}
