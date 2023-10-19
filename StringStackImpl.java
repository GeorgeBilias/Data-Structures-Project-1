

import java.io.PrintStream;

import java.util.NoSuchElementException;

public class StringStackImpl<T> implements StringStack<T> {
	
	private Node<T> top = null;
	private Node<T> bottom = null;
	private int counter;
	
	public StringStackImpl() {
		
	}

    /**
 * @return true if the stack is empty
 */
public boolean isEmpty() {
	return bottom == null;
}

/**
 * insert a String item to the stack
 */

public void push(T item) {
	Node<T> n = new Node<>(item);
	
	if(isEmpty()) {
		top = n;
		bottom = n;
	}else {
		n.setNext(top);
		top = n;
	}
	counter++;
}

/**
 * remove and return the item on the top of the stack
 * @return the item on the top of the stack
 * @throws a NoSuchElementException if the stack is empty
 */
    public T pop() throws NoSuchElementException {
	
	if(isEmpty()) {
		throw new NoSuchElementException();
	}
	
	T item = top.getData();
		
		if (bottom == top)
            top = bottom = null;
        else {
           
        top = top.getNext();
        	
        }
	counter--;
	
	return item;
}

    /**
 * return without removing the item on the top of the stack
 * @return the item on the top of the stack
 * @throws a NoSuchElementException if the stack is empty
 */
public T peek() throws NoSuchElementException {
	
	if(isEmpty()) {
		throw new NoSuchElementException();
	}
	
	T item = top.getData();
	
	return item;
}

/**
 * print the elements of the stack, starting from the item
     * on the top,
 * to the stream given as argument. For example, 
 * to print to the standard output you need to pass System.out as
 * an argument. E.g., 
 * printStack(System.out); 
 */
public void printStack(PrintStream stream) {
	
	Node<T> iterator = top;
	while(iterator != null) {
		System.out.println(iterator.getData());
		iterator = iterator.next;
	}
	
}

	/**
     * return the size of the stack, 0 if it is empty
 * @return the number of items currently in the stack
 */
public int size() {
	
	int s;
	
	if(isEmpty()) {
	 s = 0;
	}else {
	 s = counter;
	}
	
	return s;
}


}