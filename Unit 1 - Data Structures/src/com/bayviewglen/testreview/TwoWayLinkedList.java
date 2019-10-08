package com.bayviewglen.testreview;

public class TwoWayLinkedList {
	IntNode head; 
	IntNode tail; 
	
	public TwoWayLinkedList() {
		this.head = new IntNode(null, null, null); 
		this.tail = new IntNode(null, head, null);
		head.setLinkBackward(tail);
	}
	
	public void add(Integer n) {
			if(head.getLinkBackward().equals(tail) && tail.getLinkForward().equals(head)) {
				tail.setLinkForward(new IntNode(n, tail.getLinkForward(), tail));
				head.setLinkBackward(tail.getLinkForward());
			}
			tail.setLinkForward(new IntNode(n, tail.getLinkForward(), tail));
		}
}

