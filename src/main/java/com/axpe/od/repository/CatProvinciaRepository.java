package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatProvincia;

@Repository
public interface CatProvinciaRepository extends JpaRepository<CatProvincia, Integer>{

	@Query("SELECT cdprovincia FROM CatProvincia u WHERE u.dsprovincia = :name")
	Integer getIdFromProvinceName(@Param("name") String provinceName);
	
}
