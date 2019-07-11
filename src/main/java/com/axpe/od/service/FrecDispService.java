package com.axpe.od.service;

import java.util.List;

import com.axpe.od.dao.GodDisponibilidad;


public interface FrecDispService {
	public List<GodDisponibilidad> getAllDisp();
	public GodDisponibilidad save(GodDisponibilidad catTag);
	public GodDisponibilidad update(GodDisponibilidad catTag);
	public void deleteById(Integer id);
}
