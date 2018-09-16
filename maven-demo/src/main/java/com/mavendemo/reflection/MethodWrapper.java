package com.mavendemo.reflection;

import java.lang.reflect.Method;

public class MethodWrapper {
	
	private Method method;
	private String modifier;
	private String returnType;
	private String name;
	private StringBuilder paramType;
	Class[] paramTypes;
	
	
	public MethodWrapper(Method method, String modifier, String returnType, String name, StringBuilder paramType, Class[] paramTypes) {
		super();
		this.method = method;
		this.modifier = modifier;
		this.returnType = returnType;
		this.name = name;
		this.paramType = paramType;
		this.paramTypes = paramTypes;
	}


	public Method getMethod() {
		return method;
	}


	public void setMethod(Method method) {
		this.method = method;
	}
	
	
	public String getModifier() {
		return modifier;
	}


	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	
	public String getReturnType() {
		return returnType;
	}


	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public StringBuilder getParamType() {
		return paramType;
	}


	public void setParamType(StringBuilder paramType) {
		this.paramType = paramType;
	}
	
	
	public Class[] getParamTypes() {
		return paramTypes;
	}


	public void setParamTypes(Class[] paramTypes) {
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
