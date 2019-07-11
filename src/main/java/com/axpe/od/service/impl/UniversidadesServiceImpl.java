package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatUniversidadCf;
import com.axpe.od.repository.CatUniversidadesRepository;
import com.axpe.od.service.UniversidadesService;

@Service
public class UniversidadesServiceImpl implements UniversidadesService {

	@Autowired
	CatUniversidadesRepository catUniversidadesRepository;

	
		@Override
	public List<CatUniversidadCf> getAllUniversidades() {
		return catUniversidadesRepository.findAll();
	}
		@Override
		public CatUniversidadCf save(CatUniversidadCf catTag) {
			return catUniversidadesRepository.save(catTag);
		}

		@Override
		public CatUniversidadCf update(CatUniversidadCf catTag) {
			return catUniversidadesRepository.save(catTag);
			
		}

		@Override
		public void deleteById(Integer id) {
			catUniversidadesRepository.deleteById(id);
		}
		
	
}
