package com.bayviewglen.queue;

public class QueueTester {

	public static void main(String[] args) {
		Queue test = new IntArrayQueue(); 
		test.enqueue(1);  
		test.enqueue(5);  
		test.enqueue (7);
		test.dequeue(); 
		test.peek(); 
		test.clear();
		test.enqueue(10);

		Queue testTwo = new IntegerLinkedListQueue(); 
		testTwo.enqueue(1);  
		testTwo.enqueue(5);  
		testTwo.enqueue (7);
		testTwo.dequeue(); 
		testTwo.peek(); 
		testTwo.clear();
		testTwo.isEmpty(); 
		testTwo.enqueue(10);
	}

}
