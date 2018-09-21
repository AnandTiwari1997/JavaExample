package com.impetus.reflection;

import java.lang.reflect.Method;

/**
 * Wrapper Class for storing Method Instances.
 * 
 * @author anand.tiwari
 *
 */
public class MethodWrapper {

	private Method method;
	private String modifier;
	private String returnType;
	private String name;
	private StringBuilder paramType;
	@SuppressWarnings("rawtypes")
	private Class[] paramTypes;

	/**
	 * Constructor to initialize all field members.
	 * 
	 * @param method
	 *            an Method Instance.
	 * @param modifier
	 *            a modifiers of the method.
	 * @param returnType
	 *            return type of the method.
	 * @param name
	 *            name of the method.
	 * @param paramType
	 *            name of the parameter type it accepts.
	 * @param paramTypes
	 *            instance of the parameter types.
	 */
	public MethodWrapper(Method method, String modifier, String returnType, String name, StringBuilder paramType,
			@SuppressWarnings("rawtypes") Class[] paramTypes) {
		super();
		this.method = method;
		this.modifier = modifier;
		this.returnType = returnType;
		this.name = name;
		this.paramType = paramType;
		this.paramTypes = paramTypes;
	}

	/**
	 * Get Method instance.
	 * 
	 * @return method instance.
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * Set Method Instance.
	 * 
	 * @param method
	 *            a method instance.
	 */
	public void setMethod(Method method) {
		this.method = method;
	}

	/**
	 * Get Modifier.
	 * 
	 * @return modifier name.
	 */
	public String getModifier() {
		return modifier;
	}

	/**
	 * Set modifier name.
	 * 
	 * @param modifier
	 *            modifier name.
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	/**
	 * Get return Type name.
	 * 
	 * @return return Type name.
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * Set return types name.
	 * 
	 * @param returnType
	 *            return type name.
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	/**
	 * Get Name of the method.
	 * 
	 * @return method name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Name of the method.
	 * 
	 * @param name
	 *            method name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get String name of the Parameter types.
	 * 
	 * @return name of parameter types.
	 */
	public StringBuilder getParamType() {
		return paramType;
	}

	/**
	 * Set String name of the Parameter types.
	 * 
	 * @param paramType
	 *            name of parameter types.
	 */
	public void setParamType(StringBuilder paramType) {
		this.paramType = paramType;
	}

	/**
	 * Get instances of Parameter Type.
	 * 
	 * @return array of the parameter types.
	 */
	@SuppressWarnings("rawtypes")
	public Class[] getParamTypes() {
		return paramTypes;
	}

	/**
	 * Set array of instances of Parameter Type.
	 * 
	 * @param paramTypes
	 *            array of instances of Parameter Type.
	 */
	public void setParamTypes(@SuppressWarnings("rawtypes") Class[] paramTypes) {
		this.paramTypes = paramTypes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getModifier());
		builder.append(" ");
		builder.append(getReturnType());
		builder.append(" ");
		builder.append(getName());
		builder.append(" ( ");
		builder.append(getParamType());
		builder.append(" )");
		builder.append(";");
		return builder.toString();
	}

}
