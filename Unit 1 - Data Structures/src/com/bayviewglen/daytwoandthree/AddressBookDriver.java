package com.bayviewglen.daytwoandthree;

import java.util.Scanner;

public class AddressBookDriver {

	public static void main(String[] args) {
		AddressBookV2 contacts = new AddressBookV2();
		String[] commandWords = {"add", "delete", "display all", "search", "help", "exit" };
		Scanner in = new Scanner(System.in);
		boolean isDone = false;
		System.out.println("Welcome to Addressbook+");
		while (!isDone) { // main command loop
			System.out.println("What would you like to do? Type 'help' if you need help.");
			System.out.print(">");
			String command = in.next().toLowerCase();
			switch (command) {
			case "add":
				in.nextLine(); 
				contacts.addContact();
				System.out.println();
				break;
			case "delete":
				in.nextLine(); 
				command = null;
				contacts.removeContact();
				System.out.println();
				break;
			case "search":
				in.nextLine(); 
				command = null;
				contacts.searchContact();
				System.out.println();
				break;
			case "display":
				in.nextLine(); 
				contacts.displayAll();
				System.out.println();
				break;
			case "help":
				in.nextLine(); 
				System.out.println("Here's what you can do:");
				for (int i = 0; i < commandWords.length - 1; i++) {
					System.out.print(commandWords[i] + ", ");
				}
				System.out.println(commandWords[commandWords.length - 1]);
				System.out.println();
				break; 
			case "exit":
				isDone = true; 
				System.out.println("Thank you, goodbye!");
			}
		}
	}

}

