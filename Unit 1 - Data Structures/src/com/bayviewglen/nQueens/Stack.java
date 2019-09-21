package com.bayviewglen.nQueens;

public interface Stack {
	
 public void push(Queen el); 
 public Queen pop();
 public Queen peek();
 public boolean isEmpty();
}
