package com.bayviewglen.nQueens;
public class QueenArrayStack implements Stack {
	private Queen[] data; 
	private int manyItems; 
	
	public QueenArrayStack() {
		this.data = new Queen[100]; 
	}
	
	public QueenArrayStack(int n) {
		this.data = new Queen[n]; 
	}

	public void push(Queen el) {
		data[manyItems] = (Queen) el; 
		manyItems++; 
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
	
	public int length() {
		return data.length; 
	}


}




