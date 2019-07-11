package com.axpe.od.model;

import java.io.Serializable;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Contact extends Auditable implements Serializable {


	private static final long serialVersionUID = 1L;


	private Integer contactId;

	private String professionalName;

	private String recruiter;

	private Timestamp contactDate;

	private int currentWage;

	private int expectedWage;

	private String state;

	private String information;

	private String availability;

	@JsonIgnore
	private Professional professional;

	private String score;


}
