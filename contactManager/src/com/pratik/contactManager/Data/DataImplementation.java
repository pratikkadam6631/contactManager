package com.pratik.contactManager.Data;

import com.pratik.contactManager.Entity.contact;

public  class DataImplementation implements Data {
	
	private contact[] contacts = new contact[10];

	private int capacity = contacts.length;

	private int index = 0;

	@Override
	public void addContact(contact contact) {
		if (exists(contact)) {
			System.out.println("Contact already exists");
		} else {
			if (index == (capacity - 1)) {
				contact[] temp = new contact[2 * capacity];
				for (int i = 0; i < index; i++) {
					temp[i] = contacts[i];
				}
				contacts = temp;
				capacity = contacts.length;
			}
			contacts[index] = contact;
			index++;
			System.out.println("Contact added");
		}
	}

	@Override
	public void deleteContact(int id) {
		boolean flag = false;
		for (int i = 0; i < index; i++) {
			if (contacts[i].getId() == id) {
				flag = true;
				contacts[i] = null;
				normalize(i);
				break;
			}
		}
		if (flag) {
			System.out.println("Contact deleted");
		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public contact[] findAllContacts() {
		contact[] temp = new contact[index];
		for (int i = 0; i < index; i++) {
			temp[i] = contacts[i];
		}
		return temp;
	}

	private void normalize(int i) {
		if (i == index - 1) {
			index--;
		} else {
			for (int j = i; j < index - 1; j++) {
				contacts[j] = contacts[j + 1];
			}
			index--;
		}
	}

	@Override
	public contact findContactById(int id) {
		contact contact = null;
		for (int i = 0; i < index; i++) {
			if (contacts[i].getId() == id) {
				contact = contacts[i];
				break;
			}
		}
		return contact;
	}

	private boolean exists(contact contact) {
		boolean present = false;
		for (int i = 0; i < index; i++) {
			if (contacts[i].getMobile() == contact.getMobile() 
					|| contacts[i].getWork() == contact.getWork()
					|| contacts[i].getEmail().equals(contact.getEmail())) {
				present = true;
				break;
			}
		}
		return present;
	}

}
