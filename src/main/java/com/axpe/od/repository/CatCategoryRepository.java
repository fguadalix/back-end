package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatCategoria;

@Repository
public interface CatCategoryRepository extends JpaRepository<CatCategoria, Integer> {

	@Query("SELECT cdcategoria FROM CatCategoria u WHERE u.dscategoria = :categoryName")
	Integer getIdFromCategoryName(@Param("categoryName") String categoryName);
	
}
