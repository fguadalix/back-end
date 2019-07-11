package com.axpe.od.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Position extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long positionId;
	
	private String manager;
	
	private String company;
	
	private String unit;
	

	@JsonIgnore
	private String recruiter;
	
	private String client;
	
	private String workCategory;
	
	private String priority;
	
	/*not null*/	
	private String state;
	
	private String project;
	private Integer numProfessionals;
	private String rate;
	private Integer minWage;
	private Integer maxWage;
	private String duration;
	private String description;
	private String keywords;
	private String certification;
	private String specialization;
	private LocalDateTime positionDate;
	private LocalDateTime incorporationDate;
	private String externalKey;
	private String shortDescription;
	private String department;
	private Boolean hasFiles;
	@JsonIgnore
	private List<Assignation> asignaciones = new ArrayList<>();

	public Position(Position position) {

		this.manager = position.getManager();
		this.company = position.getCompany();
		this.unit = position.getUnit();
		this.recruiter = position.getRecruiter();
		this.client = position.getClient();
		this.workCategory = position.getWorkCategory();
		this.priority = position.getPriority();
		this.state = position.getState();
		this.project = position.getProject();
		this.numProfessionals = position.getNumProfessionals();
		this.rate = position.getRate();
		this.minWage = position.getMinWage();
		this.maxWage = position.getMaxWage();
		this.duration = position.getDuration();
		this.description = position.getDescription();
		this.specialization = position.getSpecialization();
		this.certification = position.getCertification();
		this.positionDate = position.getPositionDate();
		this.incorporationDate = position.getIncorporationDate();
		this.externalKey = position.getExternalKey();
		this.keywords = position.getKeywords();
		this.shortDescription = position.getShortDescription();
		this.department = position.getDepartment();
		this.hasFiles = position.getHasFiles();
	}

	public Position(Position position, Long positionId) {

		this.positionId = positionId;
		this.manager = position.getManager();
		this.company = position.getCompany();
		this.unit = position.getUnit();
		this.recruiter = position.getRecruiter();
		this.client = position.getClient();
		this.workCategory = position.getWorkCategory();
		this.priority = position.getPriority();
		this.state = position.getState();
		this.project = position.getProject();
		this.numProfessionals = position.getNumProfessionals();
		this.rate = position.getRate();
		this.minWage = position.getMinWage();
		this.maxWage = position.getMaxWage();
		this.duration = position.getDuration();
		this.description = position.getDescription();
		this.specialization = position.getSpecialization();
		this.certification = position.getCertification();
		this.positionDate = position.getPositionDate();
		this.incorporationDate = position.getIncorporationDate();
		this.externalKey = position.getExternalKey();
		this.keywords = position.getKeywords();
		this.asignaciones = position.getAsignaciones();
		this.shortDescription = position.getShortDescription();
		this.department = position.getDepartment();
		this.hasFiles = position.getHasFiles();

	}
}
