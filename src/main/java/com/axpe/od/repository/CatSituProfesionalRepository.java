package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.axpe.od.dao.CatSituProfesional;

@Repository
public interface CatSituProfesionalRepository extends JpaRepository<CatSituProfesional, Integer> {

	@Query("SELECT cdsituProf FROM CatSituProfesional u WHERE u.dssituProf = :description")
	Integer getIdFromDescription(@Param("description") String description);
}
