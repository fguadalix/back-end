package com.axpe.od.repository;

import com.axpe.od.dao.GodProfesionale;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProfessionalRepository
    extends JpaRepository<GodProfesionale, Integer>, JpaSpecificationExecutor<GodProfesionale> {
	
	@Query("SELECT u FROM GodProfesionale u WHERE u.cdprofesional = 256")
	List<GodProfesionale> findAll();

//	@Modifying(clearAutomatically = true)
//	@Transactional
//	@Query("UPDATE Professional p SET p.lastModificationDate = :date WHERE p.id = :professionalId")
//	int updateLastModificationDate(@Param("professionalId") Long professionalId, @Param("date") LocalDateTime date);
}
