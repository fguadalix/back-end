package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatTag;
import com.axpe.od.repository.KeywordRepository;
import com.axpe.od.service.KeywordService;

/***
 * CLASE CON LA LOGICA DE NEGOCIO ENDPOINT - Es llamada desde las clases
 * controlLER - consume las funciones jpaRepository - Mapea front - back
 *
 */

@Service
public class KeywordServiceImpl implements KeywordService {

	

	@Autowired
	KeywordRepository keywordRepository;

	@Override
	public List<CatTag> getAllKeywords() {
		return keywordRepository.findAll();
	}

	@Override
	public CatTag save(CatTag catTag) {
		return keywordRepository.save(catTag);
	}

	@Override
	public CatTag update(CatTag catTag) {
		return keywordRepository.save(catTag);
		
	}

	@Override
	public void deleteById(Integer id) {
		keywordRepository.deleteById(id);
	}

}
