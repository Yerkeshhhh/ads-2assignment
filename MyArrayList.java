import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyArrayList<E> implements MyList<E> {
    private Object[] holdElementsArray = new Object[7];

    private int size = 0;

    @Override
    public void add(E item) {
        if (size == holdElementsArray.length) {
            Object[] newArray = new Object[holdElementsArray.length * 2];
            System.arraycopy(holdElementsArray, 0, newArray, 0, 7);
            holdElementsArray = newArray;
        } else
            holdElementsArray[size++] = holdElementsArray;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= holdElementsArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) holdElementsArray[index];
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= holdElementsArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E item = (E) holdElementsArray[index];
        for (int i = index; i < size; i++) {
            holdElementsArray[i] = holdElementsArray[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public void add(E item, int index) {
        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException();
        }
        if (size==holdElementsArray.length) {
            Object[] newArray = new Object[holdElementsArray.length*2];
            System.arraycopy(holdElementsArray, 0, newArray, 0, size);
            holdElementsArray=newArray;
        }
        for (int i=size-1; i>index; i--) {
            holdElementsArray[i+1]=holdElementsArray[i];
        }
        holdElementsArray[index]=item;
        size++;
    }

    @Override
    public boolean remove(E item) {
        for (int i=0; i<size; i++) {
            if (holdElementsArray[i].equals(item)) {
                System.arraycopy(holdElementsArray, i+1, holdElementsArray, i, size-i);
                holdElementsArray[size-1]=null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        for (int i=0; i<size; i++) {
            if (holdElementsArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i=size-1; i>0; i--) {
            if (holdElementsArray[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i=0; i<=size; i++) {
            if (holdElementsArray[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i=0; i<=size; i++) {
            holdElementsArray[i]=null;
        }
    }

    @Override
    public void sort() {
        Arrays.sort(holdElementsArray, 0, 7);
    }

    @Override
    public E addAll() {
        int index=0;
        Object[] newArr = new Object[holdElementsArray.length];
        System.arraycopy(holdElementsArray, 0, newArr, 0, holdElementsArray.length);
        for (int i=0; i<newArr.length; i++) {
            System.out.println(newArr[i]);
        }
        return null;
    }

}

/*
Create a new class called MyArrayList that implements the MyList interface.
Define a private instance variable of type Object[] to hold the elements of the list.
Define an int variable called size to keep track of the number of elements in the list.
Implement the add(E element) method by first checking if the size of the array is large enough to accommodate the new element. If it is not, create a new array with double the size of the original array, copy over the elements from the original array, and then add the new element. Otherwise, simply add the new element to the end of the array and increment the size variable.
Implement the get(int index) method by returning the element at the specified index.
Implement the remove(int index) method by removing the element at the specified index, shifting all subsequent elements to the left by one position, and decrementing the size variable.
Implement the size() method by returning the size variable.
Implement any other methods specified by the List interface.
Test all methods of MyArrayList
 */