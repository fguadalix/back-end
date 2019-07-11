package com.axpe.od.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Generico extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String description;

}
