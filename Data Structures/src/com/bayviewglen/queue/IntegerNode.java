package com.bayviewglen.queue;

public class IntegerNode {
	private Integer data; 
	private IntegerNode link; 
	
	public IntegerNode(Integer newInt, IntegerNode link) {
		this.data = newInt; 
		this.link = link; 
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public IntegerNode getLink() {
		return link;
	}

	public void setLink(IntegerNode link) {
		this.link = link;
	}

}
