package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatTitulacione;
import com.axpe.od.repository.CatTitulacioneRepository;
import com.axpe.od.service.TitulacionesService;

/***
 * CLASE CON LA LOGICA DE NEGOCIO ENDPOINT - Es llamada desde las clases
 * controlLER - consume las funciones jpaRepository - Mapea front - back
 *
 */

@Service
public class TitulacionesServiceImpl implements TitulacionesService {

	

	@Autowired
	CatTitulacioneRepository titualacionRepository;

	@Override
	public List<CatTitulacione> getAllById(Integer ids) {
		return titualacionRepository.findAll();
	}

	@Override
	public CatTitulacione save(CatTitulacione specialization) {
		return titualacionRepository.save(specialization);
	}

	@Override
	public CatTitulacione update(CatTitulacione specialization) {
		return titualacionRepository.save(specialization);
		
	}

	@Override
	public void deleteById(Integer id) {
		titualacionRepository.deleteById(id);
	}

}
