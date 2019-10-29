package com.bayviewglen.testreview;


public class IntNode {
	private Integer data; 
	private IntNode linkForward; 
	private IntNode linkBackward; 
	
	public IntNode(Integer n, IntNode linkForward,IntNode linkBackward) {
		this.data = n; 
		this.linkForward = linkForward; 
		this.linkBackward = linkBackward; 
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public IntNode getLinkForward() {
		return linkForward;
	}

	public void setLinkForward(IntNode linkForward) {
		this.linkForward = linkForward;
	}

	public IntNode getLinkBackward() {
		return linkBackward;
	}

	public void setLinkBackward(IntNode linkBackward) {
		this.linkBackward = linkBackward;
	}


}
