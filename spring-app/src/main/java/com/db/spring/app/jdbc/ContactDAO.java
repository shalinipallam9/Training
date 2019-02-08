package com.db.spring.app.jdbc;

import java.util.List;

import com.db.spring.app.model.Contact;

public interface ContactDAO {

	public void saveOrUpdate(Contact contact);

	public void delete(int contactId);

	public Contact get(int contactId);

	public List<Contact> list();

}
