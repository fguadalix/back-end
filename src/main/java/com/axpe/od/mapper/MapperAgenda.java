package com.axpe.od.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodAgenda;
import com.axpe.od.model.Agenda;

@Service
public class MapperAgenda {

	public Agenda godAgendaToAgenda(GodAgenda godAgenda) {

		Agenda resultado = new Agenda();

		resultado.setAgendaId(godAgenda.getAgendaid());
		resultado.setMarked(godAgenda.isMarked());
		resultado.setText(godAgenda.getText());
		resultado.setUsername(godAgenda.getUsername());

		return resultado;
	}

	public GodAgenda agendaToGodAgenda(Agenda agenda) {

		GodAgenda resultado = new GodAgenda(agenda.getText(),agenda.isMarked(),agenda.getUsername());
		resultado.setAgendaid(agenda.getAgendaId());
		
		return resultado;
	}

	public List<Agenda> godAgendaListToAgendaList(List<GodAgenda> godAgendaList) {

		List<Agenda> agendaList = new ArrayList<Agenda>();

		for (GodAgenda godAgenda : godAgendaList) {
			agendaList.add(godAgendaToAgenda(godAgenda));
		}
		return agendaList;
	}

}
