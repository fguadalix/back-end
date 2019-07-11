package com.axpe.od.service;

import java.util.List;

import com.axpe.od.dao.CatCategoria;


public interface CategoriasService {
	public List<CatCategoria> getAllCategories();
	public CatCategoria save(CatCategoria catTag);
	public CatCategoria update(CatCategoria catTag);
	public void deleteById(Integer id);
}
