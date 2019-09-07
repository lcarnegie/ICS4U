package com.bayviewglen.dayone;

import java.util.Scanner;

public class AddressBookDriver {

	public static void main(String[] args) {
		AddressBook contacts = new AddressBook();
		String[] commandWords = { "add", "delete", "displayall", "search", "help" };
		Scanner in = new Scanner(System.in);
		boolean isDone = false;
		System.out.println("Welcome to Addressbook+");
		while (!isDone) { // main command loop
			System.out.println("What would you like to do?");
			System.out.print(">");
			String command = in.next().toLowerCase();
			switch (command) {
			case "add":
				command = null;
				contacts.addContact();
				System.out.println();
				break;
			case "delete":
				command = null;
				contacts.deleteContact();
				System.out.println();
				break;
			case "search":
				command = null;
				contacts.searchAndDisplay();
				System.out.println();
				break;
			case "displayall":
				command = null;
				contacts.displayAll();
				System.out.println();
				break;
			case "help":
				command = null;
				System.out.println("Here's what you can do:");
				for (int i = 0; i < commandWords.length - 1; i++) {
					System.out.print(commandWords[i] + ", ");
				}
				System.out.println(commandWords[commandWords.length - 1]);
				System.out.println();
			}
		}
	}

}
