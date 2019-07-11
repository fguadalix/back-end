package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the god_traducciones database table.
 * 
 */
@Embeddable
public class GodTraduccionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String modulo;

	private String cdidioma;

	private String objeto;

	public GodTraduccionePK() {
	}
	public String getModulo() {
		return this.modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getCdidioma() {
		return this.cdidioma;
	}
	public void setCdidioma(String cdidioma) {
		this.cdidioma = cdidioma;
	}
	public String getObjeto() {
		return this.objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GodTraduccionePK)) {
			return false;
		}
		GodTraduccionePK castOther = (GodTraduccionePK)other;
		return 
			this.modulo.equals(castOther.modulo)
			&& this.cdidioma.equals(castOther.cdidioma)
			&& this.objeto.equals(castOther.objeto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.modulo.hashCode();
		hash = hash * prime + this.cdidioma.hashCode();
		hash = hash * prime + this.objeto.hashCode();
		
		return hash;
	}
}