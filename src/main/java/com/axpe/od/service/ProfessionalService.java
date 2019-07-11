package com.axpe.od.service;

import java.util.List;

import com.axpe.od.model.Contact;
import com.axpe.od.model.Professional;

public interface ProfessionalService {
	
	List<Professional> findAll();
	
	Professional getProfessional(Integer id);
	
	List<Contact> getContactsOfProfessional(Integer id);
	
	void saveProfessional(Professional professional);
	
	void deletProfessional(Integer id);

}
