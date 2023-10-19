

public class main {
	
	public static void main(String[] args) {
		IntQueueImpl<Integer> queue = new IntQueueImpl<Integer>();
		
		queue.put(1);
		queue.put(2);
		queue.put(3);
		queue.put(4);
		queue.put(5);
	    
		queue.printQueue(System.out);// 1 2 3 4 5
		System.out.println(queue.size()); // 5 
	    System.out.println(queue.peek()); // 1
	    queue.printQueue(System.out); // 1 2 3 4 5
	    System.out.println(queue.size()); // 5
	    System.out.println(queue.get()); // 1
	    System.out.println(queue.size()); // 4 
	    queue.printQueue(System.out); // 2 3 4 5
	    
StringStack<String> stack = new StringStackImpl<String>();
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
	    
		stack.printStack(System.out);// 5 4 3 2 1
		System.out.println(stack.size());// 5
	    System.out.println(stack.peek()); // 5
	    stack.printStack(System.out); // 5 4 3 2 1
	    System.out.println(stack.size()); // 5
	    System.out.println(stack.pop()); // 5
	    System.out.println(stack.size()); // 4
	    stack.printStack(System.out);// 4 3 2 1
	}
}