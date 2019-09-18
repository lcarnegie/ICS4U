package com.bayviewglen.stacks;

public class IntegerLinkListStack implements Stack{
	private intNode head; 

	public IntegerLinkListStack() {
		 head = null; 
	}
	public void push(Integer el) {
		head.setLink(new intNode(el, null)); 
		
	}

	public Integer pop() {
		if(isEmpty()) throw new IllegalStateException("No"); 
		Integer x = peek(); 
		head = head.getLink();
		return x; 
	}

	public Integer peek() {
		return head.getLink().getData(); 
	}

	public boolean isEmpty() {
		return (head == null); 
	}



class intNode {
	private int data; 
	private intNode link; 
	
	public intNode(int newInt, intNode link) {
		this.data = newInt; 
		this.link = link; 
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public intNode getLink() {
		return link;
	}

	public void setLink(intNode link) {
		this.link = link;
	}
}
}
