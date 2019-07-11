package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatPrioridad;

@Repository
public interface CatPrioridadRepository extends JpaRepository<CatPrioridad, Integer> {

	@Query ("select f from CatPrioridad f where f.dsprioridad=:priority")
	public CatPrioridad  searchByPriority (String priority );
}
