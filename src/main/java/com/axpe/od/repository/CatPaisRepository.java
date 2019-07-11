package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatPais;

@Repository
public interface CatPaisRepository extends JpaRepository<CatPais, Integer>{

	@Query("SELECT cdpais FROM CatPais u WHERE u.pais = :countryName")
	Integer getIdFromCountryName(@Param("countryName") String countryName);
	
}
