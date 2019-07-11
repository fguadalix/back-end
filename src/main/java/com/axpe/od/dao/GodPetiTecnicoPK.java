package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the god_peti_tecnico database table.
 * 
 */
@Embeddable
public class GodPetiTecnicoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer cdpeticion;

	@Column(name="cdusuario_tecnico")
	private Integer cdusuarioTecnico;

	public GodPetiTecnicoPK() {
	}
	public Integer getCdpeticion() {
		return this.cdpeticion;
	}
	public void setCdpeticion(Integer cdpeticion) {
		this.cdpeticion = cdpeticion;
	}
	public Integer getCdusuarioTecnico() {
		return this.cdusuarioTecnico;
	}
	public void setCdusuarioTecnico(Integer cdusuarioTecnico) {
		this.cdusuarioTecnico = cdusuarioTecnico;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GodPetiTecnicoPK)) {
			return false;
		}
		GodPetiTecnicoPK castOther = (GodPetiTecnicoPK)other;
		return 
			this.cdpeticion.equals(castOther.cdpeticion)
			&& this.cdusuarioTecnico.equals(castOther.cdusuarioTecnico);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdpeticion.hashCode();
		hash = hash * prime + this.cdusuarioTecnico.hashCode();
		
		return hash;
	}
}