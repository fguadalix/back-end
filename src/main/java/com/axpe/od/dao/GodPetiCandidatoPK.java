package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the god_peti_candidato database table.
 * 
 */
@Embeddable
public class GodPetiCandidatoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer cdpeticion;

	private Integer cdprofesional;

	public GodPetiCandidatoPK() {
	}
	public Integer getCdpeticion() {
		return this.cdpeticion;
	}
	public void setCdpeticion(Integer cdpeticion) {
		this.cdpeticion = cdpeticion;
	}
	public Integer getCdprofesional() {
		return this.cdprofesional;
	}
	public void setCdprofesional(Integer cdprofesional) {
		this.cdprofesional = cdprofesional;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GodPetiCandidatoPK)) {
			return false;
		}
		GodPetiCandidatoPK castOther = (GodPetiCandidatoPK)other;
		return 
			this.cdpeticion.equals(castOther.cdpeticion)
			&& this.cdprofesional.equals(castOther.cdprofesional);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdpeticion.hashCode();
		hash = hash * prime + this.cdprofesional.hashCode();
		
		return hash;
	}
}