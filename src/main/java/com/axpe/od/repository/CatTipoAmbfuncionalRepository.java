package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatTipoAmbfuncional;

@Repository
public interface CatTipoAmbfuncionalRepository 
	extends JpaRepository<CatTipoAmbfuncional, Integer>, JpaSpecificationExecutor<CatTipoAmbfuncional>  {
	
	@Query ("select f from CatTipoAmbfuncional f where  f.dstipoAmbfuncional=:unit ")
	public CatTipoAmbfuncional findByUnit(String unit) ;

}
