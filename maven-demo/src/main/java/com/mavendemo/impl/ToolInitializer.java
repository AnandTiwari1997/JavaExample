package com.mavendemo.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * This the class that contain Main Method.
 * 
 * @author anand.tiwari
 */
public class ToolInitializer {

	private static Logger logger = Logger.getLogger(ToolInitializer.class);
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Main Method Execution starts from here.
	 * 
	 * @param args
	 *            other argument.
	 */
	public static void main(String[] args) {

		logger.info("Starting Application.....");

		// MyArrayList arrayList = new MyArrayList();
		// try {
		// arrayList.contains("John");
		// } catch (EmptyArrayListException e1) {
		// logger.error(e1.getMessage());
		// }
		//
		//
		// ObjectClass objectClass = new ObjectClass();
		// logger.info(objectClass);
		// logger.info("Generated hashcode is : " + objectClass.hashCode());

		// String name;
		// StringBuilder builder = new StringBuilder();
		// builder.append("\n");
		//
		// if (args.length > 0)
		// name = args[0];
		// else {
		// logger.info("Enter the Package Name (e.g. java.util.random) : ");
		// name = scanner.next();
		// }
		//
		// try {
		// Class<?> cls = Class.forName(name);
		// Class<?> superCls = cls.getSuperclass();
		//
		// String modifiers = Modifier.toString(cls.getModifiers());
		// if (modifiers.length() > 0)
		// builder.append(modifiers + " ");
		// builder.append(name);
		// if (superCls != null && superCls != Object.class)
		// builder.append(" extends " + superCls.getName());
		// builder.append("{\n");
		// builder.append(GetClassDetails.printConstructor(cls));
		// builder.append(GetClassDetails.printMethods(cls));
		// builder.append(GetClassDetails.printFields(cls));
		// builder.append("\n}");
		//
		// logger.info(builder);
		// } catch (ClassNotFoundException e) {
		// logger.error(e.getMessage());
		// }
		
		// Permutation permutation = new Permutation();
		// Permutation.permutation("PQRS");
		// permutation.findPossiblePermutation("PQR");
		
		Class cls = SingleTonClass.class;
		try {
			logger.debug(SingleTonClass.getInstance().hashCode());
			
			Constructor[] constructors = cls.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true);
				logger.debug(constructor.newInstance().hashCode());
			}
		} catch (InstantiationException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		} catch (IllegalArgumentException e) {
			logger.error(e);
		} catch (InvocationTargetException e) {
			logger.error(e);
		}

		logger.info("Ending Application.......");

	}

}
