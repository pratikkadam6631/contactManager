package com.pratik.contactManager.Data;


import com.pratik.contactManager.Entity.contact;


public interface Data {

	void addContact(contact contact);

	void deleteContact(int id);
	
	contact findContactById(int id);

	contact[] findAllContacts();
}
