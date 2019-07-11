package com.axpe.od.controller;

import com.axpe.od.model.AgendaResponse;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.Agenda;
import com.axpe.od.service.impl.AgendaServiceImpl;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class AgendaController {

	@Autowired
	private AgendaServiceImpl agendaServiceImpl;	

	@GetMapping(value = "agenda/{username}")
	public List<Agenda> getAllAgenda(@PathVariable String username) throws EntityNotFoundException {

		return agendaServiceImpl.findAgendaByUsername(username);
	}

	@PostMapping("agenda")
	public ResponseEntity<Agenda> addAgenda(@RequestBody Agenda agenda) {

		agendaServiceImpl.saveAgenda(agenda);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
				.buildAndExpand(agenda.getAgendaId()).toUri();
		return ResponseEntity.created(uri).body(agenda);
	}
	
	@DeleteMapping("agenda/{id}")
	public AgendaResponse deleteAgenda(@PathVariable Integer id) {

		if(agendaServiceImpl.getById(id) != null) {
			agendaServiceImpl.deletedAgenda(id);
			return new AgendaResponse(HttpStatus.OK, null);
		} else {
			return new AgendaResponse(HttpStatus.NOT_FOUND, new Error(String.format("Agenda with id %d not found", id)));
		}
	}


	@PutMapping("agenda/{id}")
	public ResponseEntity<Agenda> editAgenda(@RequestBody Agenda agenda, @PathVariable Integer id) {

		if (agendaServiceImpl.getById(id) != null) {
			agenda.setAgendaId(id);
			agendaServiceImpl.saveAgenda(agenda);
			final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
					.buildAndExpand(agenda.getAgendaId()).toUri();
			return ResponseEntity.created(uri).body(agenda);
		} else {
			throw new EntityNotFoundException(String.format("Agenda with id %d not found", id));
		}
	}
}
