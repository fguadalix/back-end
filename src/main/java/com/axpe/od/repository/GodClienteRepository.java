package com.axpe.od.repository;

import com.axpe.od.dao.GodCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GodClienteRepository extends JpaRepository<GodCliente, Integer> {
	
	@Query ("select f from GodCliente f where f.client=:cliente" )
	public GodCliente searchByClient (String cliente);

}
