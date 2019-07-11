package com.axpe.od.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axpe.od.dao.GodProfExp;

@Repository
public interface WorkExperienceRepository extends JpaRepository<GodProfExp, Integer> {

	@Query(value = "SELECT u FROM GodProfExp u where cdprofesional = :professionalId")
	List<GodProfExp> findAllByProfessionalId(Integer professionalId);

	@Query(value = "SELECT u FROM GodProfExp u where cdprofesional = :professionalId  and cdprof_exp = :workId")
	Optional<GodProfExp> findByWorkIdAndProfessional_ProfessionalId(Integer workId, Integer professionalId);
}
