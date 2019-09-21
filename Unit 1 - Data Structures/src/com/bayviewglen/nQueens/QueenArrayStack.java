package com.bayviewglen.nQueens;

public class QueenArrayStack implements Stack {
	private Queen[] data; 
	int manyItems; 
	
	public QueenArrayStack() {
		this.data = new Queen[100]; 
	}

	public void push(Queen el) {
		data[manyItems++] = (Queen) el; 
	}

	public Queen pop() {
		if (isEmpty()) throw new IllegalStateException("Bad! Very Very Bad!!!");
		return data[--manyItems]; 
		
	}
	
	public Queen peek() {
		if (isEmpty()) throw new IllegalStateException("Bad! Very Very Bad!!!");
		return data[manyItems-1];
	}

	public boolean isEmpty() {
		return (manyItems == 0); 
		
	}


}




