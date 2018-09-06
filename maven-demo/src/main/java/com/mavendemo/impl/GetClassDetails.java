package com.mavendemo.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/** This class will provide the details of the required class.
 * 
 * @author anand.tiwari */
public final class GetClassDetails {

    /** Private Default Constructor. */
    private GetClassDetails() {

    }

    /** Print all the Constructor of the Class.
     * 
     * @param cls
     *            class Name
     * @return builder a StringBuilder Object. */
    public static StringBuilder printConstructor(Class<?> cls) {
        Constructor<?>[] constructors = cls.getDeclaredConstructors();

        StringBuilder builder = new StringBuilder();
        builder.append("\n");

        for (Constructor<?> c : constructors) {
            builder.append("\t");
            String name = c.getName();
            String modifier = Modifier.toString(c.getModifiers());
            if (modifier.length() > 0)
                builder.append(modifier + " ");
            builder.append(name + "(");

            Class<?>[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    builder.append(", ");
                builder.append(paramTypes[i].getName());
            }
            builder.append(");");
            builder.append("\n");
        }
        return builder;
    }

    /** Print All the Methods of the Class.
     * 
     * @param cls
     *            class Name
     * @return builder a StringBuilder Object. */
    public static StringBuilder printMethods(Class<?> cls) {
        Method[] methods = cls.getDeclaredMethods();
        StringBuilder builder = new StringBuilder();
        builder.append("\n");

        for (Method m : methods) {
            builder.append("\t");
            String name = m.getName();
            String modifier = Modifier.toString(m.getModifiers());
            if (modifier.length() > 0)
                builder.append(modifier + " ");
            String retType = m.getReturnType().getSimpleName();
            builder.append(retType + " ");
            builder.append(name + "(");

            Class<?>[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    builder.append(", ");
                builder.append(paramTypes[i].getName());
            }
            builder.append(");");
            builder.append("\n");
        }
        return builder;
    }

    /** Print all the Fields of the Class.
     * 
     * @param cls
     *            class name.
     * @return builder a StringBuilder Object. */
    public static StringBuilder printFields(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        builder.append("\n");

        for (Field f : fields) {
            builder.append("\t");
            String name = f.getName();
            String type = f.getType().getSimpleName();
            String modifier = Modifier.toString(f.getModifiers());
            if (modifier.length() > 0)
                builder.append(modifier + " ");
            builder.append(type + " " + name + ";");
            builder.append("\n");
        }
        return builder;
    }
}
