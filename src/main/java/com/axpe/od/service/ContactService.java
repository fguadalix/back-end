package com.axpe.od.service;

import java.util.List;

import com.axpe.od.model.Contact;

public interface ContactService {
	
	public Contact getContact(Integer id);
	
	public List<Contact> getAllContactsOfProfessional(Integer professionalId);

}
