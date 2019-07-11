package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.CatTipoTitulacion;

@Repository
public interface CadTipoTitulacionRepository extends JpaRepository<CatTipoTitulacion,Integer> {

}
