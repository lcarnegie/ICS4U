package com.bayviewglen.daytwo;

import java.util.Scanner;

public class AddressBookV2 {// this address book uses a link list
	private ContactNode head;

	public void addContact() {
		Scanner in = new Scanner(System.in);
		System.out.print("What is their first name?: ");
		String firstName = in.nextLine();
		System.out.print("What is their last name?: ");
		String lastName = in.nextLine();
		System.out.print("What is their phone number?: ");
		String phoneNo = in.nextLine();
		Contact c = new Contact(firstName, lastName, phoneNo);
		head = new ContactNode(c, head);
		System.out.println("Contact Successfully Added.");

	}

	public Contact removeContact() {
		if (head == null) {
			System.out.println("You do not have any contacts. Type \"add\" to add some.");
			return null;
		} 
		Scanner in = new Scanner(System.in);
		String searchWord;
		System.out.print("Please enter the last name of the person you wish to find: ");
		searchWord = in.nextLine();
		if (head.getData().getLastName().toLowerCase().equals(searchWord)) {
			Contact c = head.getData();
			head = head.getLink();
			System.out.println("Their contact was removed");
			return c;
		} else {
			ContactNode previous = head;
			boolean isFound = false;

			while (!isFound) { // make a boolean, while not found works too.
				if (previous.getLink().getData().getLastName().toLowerCase().equals(searchWord)) {
					Contact c = previous.getData();
					previous.setLink(previous.getLink().getLink());
					System.out.println("Their contact was removed.");
					return c;
				} else {
					if (previous.getLink().getLink() == null) {// checks if next node has a null link
					} else {
						previous = previous.getLink();
					}
				}
			}
		}

		return null;
	}

	public void searchContact() {
		if (head == null) {
			System.out.println("Sorry, your address book is empty. Type \"add\" to add a contact.");
			return;
		}
		Scanner in = new Scanner(System.in);
		String searchWord;
		System.out.print("Please enter the last name of the person you wish to find: ");
		searchWord = in.nextLine();
		System.out.println();
		if (head.getData().getLastName().toLowerCase().equals(searchWord)) {
			display(head.getData());
			return;
		} else {
			ContactNode previous = head;
			boolean isFound = false;

			while (!isFound) { // make a boolean, while not found works too.
				if (previous.getLink() == null) {
					System.out.println(
							"Sorry, we could not find someone under the last name of " + "\"" + searchWord + "\"");
					return;
				} else if (previous.getLink().getData().getLastName().toLowerCase().equals(searchWord)) {
					display(previous.getData());
					return;
				} else {
					if (previous.getLink().getLink() == null) {// checks if next node after current has a null link
					} else {
						previous = previous.getLink();
					}
				}
			}
			System.out.println("Sorry, we could not find someone under the last name of " + "\"" + searchWord + "\"");
			return;
		}
	}

	public void display(Contact data) {
		System.out.println("First Name: " + data.getFirstName());
		System.out.println("Last Name: " + data.getLastName());
		System.out.println("Phone Number: " + data.getPhone());
	}

	public void displayAll() {
		if (head == null) {
			System.out.println("Sorry, your address book is empty. Type \"add\" to add a contact.");
			return;
		} 
		System.out.println("All Contacts:");
		System.out.println();
		boolean done = false;
		while (!done) {
				ContactNode current = head;
				int i = 1;
				while (current.getLink() != null) { // make a boolean, while not found works too.
					System.out.println("Contact #" + i + ":");
					display(current.getData());
					System.out.println();
					current = current.getLink();
					i++;
				}
				done = true; 
			}
		}
	}

