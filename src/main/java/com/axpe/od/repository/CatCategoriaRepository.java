package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatCategoria;

@Repository
public interface CatCategoriaRepository extends JpaRepository<CatCategoria,Integer>{

	@Query ("select f from CatCategoria f where f.dscategoria=:category")
	public CatCategoria findByCategory(String category);
	
}
