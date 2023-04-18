

/*
Create a new class called MyLinkedList that implements the List interface.
Define a private inner class called Node that contains an element of type E and references to the next and previous nodes in the list.
Define a private instance variable called head that references the first node in the list.
Define a private instance variable called tail that references the last node in the list.
Define an int variable called size to keep track of the number of elements in the list.
Implement the add(E element) method by creating a new Node with the specified element, setting its next reference to null (since it will be the new tail), and its previous reference to the current tail. If the list is empty, set both the head and tail references to the new node. Otherwise, set the next reference of the current tail to the new node and update the tail reference to the new node. Finally, increment the size variable.
Implement the get(int index) method by traversing the list from the head (or tail, depending on which is closer to the specified index) and returning the element at the specified index.
Implement the remove(int index) method by first traversing the list to the node at the specified index. Then, update the next and previous references of the surrounding nodes to remove the node from the list, and decrement the size variable.
Implement the size() method by returning the size variable.
Implement any other methods specified by the List interface.
Test all methods of MyLinkedList
 */

public class MyLinkedList<E> implements MyList<E> {

    private class Node {
        E element;
        Node next;
        Node previous;

        Node(E element, Node next, E previous) {
            this.element = element;
            this.next = next;
            this.previous = (Node) previous;
        }


    }

    private E head;
    private E tail;

    int size;

    private MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return true;
    }

    @Override
    public void add(E item) {
        Node newNode = new Node(item, null, tail);
        if (item == null) {
            head = (E) newNode;
        } else {
            tail = (E) newNode;
        }
        tail = (E) newNode;
        size++;
    }

    @Override
    public void add(E item, int index) {
        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException();
        }
        if (index==size) {
            add(item);
            return;
        }
        Node newNode = new Node(item, null, null);
        if (index==0) {
            newNode.next= (Node) head;
            ((Node) head).previous=newNode;
            head= (E) newNode;
        } else {
            Node node = getNode(index);
            newNode.next=node;
            newNode.previous=node.previous;
            node.previous.next=newNode;
            node.next=newNode;
        }
        size++;
    }

    @Override
    public boolean remove(E item) {
        Node node = (Node) head;
        while (node != null && !node.element.equals(item)) {
            node = node.next;
        }
        if (node==null) {
            return false;
        }
        if (node.previous == null) {
            head= (E) node.next;
        } else {
            node.previous.next=node.next;
        }
        if (node.next==null) {
            tail= (E) node.previous;
        } else {
            node.next.previous = node.previous;
        }
        size--;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        if (node.previous==null) {
            head= (E) node.next;
        } else {
            node.previous.next=node.next;
        }
        if (node.next==null) {
            tail= (E) node.previous;
        } else {
            node.next.previous=node.previous;
        }
        size--;
        return node.element;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).element;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node node = (Node) head; node != null; node = node.next) {
                if (node.element == null) {
                    return index;
                }
            }
            return -1;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        if (o==null) {
            for (int i=size-1; i>=0; i--) {
                if (getNode(i).element==null) {
                    lastIndex=i;
                    break;
                }
            }
        } else {
            for (int i=size-1; i>=0; i--) {
                if (o.equals(getNode(i).element)) {
                    lastIndex=i;
                    break;
                }
            }
        }
        return lastIndex;
    }

    private Node getNode(int index) {
        Node node;
        if (index < size / 2) {
            node = (Node) head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = (Node) tail;
            for (int i = size - 1; i > index; i--) {
                node = node.previous;
            }
        }
        return (Node) node;
    }
}


