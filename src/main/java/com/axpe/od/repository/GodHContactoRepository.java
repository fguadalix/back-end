package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.GodHContacto;


@Repository
public interface GodHContactoRepository extends JpaRepository<GodHContacto, Integer> {

}
