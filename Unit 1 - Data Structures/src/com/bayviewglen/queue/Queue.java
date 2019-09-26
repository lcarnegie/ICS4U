package com.bayviewglen.queue;

public interface Queue {; 
	public void enqueue(Object el); 
	public Object dequeue(); 
	public Object peek(); 
	public void clear(); 
	public boolean isEmpty(); 
}
