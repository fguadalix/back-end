package com.axpe.od.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axpe.od.model.WorkExperience;

@Service
public interface WorkExperienceService {
	public List<WorkExperience> findAllByProfessionalId(Integer professionalId);
	public WorkExperience findByWorkIdAndProfessionalId(Integer workId, Integer professionalId);
	public void save(WorkExperience catTag);
	public void update(WorkExperience catTag);
	public void deleteById(Integer id);
}

