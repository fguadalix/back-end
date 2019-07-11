package com.axpe.od.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatSectorNegocioRequest {
	private Integer unit;
	private Integer cdusuario;
	private Integer codcategoria;
	private String dscategoria;
}