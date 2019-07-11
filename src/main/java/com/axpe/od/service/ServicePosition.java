package com.axpe.od.service;

import java.net.URI;

import org.springframework.stereotype.Service;

import com.axpe.od.model.Position;

@Service
public interface ServicePosition {

	
	public Position getPositionByIdImpl (Long id);
	
	//public URI postPosition (Position position);
}