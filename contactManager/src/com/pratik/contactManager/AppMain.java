package com.pratik.contactManager;

import java.util.Scanner;

import com.pratik.contactManager.Bussiness.Bussiness;
import com.pratik.contactManager.Bussiness.BussinessImplementation;

public class AppMain {
	
	private static Bussiness bussiness = new BussinessImplementation();

	private static Scanner scanner = new Scanner(System.in);

	private static boolean run = true;

	public static void main(String[] args) {

		while (run) {
			System.out.println("Enter 1 to add contact");
			System.out.println("Enter 2 to delete contact");
			System.out.println("Enter 3 to update contact");
			System.out.println("Enter 4 to find contact by first name");
			System.out.println("Enter 5 to find contact by last name");
			System.out.println("Enter 6 to find all contacts");
			System.out.println("Enter 7 to search contact");
			System.out.println("Enter 8 to exit");
			System.out.println("Enter your choice");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				bussiness.addContact();
				break;
			case 2:
				bussiness.deleteContact();
				break;
			case 3:
				bussiness.updateContact();
				break;
			case 4:
				bussiness.findContactByFirstName();
				break;
			case 5:
				bussiness.findContactByLastName();
				break;
			case 6:
				bussiness.findAllContacts();
				break;
			case 7:
				bussiness.search();
				break;
			case 8:
				System.out.println("See you soon");
				run = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

	}

}
