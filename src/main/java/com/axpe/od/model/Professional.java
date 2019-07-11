package com.axpe.od.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Professional extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer professionalId;
	private String name;
	private String firstLastName;
	private String secondLastName;
	private String dni;
	private String email;
	private Timestamp birthDate;
	private String phoneNumber;
	private String cellNumber;
	private String workCategory;
	private String state;
	private int minWage;
	private int maxWage;
	private String availability;
	private String country;
	private String province;
	private String certification;
	private String specialization;
	private String university;
	private String url;
	private String description;
	private String keywords;
	private int score;
	private Boolean hasFiles;
	private String businessArea;
	private Timestamp lastModificationDate;
	@JsonIgnore
	private List<Assignation> asignaciones = new ArrayList<>();

	@JsonIgnore
	private List<Contact> contacts = new ArrayList<>();

	@JsonIgnore
	private List<WorkExperience> workExperiences = new ArrayList<>();

	public Professional(Professional professional) {

		this.name = professional.getName();
		this.firstLastName = professional.getFirstLastName();
		this.secondLastName = professional.getSecondLastName();
		this.dni = professional.getDni();
		this.email = professional.getEmail();
		this.phoneNumber = professional.getPhoneNumber();
		this.cellNumber = professional.getCellNumber();
		this.workCategory = professional.getWorkCategory();
		this.state = professional.getState();
		this.minWage = professional.getMinWage();
		this.maxWage = professional.getMaxWage();
		this.availability = professional.getAvailability();
		this.country = professional.getCountry();
		this.province = professional.getProvince();
		this.certification = professional.getCertification();
		this.specialization = professional.getSpecialization();
		this.university = professional.getUniversity();
		this.score = professional.getScore();
		this.businessArea = professional.getBusinessArea();
		this.birthDate = professional.getBirthDate();
		this.url = professional.getUrl();
		this.keywords = professional.getKeywords();
		this.description = professional.getDescription();
		this.lastModificationDate = professional.getLastModificationDate();
		this.hasFiles = professional.getHasFiles();
	}

	public Professional(Professional professional, Integer professionalId) {

		this.professionalId = professionalId;
		this.name = professional.getName();
		this.firstLastName = professional.getFirstLastName();
		this.secondLastName = professional.getSecondLastName();
		this.birthDate = professional.getBirthDate();
		this.url = professional.getUrl();
		this.dni = professional.getDni();
		this.email = professional.getEmail();
		this.phoneNumber = professional.getPhoneNumber();
		this.cellNumber = professional.getCellNumber();
		this.workCategory = professional.getWorkCategory();
		this.state = professional.getState();
		this.minWage = professional.getMinWage();
		this.maxWage = professional.getMaxWage();
		this.availability = professional.getAvailability();
		this.country = professional.getCountry();
		this.province = professional.getProvince();
		this.certification = professional.getCertification();
		this.specialization = professional.getSpecialization();
		this.university = professional.getUniversity();
		this.score = professional.getScore();
		this.businessArea = professional.getBusinessArea();
		this.keywords = professional.getKeywords();
		this.description = professional.getDescription();
		this.lastModificationDate = professional.getLastModificationDate();
		this.hasFiles = professional.getHasFiles();
	}
}
