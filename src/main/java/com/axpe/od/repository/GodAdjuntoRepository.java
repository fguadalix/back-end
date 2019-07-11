package com.axpe.od.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.axpe.od.dao.GodAdjunto;



public interface GodAdjuntoRepository extends JpaRepository<GodAdjunto , Integer> {
	
	
	@Query("select f from GodAdjunto f where  f.positionid=:positionId" )
	 public List<GodAdjunto> listByPosition (Integer positionId );
	
	
}
