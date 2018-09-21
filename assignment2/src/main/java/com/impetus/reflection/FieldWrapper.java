package com.impetus.reflection;

import java.lang.reflect.Field;

/**
 * Wrapper Class for storing Field Instances.
 * 
 * @author anand.tiwari
 *
 */
public class FieldWrapper {

	private Field field;
	private String modifier;
	private String type;
	private String name;

	/**
	 * Constructor to initialize all field members.
	 * 
	 * @param field
	 *            an Field Instance.
	 * @param modifier
	 *            a modifiers of the field.
	 * @param type
	 *            type of the field.
	 * @param name
	 *            name of the field.
	 */
	public FieldWrapper(Field field, String modifier, String type, String name) {
		super();
		this.field = field;
		this.modifier = modifier;
		this.type = type;
		this.name = name;
	}

	/**
	 * Get Field instance.
	 * 
	 * @return field instance.
	 */
	public Field getField() {
		return field;
	}

	/**
	 * Set Field Instance.
	 * 
	 * @param field
	 *            a field instance.
	 */
	public void setField(Field field) {
		this.field = field;
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
	 * Get Type name.
	 * 
	 * @return type name.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set types name.
	 * 
	 * @param type
	 *            name.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get Name of the field.
	 * 
	 * @return field name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Name of the field.
	 * 
	 * @param name
	 *            field name.
	 */
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
