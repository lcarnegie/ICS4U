package com.bayviewglen.daytwo;

public class ContactNode {
	private Contact data; 
	private ContactNode link; 
	
	public ContactNode(Contact newContact, ContactNode link) {
		this.data = newContact; 
		this.link = link; 
	}

	public Contact getData() {
		return data;
	}

	public void setData(Contact data) {
		this.data = data;
	}

	public ContactNode getLink() {
		return link;
	}

	public void setLink(ContactNode link) {
		this.link = link;
	}

}

