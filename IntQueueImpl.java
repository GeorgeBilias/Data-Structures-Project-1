

import java.io.PrintStream;

import java.util.NoSuchElementException;

public class IntQueueImpl<T> implements IntQueue<T> {
	
	private Node<T> front = null;
	private Node<T> back = null;
	private int counter;
	
	public IntQueueImpl() {
		
	}
	/**
	 * @return true if the queue is empty
	 */
	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * insert an integer to the queue
	 */
	public void put(T item) {
		Node<T> n = new Node<>(item);
		
		if(isEmpty()) {
			front = n;
			back = n;
		}else {
			back.setNext(n);
			back = n;
		}
		counter++;
	}

	/**
 	 * remove and return the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T get() throws NoSuchElementException{
		
		if(isEmpty()) {
			throw new NoSuchElementException();
		}	
			T item = front.getData();
		
			if(front == back) {
				front = back = null;
			}else {
				front = front.getNext();
			}
			counter--;
		
		return item;
	}

	/**
	 * return without removing the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T peek() throws NoSuchElementException{
		
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		T item = front.getData();
		
		return item;
	}


	/**
	 * print the elements of the queue, starting from the oldest 
         * item, to the print stream given as argument. For example, to 
         * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	public void printQueue(PrintStream stream) {
		
		Node<T> iterator = front;
		while(iterator != null ) {
			System.out.println(iterator.getData());
	        iterator = iterator.next;
		}
		
	}

	/**
	 * return the size of the queue, 0 if it is empty
	 * @return number of elements in the queue
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