package com.axpe.od.service;

import java.util.List;

import com.axpe.od.dao.CatSectorNegocio;
import com.axpe.od.dao.CatTag;



public interface UnidadesNegocioService {
	List<CatSectorNegocio> getAllUnidades();
	public CatSectorNegocio save(CatSectorNegocio catTag);
	public CatSectorNegocio update(CatSectorNegocio catTag);
	public void deleteById(Integer id);
}
