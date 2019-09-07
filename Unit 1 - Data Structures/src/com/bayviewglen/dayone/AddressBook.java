package com.bayviewglen.dayone;

import java.util.Scanner;

public class AddressBook {
	Contact[] contactList;

	public AddressBook() {
		this.contactList = new Contact[5]; // initializes Address book with 5 contacts
	}

	public void addContact() {
		Scanner in = new Scanner(System.in);
		System.out.print("What is their first name?: ");
		String firstName = in.next();
		System.out.print("What is their last name?: ");
		String lastName = in.next();
		System.out.print("What is their phone number?: ");
		String phoneNo = in.next();
		Contact newContact = new Contact(firstName, lastName, phoneNo);
		for (int i = 0; i < contactList.length; i++) {
			if (contactList[i] == null) {
				contactList[i] = newContact;
				return;
			}
		}
		Contact[] biggerList = new Contact[contactList.length + 5];
		int j;
		for (j = 0; j < contactList.length; j++) {
			biggerList[j] = contactList[j];
		}
		biggerList[j + 1] = newContact;
		contactList = biggerList;
	}

	public void addContact(String firstName, String lastName, String phoneNo) {
		Contact newContact = new Contact(firstName, lastName, phoneNo);
		for (int i = 0; i < contactList.length; i++) {
			if (contactList[i] == null) {
				contactList[i] = newContact;
				System.out.println("Contact added.\n");
				return;
			}
		}
		Contact[] biggerList = new Contact[contactList.length + 5];
		int j;
		for (j = 0; j < contactList.length; j++) {
			biggerList[j] = contactList[j];
		}
		biggerList[j + 1] = newContact;
		contactList = biggerList;
		System.out.println("Contact added.");
	}

	public void deleteContact() {
		Scanner in = new Scanner(System.in);
		int contactIndex = searchContact();
		if (contactIndex >= 0) {
			Contact toDelete = contactList[contactIndex];
			String first = toDelete.getFirstName();
			String last = toDelete.getLastName();
			System.out.print("Are you sure you want to delete " + first + " " + last + "'s contact? Enter Y or N: ");
			String response = in.next();
			boolean isValidResponse = false;
			while (!isValidResponse) {
				if (response.toLowerCase().equals("y")) {
					isValidResponse = true;
					contactList[contactIndex] = null;
					for (int i = contactList.length - 2; i >= contactIndex; i--) {
						contactList[i] = contactList[i + 1];
					}
					System.out.println("Their contact was deleted.");
					return;
				} else if (response.toLowerCase().equals("n")) {
					isValidResponse = true;
					System.out.println("Their contact was saved.");
					return;
				} else {
					System.out.println("Sorry, but that isn't a valid response. Type Y or N: ");
					response = in.next();
				}
			}
		}

	}

	public void searchAndDisplay() {
		displayContact(searchContact());
	}

	public int searchContact() {
		Scanner in = new Scanner(System.in);
		String searchWord;

		System.out.print("Please enter the last name of the person you wish to find: ");
		searchWord = in.next();
		for (int i = 0; i < contactList.length; i++) {
			if (contactList[i] != null && contactList[i].getLastName().toLowerCase().equals(searchWord)) {
				return i;
			}
		}
		System.out.println("Sorry, we could not find someone under the last name of " + "\"" + searchWord + "\"");
		return -1;
	}

	public void displayContact(int contactNumber) {
		if (contactNumber >= 0) {
			String first = contactList[contactNumber].getFirstName();
			String last = contactList[contactNumber].getLastName();
			String phone = contactList[contactNumber].getPhone();

			System.out.println("\nFirst Name: " + first);
			System.out.println("Last Name: " + last);
			System.out.println("Phone Number: " + phone);
			System.out.println();
		} else {
		}
	}

	public void displayAll() {
		System.out.println("All Contacts:\n");
		int i, j;
		for (i = 0, j = 0; i < contactList.length; i++) {
			if (contactList[i] != null) {
				displayContact(i);
			} else {
				j++;
			}
		}
		if (j == contactList.length) {
			System.out.println("You don't seem to have any contacts. Type \"Add\" to add some ");
		}
	}

}
