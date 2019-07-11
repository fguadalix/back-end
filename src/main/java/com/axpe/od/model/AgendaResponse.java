package com.axpe.od.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.axpe.od.model.Agenda;

public class AgendaResponse extends ResponseEntity<Agenda> {

	Error error;
	
	public AgendaResponse(HttpStatus status, Error error) {
		super(status);
		this.error = error;
	}

	
}
