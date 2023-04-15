public class MyArrayList<E> implements MyList<E> {
    private Object[] holdElements = new Object[7];

    private int size=0;

    public void add(E element) {
        if (size==holdElements.length) {
            Object[] newArray = new Object[holdElements.length*2];
            System.arraycopy(holdElements, 0, newArray, 0, holdElements.length);
            holdElements = newArray;
        } else {
            holdElements[size++]=holdElements;
        }
    }



}

/*
Create a new class called MyArrayList that implements the List interface.
Define a private instance variable of type Object[] to hold the elements of the list.
Define an int variable called size to keep track of the number of elements in the list.
Implement the add(E element) method by first checking if the size of the array is large enough to accommodate the new element. If it is not, create a new array with double the size of the original array, copy over the elements from the original array, and then add the new element. Otherwise, simply add the new element to the end of the array and increment the size variable.
Implement the get(int index) method by returning the element at the specified index.
Implement the remove(int index) method by removing the element at the specified index, shifting all subsequent elements to the left by one position, and decrementing the size variable.
Implement the size() method by returning the size variable.
Implement any other methods specified by the List interface.
Test all methods of MyArrayList
 */