package com.mavendemo.reflection;

import java.lang.reflect.Field;

public class FieldWrapper {
	
	private Field field;
	private String modifier;
	private String type;
	private String name;
	
	
	public FieldWrapper(Field field, String modifier, String type, String name) {
		super();
		this.field = field;
		this.modifier = modifier;
		this.type = type;
		this.name = name;
	}


	public Field getField() {
		return field;
	}


	public void setField(Field field) {
		this.field = field;
	}


	public String getModifier() {
		return modifier;
	}


	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getModifier());
		builder.append(" ");
		builder.append(getType());
		builder.append(" ");
		builder.append(getName());
		builder.append(";");
		return builder.toString();
	}
	
	
	

}
