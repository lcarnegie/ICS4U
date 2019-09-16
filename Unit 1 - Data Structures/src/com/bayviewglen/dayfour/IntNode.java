package com.bayviewglen.dayfour;

public class IntNode {
	private int data; 
	private IntNode link; 
	
	public IntNode(int newInt, IntNode link) {
		this.data = newInt; 
		this.link = link; 
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public IntNode getLink() {
		return link;
	}

	public void setLink(IntNode link) {
		this.link = link;
	}

}

