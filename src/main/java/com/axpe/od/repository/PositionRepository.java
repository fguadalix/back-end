package com.axpe.od.repository;

import com.axpe.od.dao.GodPeticiones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository
    extends JpaRepository<GodPeticiones, Integer>, JpaSpecificationExecutor<GodPeticiones> {

	@Query (value=
			 "select G.*  from monolito_god.god_peticiones  G, monolito_god.cat_situ_peticion  C  \n" + 
			 "where  G.cdsitu_peti = C.cdsitu_peti\n" + 
			 "and c.cdsitu_peti in(1,2);" , nativeQuery=true
			 )
	public List<GodPeticiones>  findByAllGodPeticiones ();

}