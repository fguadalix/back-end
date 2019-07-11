package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the god_profes_herram database table.
 * 
 */
@Embeddable
public class GodProfesHerramPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer cdprofesional;

	@Column(insertable=false, updatable=false)
	private Integer cdherramienta;

	public GodProfesHerramPK() {
	}
	
	public Integer getCdprofesional() {
		return this.cdprofesional;
	}
	public void setCdprofesional(Integer cdprofesional) {
		this.cdprofesional = cdprofesional;
	}
	public Integer getCdherramienta() {
		return this.cdherramienta;
	}
	public void setCdherramienta(Integer cdherramienta) {
		this.cdherramienta = cdherramienta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GodProfesHerramPK)) {
			return false;
		}
		GodProfesHerramPK castOther = (GodProfesHerramPK)other;
		return 
			this.cdprofesional.equals(castOther.cdprofesional)
			&& this.cdherramienta.equals(castOther.cdherramienta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdprofesional.hashCode();
		hash = hash * prime + this.cdherramienta.hashCode();
		
		return hash;
	}
}