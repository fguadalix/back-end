package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatSectorNegocio;
import com.axpe.od.dao.CatTag;
import com.axpe.od.repository.CatSectorNegocioRepository;
import com.axpe.od.service.UnidadesNegocioService;

@Service
public class UnidadesNegocioServiceImpl implements UnidadesNegocioService {

	@Autowired
	CatSectorNegocioRepository catSectorRepository;

	
		@Override
	public List<CatSectorNegocio> getAllUnidades() {
		return catSectorRepository.findAll();
	}

		@Override
		public CatSectorNegocio save(CatSectorNegocio catTag) {
			return catSectorRepository.save(catTag);
		}

		@Override
		public CatSectorNegocio update(CatSectorNegocio catTag) {
			return catSectorRepository.save(catTag);
			
		}

		@Override
		public void deleteById(Integer id) {
			catSectorRepository.deleteById(id);
		}
	
}
