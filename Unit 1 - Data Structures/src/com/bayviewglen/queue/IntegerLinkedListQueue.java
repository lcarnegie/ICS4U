package com.bayviewglen.queue;

public class IntegerLinkedListQueue implements Queue{
	IntegerNode head; 
	IntegerNode tail; 
	
	public IntegerLinkedListQueue() {
		head = new IntegerNode(null, null); 
		tail = new IntegerNode(null, head); 
		head.setLink(tail);
	}
	
	public void enqueue(Object el) {
		if(tail.getLink().equals(head)) {
			tail.setLink(new IntegerNode((Integer) el, head));
			head.setLink(tail.getLink());
		}else {
			tail.setLink(new IntegerNode((Integer) el, tail.getLink()));
			tail.getLink().getLink().setLink(tail.getLink());
		}
		
	}

	public Object dequeue() {
		if(isEmpty()) {
			throw new IllegalStateException("Your Queue is empty :("); 
		}
		Object ret = head.getLink().getData(); 
		head.setLink(head.getLink().getLink());
		return ret; 
	}


	public Object peek() {
		if(isEmpty()) {
			throw new IllegalStateException("Your Queue is empty :("); 
		}
		return head.getLink().getData(); 
	}

	public void clear() {
		head.setLink(tail); 
		tail.setLink(head);
		
	}

	public boolean isEmpty() {
		return (head.getLink().equals(tail) && tail.getLink().equals(head));
	}
	
}
