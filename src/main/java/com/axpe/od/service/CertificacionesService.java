package com.axpe.od.service;

import java.util.List;

import com.axpe.od.dao.CatTag;
import com.axpe.od.dao.CatTitulacione;



public interface CertificacionesService {
	List<CatTitulacione> getAllCertificaciones();
	public CatTitulacione save(CatTitulacione catTag);
	public CatTitulacione update(CatTitulacione catTag);
	public void deleteById(Integer id);
}
