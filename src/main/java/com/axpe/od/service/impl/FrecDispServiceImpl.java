package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodDisponibilidad;
import com.axpe.od.repository.GodDisponibilidadRepository;
import com.axpe.od.service.FrecDispService;

@Service
public class FrecDispServiceImpl implements FrecDispService {

	@Autowired
	GodDisponibilidadRepository disponibilidadesRepository;

	
		@Override
	public List<GodDisponibilidad> getAllDisp() {
		return disponibilidadesRepository.findAll();
	}

		@Override
		public GodDisponibilidad save(GodDisponibilidad GodDisponibilidad) {
			return disponibilidadesRepository.save(GodDisponibilidad);
		}

		@Override
		public GodDisponibilidad update(GodDisponibilidad GodDisponibilidad) {
			return disponibilidadesRepository.save(GodDisponibilidad);
			
		}

		@Override
		public void deleteById(Integer id) {
			disponibilidadesRepository.deleteById(id);
		}
		
	
}
