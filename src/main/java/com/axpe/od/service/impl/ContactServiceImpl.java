package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.axpe.od.model.Contact;
import com.axpe.od.repository.GodHContactoRepository;
import com.axpe.od.service.ContactService;

public class ContactServiceImpl implements ContactService {

	@Autowired
	GodHContactoRepository godHContactoRepository;
	
	@Override
	public Contact getContact(Integer id) {
		return null;
	}

	@Override
	public List<Contact> getAllContactsOfProfessional(Integer professionalId) {
		return null;
	}

}
