package com.axpe.od.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.axpe.od.model.Agenda;

public interface AgendaService {
	
	Agenda getById(Integer idAgenda) throws NotFoundException;
	
	List<Agenda> findAgendaByUsername(String username);
	
	void saveAgenda(Agenda agenda);
	
	void deletedAgenda(Integer idAgenda);

}
