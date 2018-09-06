package com.mavendemo.impl;

import java.util.Arrays;
import org.apache.log4j.Logger;

import com.mavendemo.constant.MavenDemoConstant;
import com.mavendemo.exceptions.EmptyArrayListException;
import com.mavendemo.template.IMyArrayList;

/** This is the basic implementation of the ArrayList Class.
 * 
 * @author anand.tiwari */
public class MyArrayList implements IMyArrayList {

    private static Logger logger = Logger.getLogger(MyArrayList.class);
    private Object[] list;
    private int defaultLength = MavenDemoConstant.TEN;
    private int count = 0;

    /** Constructor. */
    MyArrayList() {
        this(MavenDemoConstant.TEN);
    }

    /** Parameterized constructor for initialization of ArrayList.
     * 
     * @param defaultLength2
     *            length from which ArrayList initialize. */
    MyArrayList(int defaultLength2) {
        if (defaultLength2 > 0) {
            list = new Object[defaultLength2];
        } else {
            list = new Object[1];
        }
    }

    /** This method will return the allocated size of the ArrayList.
     * 
     * @return defaultLength */
    public int getAllocatedSize() {
        return defaultLength;
    }

    /** Method to remove all item from list. */
    public void clear() {
        logger.info("Inside clear() of MyArrayList...");
        if (count != 0) {
            defaultLength = MavenDemoConstant.TEN;
            list = new Object[defaultLength];
            count = 0;
        }
    }

    /** This method add the object at specific index.
     * 
     * @param index
     *            at which object to add.
     * @param object
     *            to be add. */
    public void add(int index, Object object) {
        logger.info("Inside add(int, Object) of MyArrayList....");
        if (index == count) {
            list[index] = object;
            count++;
        } else if (index < count) {
            list[index] = object;
        } else {
            logger.error("Error At Index: " + index + ", " + MavenDemoConstant.SIZE + ": " + count);
            throw new ArrayIndexOutOfBoundsException(MavenDemoConstant.INDEX + ": " + index + ", " + MavenDemoConstant.SIZE + ": " + count);
        }

    }

    /** This method will return the object at specified index.
     * 
     * @param index
     *            whose object is needed.
     * @return object */
    public Object get(int index) {
        logger.info("Inside get(int) of MyArrayList...");
        if (count <= index) {
            throw new ArrayIndexOutOfBoundsException(MavenDemoConstant.INDEX + ": " + index + ", " + MavenDemoConstant.SIZE + ": " + count);
        } else {
            Object item = -1;
            for (int i = 0; i < count; i++) {
                if (i == index) {
                    item = list[i];
                    break;
                }
            }
            return item;
        }
    }

    /** method return length of the list.
     * 
     * @return length */
    public int size() {
        logger.info("Inside size() of MyArrayList....");
        return count;
    }

    /** This method will trim the initial capacity of the ArrayList Instance to the element present. */
    public void trimToSize() {
        logger.info("Inside trimToSize() of MyArrayList....");
        defaultLength = count;
        list = Arrays.copyOf(list, defaultLength);
    }

    /** method for finding index of an object in ArrayList.
     * 
     * @param object
     *            whose index is needed.
     * @return integer */
    public int indexOf(Object object) {
        logger.info("Inside indexOf(Object) of MyArrayList....");
        int index = -1;
        if (count == 0) {
            new EmptyArrayListException(MavenDemoConstant.SIZE + ": " + count);
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

    /** This method will return the last index of an object.
     * 
     * @param object
     *            whose last occurrence needed.
     * @return lastIndex */
    public int lastIndexOf(Object object) {
        logger.info("Inside lastIndexOf(Object) of MyArrayList....");
        int lastIndex = -1;
        if (count == 0) {
            new EmptyArrayListException(MavenDemoConstant.SIZE + ": " + count);
        } else {
            for (int i = 0; i < count; i++) {
                if (list[i] == object) {
                    lastIndex = i;
                }
            }
        }
        return lastIndex;
    }

    @Override
    public String toString() {
        logger.info("Inside @Override toString() of MyArrayList....");
        String stringList = getClass().getName() + "[";
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                stringList += " " + list[i];
            } else {
                stringList += " " + list[i] + ",";
            }
        }
        stringList += "]";
        return stringList;

    }

    /** @param object
     *            to be added to next index.
     * @return boolean */
    public boolean add(Object object) {
        logger.info("Inside add(Object) of MyArrayList....");

        if (count >= defaultLength) {
            defaultLength = defaultLength + (int) defaultLength / 2;
            list = Arrays.copyOf(list, defaultLength);
        }
        list[count] = object;
        count++;
        return true;
    }

    /** @param object
     *            to be checked in ArrayList.
     * @return boolean
     * @throws EmptyArrayListException
     *             Array not Initialized. */
    public boolean contains(Object object) throws EmptyArrayListException {
        logger.info("Inside contains(Object) of MyArrayList....");
        int index = -1;
        if (count == 0) {
            throw new EmptyArrayListException("Size: " + count);
        } else {
            for (int i = 0; i < count; i++) {
                if (list[i] == object) {
                    index = i;
                    break;
                }
            }

        }

        return (index != -1);
    }

    /** @return boolean */
    public boolean isEmpty() {
        return (count == 0);
    }

    /** @param object
     *            to be removed.
     * @return boolean */
    public boolean remove(Object object) {
        logger.info("Inside remove(Object) of MyArrayList....");
        int index = -1;
        if (count == 0) {
            new EmptyArrayListException("Size: " + count);
        } else {
            for (int i = 0; i < count; i++) {
                if (list[i] == object) {
                    index = i;
                    remove(index);
                }
            }

        }

        return (index != -1);
    }

    /** @param index
     *            from which object to be removed.
     * @return boolean */
    public Object remove(int index) {
        logger.info("Inside remove(int) of MyArrayList....");
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

    /** @param index
     *            on which object to be add.
     * @param object
     *            to be add.
     * @return Object */
    public Object set(int index, Object object) {
        logger.info("Inside set(int, Object) of MyArrayList....");
        if (index == count) {
            list[index] = object;
            count++;
        } else if (index < count) {
            list[index] = object;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        return get(index);
    }

}
