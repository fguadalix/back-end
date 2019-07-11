package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatAmbfuncional;

@Repository
public interface CatAmbfuncionalRepository extends JpaRepository<CatAmbfuncional, Integer> {
	
	@Query("SELECT cdambfuncional FROM CatAmbfuncional u WHERE u.dsambfuncional = :description")
	Integer getIdFromDescription(@Param("description") String description);

}
