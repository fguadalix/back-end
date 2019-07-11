package com.axpe.od.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatTag;


@Service
public interface KeywordService {
	public List<CatTag> getAllKeywords();
	public CatTag save(CatTag catTag);
	public CatTag update(CatTag catTag);
	public void deleteById(Integer id);
}
