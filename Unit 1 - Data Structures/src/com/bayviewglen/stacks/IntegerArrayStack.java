package com.bayviewglen.stacks;

public class IntegerArrayStack implements Stack {
	private Integer[] data; 
	int manyItems; 
	
	public IntegerArrayStack() {
		this.data = new Integer[100]; 
	}

	public void push(Integer el) {
		data[manyItems++] = el; 
	}

	public Integer pop() {
		if (isEmpty()) throw new IllegalStateException("Bad! Very Very Bad!!!");
		return data[--manyItems]; 
		
	}
	
	public Integer peek() {
		if (isEmpty()) throw new IllegalStateException("Bad! Very Very Bad!!!");
		return data[manyItems-1];
	}

	public boolean isEmpty() {
		return (manyItems == 0); 
		
	}

}




