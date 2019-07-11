package com.axpe.od.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Specialization extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer specializationId;
	private Integer certificationId;
	private String specialization;

}
