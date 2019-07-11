package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatCategoria;
import com.axpe.od.dao.CatTag;
import com.axpe.od.repository.CatCategoryRepository;
import com.axpe.od.service.CategoriasService;

@Service
public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	CatCategoryRepository categoriesRepository;

	
		@Override
	public List<CatCategoria> getAllCategories() {
		return categoriesRepository.findAll();
	}
		@Override
		public CatCategoria save(CatCategoria catTag) {
			return categoriesRepository.save(catTag);
		}

		@Override
		public CatCategoria update(CatCategoria catTag) {
			return categoriesRepository.save(catTag);
			
		}

		@Override
		public void deleteById(Integer id) {
			categoriesRepository.deleteById(id);
		}
	
}
