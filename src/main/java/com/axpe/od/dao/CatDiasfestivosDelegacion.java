package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cat_diasfestivos_delegacion database table.
 * 
 */
@Entity
@Table(name="cat_diasfestivos_delegacion", schema="monolito_god")
@NamedQuery(name="CatDiasfestivosDelegacion.findAll", query="SELECT c FROM CatDiasfestivosDelegacion c")
public class CatDiasfestivosDelegacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdfestivosdelegacion;

	private Integer cdfestivo;

	private Integer coddelegacion;

	public CatDiasfestivosDelegacion() {
	}

	public Integer getCdfestivosdelegacion() {
		return this.cdfestivosdelegacion;
	}

	public void setCdfestivosdelegacion(Integer cdfestivosdelegacion) {
		this.cdfestivosdelegacion = cdfestivosdelegacion;
	}

	public Integer getCdfestivo() {
		return this.cdfestivo;
	}

	public void setCdfestivo(Integer cdfestivo) {
		this.cdfestivo = cdfestivo;
	}

	public Integer getCoddelegacion() {
		return this.coddelegacion;
	}

	public void setCoddelegacion(Integer coddelegacion) {
		this.coddelegacion = coddelegacion;
	}

}