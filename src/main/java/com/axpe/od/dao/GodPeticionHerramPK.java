package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the god_peticion_herram database table.
 * 
 */
@Embeddable
public class GodPeticionHerramPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer cdpeticion;

	@Column(insertable=false, updatable=false)
	private Integer cdherramienta;

	public GodPeticionHerramPK() {
	}
	public Integer getCdpeticion() {
		return this.cdpeticion;
	}
	public void setCdpeticion(Integer cdpeticion) {
		this.cdpeticion = cdpeticion;
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
		if (!(other instanceof GodPeticionHerramPK)) {
			return false;
		}
		GodPeticionHerramPK castOther = (GodPeticionHerramPK)other;
		return 
			this.cdpeticion.equals(castOther.cdpeticion)
			&& this.cdherramienta.equals(castOther.cdherramienta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdpeticion.hashCode();
		hash = hash * prime + this.cdherramienta.hashCode();
		
		return hash;
	}
}