package com.axpe.od.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.axpe.od.dao.GodPeticiones;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.mapper.MapperPosition;
import com.axpe.od.model.Position;
import com.axpe.od.repository.PositionRepository;
import com.axpe.od.service.ServicePosition;

/***
 * CLASE CON LA LOGICA DE NEGOCIO ENDPOINT - Es llamada desde las clases
 * controlLER - consume las funciones jpaRepository - Mapea front - back
 *
 */

@Service
public class ServicePositionImpl implements ServicePosition {

	@Autowired
	MapperPosition mapperPosition;
	

	@Autowired
	PositionRepository positionRepository;
	
	
	@Override
	public Position getPositionByIdImpl(Long id) {

		int idPe= (int)(long) id; 
		GodPeticiones godPeticion = positionRepository.findById(idPe)
				// .map(p -> ResponseEntity.ok(new PositionResource(p))).
				.orElseThrow(() -> new EntityNotFoundException(String.format("Position with id %d not found", id)));

		Position position = mapperPosition.godPeticionesToPosition(godPeticion);
		return position;
		
		
	}
	
	public URI insertPosition(Position position) {

		GodPeticiones godPeticion = mapperPosition.positionToGodpeticiones(position);

		 //positionRepository.save(godPeticion);

		// URI uriResp = servicePositionImpl.postPosition(godPeticion) ;

		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
				.buildAndExpand(godPeticion.getCdpeticion()).toUri();

		return uri;
	}
	
	
	public List<Position> findByAll (){
		
		List<GodPeticiones> listGodPeticiones=  positionRepository.findByAllGodPeticiones();
		List<Position> listPostion = mapperPosition.listGodPeticionesToPosition(listGodPeticiones);
		
		 return listPostion;
	}

	

}