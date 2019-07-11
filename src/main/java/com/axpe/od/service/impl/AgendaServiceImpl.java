package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodAgenda;
import com.axpe.od.mapper.MapperAgenda;
import com.axpe.od.model.Agenda;
import com.axpe.od.repository.GodAgendaRepository;
import com.axpe.od.service.AgendaService;

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	GodAgendaRepository godAgendaRepository;
	@Autowired
	MapperAgenda mapperAgenda;
	
	@Override
	public List<Agenda> findAgendaByUsername(String username) {
		
		List<GodAgenda> agendaUserList = godAgendaRepository.findAgendaByUsername(username);
	
		return mapperAgenda.godAgendaListToAgendaList(agendaUserList);
	}

	@Override
	public void saveAgenda(Agenda agenda) {
		
		godAgendaRepository.save(mapperAgenda.agendaToGodAgenda(agenda));
		
	}

	@Override
	public void deletedAgenda(Integer idAgenda) {
		
		godAgendaRepository.deleteById(idAgenda);
		
	}

	@Override
	public Agenda getById(Integer idAgenda){
		GodAgenda respuesta;
		respuesta = godAgendaRepository.getOne(idAgenda);
		return mapperAgenda.godAgendaToAgenda(respuesta);
	}

}
