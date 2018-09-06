package com.mavendemo.template;

import com.mavendemo.exceptions.EmptyArrayListException;

/**
 * This an Interface which is used to create a custom ArrayList.
 * 
 * @author anand.tiwari
 */
public interface IMyArrayList {

	/**
	 * Method to get Allocated size of an ArrayList.
	 * 
	 * @return integer Actual size of the ArrayList.
	 */
	int getAllocatedSize();

	/** Method which empty an ArrayList and reinitialize it again. */
	void clear();

	/**
	 * Method which add object to ArrayList.
	 * 
	 * @param index
	 *            index at which object to be add.
	 * @param object
	 *            object that is to be added.
	 */
	void add(int index, Object object);

	/**
	 * Method to get object from specified index.
	 * 
	 * @param index
	 *            from which object to get.
	 * @return object at specified index.
	 */
	Object get(int index);

	/**
	 * Method to get number of element from ArrayList.
	 * 
	 * @return Number of element in ArrayList.
	 */
	int size();

	/** trim the ArrayList. */
	void trimToSize();

	/**
	 * Get index of specified object.
	 * 
	 * @param object
	 *            whose index needed.
	 * @return integer index of an object.
	 */
	int indexOf(Object object);

	/**
	 * Get last index of an object.
	 * 
	 * @param object
	 *            whose last index needed.
	 * @return integer last occurring index of object.
	 */
	int lastIndexOf(Object object);

	/**
	 * Add object to ArrayList.
	 * 
	 * @param object
	 *            to be added to the list.
	 * @return either true or false.
	 */
	boolean add(Object object);

	/**
	 * Check whether object is present in the ArrayList or not.
	 * 
	 * @param object
	 *            to be checked.
	 * @return either true or false.
	 * @throws EmptyArrayListException
	 *             Array is not Initialized.
	 */
	boolean contains(Object object) throws EmptyArrayListException;

	/**
	 * Method to check ArrayList empty or not.
	 * 
	 * @return either true or false.
	 */
	boolean isEmpty();

	/**
	 * Method to remove object.
	 * 
	 * @param object
	 *            to be removed.
	 * @return either true or false.
	 */
	boolean remove(Object object);

	/**
	 * Method to remove object from specified index.
	 * 
	 * @param index
	 *            from which object to be removed.
	 * @return object that is to be removed.
	 */
	Object remove(int index);

	/**
	 * Method to set object at specified index. same as add(integer, object).
	 * 
	 * @param index
	 *            at which object to set.
	 * @param object
	 *            to set.
	 * @return object that has been set.
	 */
	Object set(int index, Object object);

}
