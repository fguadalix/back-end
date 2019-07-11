package com.axpe.od.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axpe.od.dao.CatTag;


public interface KeywordRepository extends JpaRepository<CatTag, Integer> {

}
