package com.example.basics;

public class Operators {
	
	public Object add(Object A, Object B) {
		
		if(A instanceof Integer && B instanceof Integer) {
			return (Integer) A + (Integer) B;
		} else if(A instanceof Character && B instanceof Character) {
			return (Character) A + (Character) B;
        } else if(A instanceof String && B instanceof String) {
        	return (String) A + (String) B;
        } else if(A instanceof Float && B instanceof Float) {
        	return (Float) A + (Float) B;
        } else if(A instanceof Double && B instanceof Double) {
        	return (Double) A + (Double) B;
        } else {
            return "Data Type not eligible for this operation or "
            		+ "Cant Add two different Data Type (Data Type Mismatch)";
        }
		
	}
	
	public Object subtract(Object A, Object B) {
		
		if(A instanceof Integer && B instanceof Integer) {
			return (Integer) A - (Integer) B;
		} else if(A instanceof Float && B instanceof Float) {
        	return (Float) A - (Float) B;
        } else if(A instanceof Double && B instanceof Double) {
        	return (Double) A - (Double) B;
        } else {
            return "Data Type not eligible for this operation or "
            		+ "Cant Substract two different Data Type (Data Type Mismatch)";
        }
		
	}
	
	public Object multiplication(Object A, Object B) {
		
		if(A instanceof Integer && B instanceof Integer) {
			return (Integer) A * (Integer) B;
		} else if(A instanceof Float && B instanceof Float) {
        	return (Float) A * (Float) B;
        } else if(A instanceof Double && B instanceof Double) {
        	return (Double) A * (Double) B;
        } else {
            return "Data Type not eligible for this operation or "
            		+ "Cant Multiply two different Data Type (Data Type Mismatch)";
        }
		
	}
	
	public Object division(Object A, Object B) {
		
		if(A instanceof Integer && B instanceof Integer) {
			return (Integer) A / (Integer) B;
		} else if(A instanceof Float && B instanceof Float) {
        	return (Float) A / (Float) B;
        } else if(A instanceof Double && B instanceof Double) {
        	return (Double) A / (Double) B;
        } else {
            return "Data Type not eligible for this operation or "
            		+ "Cant Divide two different Data Type (Data Type Mismatch)";
        }
		
	}
	
	
	public static void main(String[] args) {
		
		Operators operators = new Operators();
		System.out.println(operators.add(10.0, 60.0));
		System.out.println(operators.subtract(10.0, 60.0));
		System.out.println(operators.multiplication(10.0, 60.0));
		System.out.println(operators.division(10.0, 60.0));
		
	}

}
