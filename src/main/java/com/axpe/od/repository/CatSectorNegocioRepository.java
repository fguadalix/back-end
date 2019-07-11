package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.axpe.od.dao.CatSectorNegocio;

@Repository
public interface CatSectorNegocioRepository extends JpaRepository<CatSectorNegocio, Integer>{

}
