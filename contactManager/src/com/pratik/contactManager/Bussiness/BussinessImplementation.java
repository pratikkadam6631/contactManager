package com.pratik.contactManager.Bussiness;

import java.util.Scanner;



import com.pratik.contactManager.Data.Data;
import com.pratik.contactManager.Data.DataImplementation;
import com.pratik.contactManager.Entity.contact;

public class BussinessImplementation implements Bussiness {
	
	
	Scanner scanner=new Scanner(System.in);
	
	private int id;

	private Data data = new DataImplementation();

	@Override
	public void addContact() {
		
		
		System.out.println("Enter first name");
		String firstName = scanner.next();
		System.out.println("Enter last name");
		String lastName = scanner.next();
		System.out.println("Enter mobile number");
		long mobile = scanner.nextLong();
		System.out.println("Enter work number");
		long work = scanner.nextLong();
		System.out.println("Enter email");
		String email = scanner.next();

		contact Contact = new contact(id(), firstName, lastName, mobile, work, email);

		data.addContact(Contact);

		contact[] contacts = data.findAllContacts();

		for (int i = 0; i < contacts.length; i++) {
			System.out.println(contacts[i]);
		}
		
	}

	
	private int id() {
		return ++id;
	}


	@Override
	public void deleteContact() {
		
		System.out.println("Enter contact id");
		int id = scanner.nextInt();
		data.deleteContact(id);

		contact[] contacts = data.findAllContacts();

		if (contacts.length > 0) {
			for (int i = 0; i < contacts.length; i++) {
				System.out.println(contacts[i]);
			}
		} else
			System.out.println("Contacts not found");
		
	}

	@Override
	public void updateContact() {
		
		System.out.println("Enter contact id");
		int id = scanner.nextInt();
		contact contact = data.findContactById(id);
		if (contact != null) {
			System.out.println("Enter first name");
			String firstName = scanner.next();
			System.out.println("Enter last name");
			String lastName = scanner.next();
			System.out.println("Enter mobile number");
			long mobile = scanner.nextLong();
			System.out.println("Enter work number");
			long work = scanner.nextLong();
			System.out.println("Enter email");
			String email = scanner.next();
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setMobile(mobile);
			contact.setWork(work);
			contact.setEmail(email);
			System.out.println("Contact updated");
			System.out.println(contact);
		} else
			System.out.println("Contact not found");
	
		
	}

	@Override
	public void findContactByFirstName() {
		
		System.out.println("Enter first name");
		String firstName = scanner.next();
		contact[] contacts = data.findAllContacts();
		if (contacts.length > 0) {
			boolean flag = false;
			for (int i = 0; i < contacts.length; i++) {
				if (contacts[i].getFirstName().equals(firstName)) {
					flag = true;
					System.out.println(contacts[i]);
				}
			}
			if (!flag)
				System.out.println("No Contact found");
		} else
			System.out.println("Contacts not found");

	
		
	}

	@Override
	public void findContactByLastName() {
		
		System.out.println("Enter last name");
		String lastName = scanner.next();
		contact[] contacts = data.findAllContacts();
		if (contacts.length > 0) {
			boolean flag = false;
			for (int i = 0; i < contacts.length; i++) {
				if (contacts[i].getLastName().equals(lastName)) {
					flag = true;
					System.out.println(contacts[i]);
				}
			}
			if (!flag)
				System.out.println("No contact found");
		} else
			System.out.println("Contacts not found");
	
		
	}

	@Override
	public void findAllContacts() {
		
		contact[] contacts = data.findAllContacts();
		if (contacts.length > 0) {
			for (int i = 0; i < contacts.length; i++) {
				System.out.println(contacts[i]);
			}
		} else
			System.out.println("Contacts not found");

		
	}

	@Override
	public void search() {
		
		System.out.println("Enter pattern");
		String pattern = scanner.next();
		contact[] contacts = data.findAllContacts();
		if (contacts.length > 0) {
			boolean flag = false;
			for (int i = 0; i < contacts.length; i++) {
				contact contact = contacts[i];
				if (contact.getFirstName().contains(pattern) || contact.getLastName().contains(pattern)
						|| contact.getEmail().contains(pattern) || String.valueOf(contact.getMobile()).contains(pattern)
						|| String.valueOf(contact.getWork()).contains(pattern)) {
					flag = true;
					System.out.println(contact);
				}
			}
			if(!flag) {
				System.out.println("No contact found");
			}
		} else
			System.out.println("Contacts not found");
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
