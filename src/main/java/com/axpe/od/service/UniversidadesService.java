package com.axpe.od.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatUniversidadCf;


@Service
public interface UniversidadesService {
	public List<CatUniversidadCf> getAllUniversidades();
	public CatUniversidadCf save(CatUniversidadCf catTag);
	public CatUniversidadCf update(CatUniversidadCf catTag);
	public void deleteById(Integer id);
}
