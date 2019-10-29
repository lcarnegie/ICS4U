package com.bayviewglen.queue;

public class IntArrayQueue implements Queue {
	private Integer[] data; 
	private int manyItems; 
	
	public IntArrayQueue() {
		this.data = new Integer[100]; 
		this.manyItems = 0; 
	}
	
	public void enqueue(Object el) {
		for(int i = manyItems - 1; i >= 0; i--) {
			data[i+1] = data[i]; 
		}
		data[0] = (Integer)el; 
		manyItems++; 
	}


	public Integer dequeue() {
	if (isEmpty()) throw new IllegalStateException("The Queue is empty!");
		return data[--manyItems]; 
	}

	
	public Object peek() {
		if (isEmpty()) throw new IllegalStateException("The Queue is empty!");
		return data[manyItems-1]; 
	}


	public void clear() {
		manyItems = 0; 

	}

	public boolean isEmpty() {
		return (manyItems == 0); 

	}

}
