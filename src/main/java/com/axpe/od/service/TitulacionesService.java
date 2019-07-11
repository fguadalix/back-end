package com.axpe.od.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatTitulacione;


@Service
public interface TitulacionesService {
	public List<CatTitulacione> getAllById(Integer ids);
	public CatTitulacione save(CatTitulacione catTag);
	public CatTitulacione update(CatTitulacione catTag);
	public void deleteById(Integer id);
}
