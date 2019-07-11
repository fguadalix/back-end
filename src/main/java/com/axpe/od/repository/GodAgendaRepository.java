package com.axpe.od.repository;

import com.axpe.od.dao.GodAgenda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GodAgendaRepository extends JpaRepository<GodAgenda, Integer> {

	@Query("SELECT u FROM GodAgenda u WHERE u.username = :username")
	List<GodAgenda> findAgendaByUsername(@Param("username") String username);
}
