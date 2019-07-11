package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatSituPeticion;

@Repository
public interface CatSituPeticionRepository extends JpaRepository<CatSituPeticion, Integer>  {
	
	@Query ("SELECT f FROM CatSituPeticion f WHERE f.dssituPeti=:state")
	public CatSituPeticion searchByState(@Param("state") String state );

}
