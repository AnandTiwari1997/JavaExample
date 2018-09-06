package com.example.basics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;



/**
 * Implementation of Custom ArrayList.
 * @author anand.tiwari
 *
 */
class MyArrayList implements List<Object>, Collection<Object>{
	
	private static Logger logger = Logger.getLogger(MyArrayList.class);
	
    private Object[] list;
    private static int defaultLength = 10;
    private int count = 0;
	
    
    
    /**
     * Constructor.
     */
    MyArrayList() {
    	this(defaultLength);
    }
    
    
    
    
    /**
     * Parameterized constructor for initialization of ArrayList.
     * @param defaultLength2
     */
    MyArrayList(int defaultLength2) {
    	if (defaultLength2 > 0) {
    		list = new Object[defaultLength2];
    	}else {
    		list = new Object[1];
    	}
	}
    
    
    
    /**
     * This method will return the allocated size of the ArrayList.
     * @return defaultLength
     */
    public int getAllocatedSize() {
    	return defaultLength;
    }

    
    
    
    /**
     * Method to remove all item from list.
     */
    public void clear() {
    	if (count != 0) {
    		defaultLength = 10;
    		list = new Object[defaultLength];
    		count = 0;
    	}
    }
    
    
    
    
    /**
     * This method add the object at specific index.
     * @param index
     * @param object
     */
    public void add(int index, Object object) {
    	
    	if ( index == count ) {
    		list[index] = object;
    		count++;
    	}else if(index < count) {
    		list[index] = object;
    	}else {
    		throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    	}
    	
    }
    
    
    /**
     * This method will return the object at specified index.
     * @param index
     * @return object
     */
    public Object get(int index) {
    	
    	if(count <= index) {
    		throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    	}else {
	    	Object item = -1;
	    	for (int i = 0; i < count; i++) {
	    		if(i == index) {
	    			item = list[i];
	    			break;
	    		}
	    	}
	    	return item; 
    	}
    }
    
    
    /**
     * method return length of the list.
     * @return length
     */
    public int size() {
        return count;
    }
    
    
    /**
     * This method will trim the initial capacity of the ArrayList Instance to the element present.
     */
    public void trimToSize() {
    	defaultLength = count;
    	list = Arrays.copyOf(list, defaultLength);
    }
    
    
    
    
    /**
     * method for finding index of an object in ArrayList.
     * @param object
     * @return integer
     */
    public int indexOf(Object object) {
    	int index = -1;
    	if(count == 0) {
    		new EmptyArrayListException("Size: " + count);
    	} else {
    		for (int i = 0; i < count; i++) {
    			if (list[i] == object) {
    				index = i;
    				break;
    			}
    		}
    		
    	}
		return index;
		
    }
    
    
    
    /**
     * This method will return the last index of an object.
     * @param object
     * @return lastIndex
     */
    public int lastIndexOf(Object object) {
    	int lastIndex = -1;
    	if(count == 0) {
    		new EmptyArrayListException("Size: " + count);
    	} else {
    		for (int i = 0; i < count; i++) {
    			if(list[i] == object) {
    				lastIndex = i;
    			}
    		}
    	}
    	return lastIndex;
    }
    
    
    
    @Override
    public String toString() {
    	String stringList = "[";
    	for (int i = 0; i < count; i++) {
    		if(i == count - 1) {
    			stringList += " " +list[i];
    		} else {
    			stringList += " " +list[i] + ",";
    		}
    	}
    	stringList += "]";
		return stringList;
    	
    }




	@Override
	public boolean add(Object object) {
		
		logger.info("Inside add()....");

    	if (count >= defaultLength) {
    		defaultLength = defaultLength + (int)defaultLength / 2;
    		list = Arrays.copyOf(list, defaultLength);
    	}
    	list[count] = object;
    	count++;
		return true;
	}
	
	
	
	@Override
	public boolean contains(Object object) {
		int index = -1;
    	if(count == 0) {
    		new EmptyArrayListException("Size: " + count);
    	} else {
    		for (int i = 0; i < count; i++) {
    			if (list[i] == object) {
    				index = i;
    				break;
    			}
    		}
    		
    	}
    	
    	if(index != -1) {
    		return true;
    	}
		return false;
	}
	
	
	
	
	@Override
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}
	
	
	
	
	@Override
	public boolean remove(Object object) {
		int index = -1;
    	if(count == 0) {
    		new EmptyArrayListException("Size: " + count);
    	} else {
    		for (int i = 0; i < count; i++) {
    			if (list[i] == object) {
    				index = i;
    				remove(index);
    			}
    		}
    		
    	}
    	
    	if(index != -1) {
    		return true;
    	}
		return false;
	}
	
	
	
	
	@Override
	public Object remove(int index) {
		Object item;
		if (count > index) {
	    	Object[] newList = new Object[defaultLength];
	    	for (int i = 0; i < index; i++) {
	    		newList[i] = list[i];
	    	}
	    	
	    	for (int j = index; j < count - 1; j++) {
	    		newList[j] = list[j + 1];
	    	}
	    	
	    	item = get(index);
	    	
	    	count--;
	    	list = Arrays.copyOf(newList, defaultLength);
    	} else {
    		throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    	}
		return item;
	}
	
	
	
	@Override
	public Object set(int index, Object object) {
		if ( index == count ) {
    		list[index] = object;
    		count++;
    	}else if(index < count) {
    		list[index] = object;
    	}else {
    		throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    	}
		return get(index);
	}





	@Override
	public boolean addAll(Collection<? extends Object> object) {
		return true;
	}




	@Override
	public boolean addAll(int arg0, Collection<? extends Object> arg1) {
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> arg0) {
		return false;
	}



	@Override
	public Iterator<Object> iterator() {
		return null;
	}




	@Override
	public ListIterator<Object> listIterator() {
		return null;
	}




	@Override
	public ListIterator<Object> listIterator(int arg0) {
		return null;
	}




	@Override
	public boolean removeAll(Collection<?> arg0) {
		return false;
	}




	@Override
	public boolean retainAll(Collection<?> arg0) {
		return false;
	}



	@Override
	public List<Object> subList(int arg0, int arg1) {
		return null;
	}




	@Override
	public Object[] toArray() {
		return null;
	}




	@Override
	public <T> T[] toArray(T[] arg0) {
		return null;
	}

}



/**
 * Class to test the MyArrayList Implementation.
 * @author anand.tiwari
 *
 */
public class TestMyArrayList {
	
	
	
    /**
	 * main method.
	 * @param args
	 */
    public static void main(String[] args) {
    	
        MyArrayList list = new MyArrayList();
        list.remove("John");
        list.add("John");
    }
}
