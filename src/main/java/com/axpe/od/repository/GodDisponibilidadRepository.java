package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.GodDisponibilidad;

@Repository
public interface GodDisponibilidadRepository extends JpaRepository<GodDisponibilidad, Integer> {
	
	@Query("SELECT cddisponibilidad FROM GodDisponibilidad u WHERE u.dsdisponibilidad = :description")
	Integer getIdFromDescription(@Param("description") String description);

}
