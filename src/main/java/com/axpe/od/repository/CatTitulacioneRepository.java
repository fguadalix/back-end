package com.axpe.od.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatTitulacione;

@Repository
public interface CatTitulacioneRepository extends JpaRepository<CatTitulacione,Integer> {
	 
//	List<CatTitulacione> findAllById(Integer certificationId);
}
