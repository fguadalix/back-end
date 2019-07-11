package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the god_entrevistadores database table.
 * 
 */
@Embeddable
public class GodEntrevistadorePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer cdempleado;

	private Integer cdpeticion;

	public GodEntrevistadorePK() {
	}
	public Integer getCdempleado() {
		return this.cdempleado;
	}
	public void setCdempleado(Integer cdempleado) {
		this.cdempleado = cdempleado;
	}
	public Integer getCdpeticion() {
		return this.cdpeticion;
	}
	public void setCdpeticion(Integer cdpeticion) {
		this.cdpeticion = cdpeticion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GodEntrevistadorePK)) {
			return false;
		}
		GodEntrevistadorePK castOther = (GodEntrevistadorePK)other;
		return 
			this.cdempleado.equals(castOther.cdempleado)
			&& this.cdpeticion.equals(castOther.cdpeticion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cdempleado.hashCode();
		hash = hash * prime + this.cdpeticion.hashCode();
		
		return hash;
	}
}