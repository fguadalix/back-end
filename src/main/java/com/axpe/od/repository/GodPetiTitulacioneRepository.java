package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.GodPetiTitulacione;


@Repository
public interface GodPetiTitulacioneRepository 
				extends JpaRepository<GodPetiTitulacione, Integer>, JpaSpecificationExecutor<GodPetiTitulacione> {

}
