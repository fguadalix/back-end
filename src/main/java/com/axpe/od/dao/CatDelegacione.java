package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cat_delegaciones database table.
 * 
 */
@Entity
@Table(name="cat_delegaciones", schema="monolito_god")
@NamedQuery(name="CatDelegacione.findAll", query="SELECT c FROM CatDelegacione c")
public class CatDelegacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cddelegacion;

	private Integer coddelegacion;

	private String dsdelegacion;

	public CatDelegacione() {
	}

	public Integer getCddelegacion() {
		return this.cddelegacion;
	}

	public void setCddelegacion(Integer cddelegacion) {
		this.cddelegacion = cddelegacion;
	}

	public Integer getCoddelegacion() {
		return this.coddelegacion;
	}

	public void setCoddelegacion(Integer coddelegacion) {
		this.coddelegacion = coddelegacion;
	}

	public String getDsdelegacion() {
		return this.dsdelegacion;
	}

	public void setDsdelegacion(String dsdelegacion) {
		this.dsdelegacion = dsdelegacion;
	}

}