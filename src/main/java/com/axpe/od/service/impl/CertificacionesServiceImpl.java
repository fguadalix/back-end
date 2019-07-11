package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatTag;
import com.axpe.od.dao.CatTitulacione;
import com.axpe.od.repository.CatTitulacioneRepository;
import com.axpe.od.service.CertificacionesService;

@Service
public class CertificacionesServiceImpl implements CertificacionesService {

	@Autowired
	CatTitulacioneRepository catTitulacionesRepository;

	
		@Override
	public List<CatTitulacione> getAllCertificaciones() {
		return catTitulacionesRepository.findAll();
	}
		@Override
		public CatTitulacione save(CatTitulacione catTag) {
			return catTitulacionesRepository.save(catTag);
		}

		@Override
		public CatTitulacione update(CatTitulacione catTag) {
			return catTitulacionesRepository.save(catTag);
			
		}

		@Override
		public void deleteById(Integer id) {
			catTitulacionesRepository.deleteById(id);
		}
	
}
