package com.axpe.od.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatUniversidadCf;

@Repository
public interface CatUniversidadesRepository extends JpaRepository<CatUniversidadCf,Integer> {

}
