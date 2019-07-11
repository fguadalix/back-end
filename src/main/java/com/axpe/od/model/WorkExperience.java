package com.axpe.od.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class WorkExperience extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer workId;
	private Integer cdprofessional;
	private String description;
	private Timestamp startDate;
	private Timestamp endDate;
	private boolean stillThere;
	private String client;
	private String category;
	@JsonIgnore
	private Professional professional;

}
