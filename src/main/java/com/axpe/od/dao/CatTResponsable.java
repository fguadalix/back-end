package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_t_responsable database table.
 * 
 */
@Entity
@Table(name="cat_t_responsable", schema="monolito_god")
@NamedQuery(name="CatTResponsable.findAll", query="SELECT c FROM CatTResponsable c")
public class CatTResponsable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdresponsable;

	private Integer cdusuario;

	private String dsresponsable;

	private Timestamp fcmodificacion;

	@Column(name="orden_firma")
	private Integer ordenFirma;

	public CatTResponsable() {
	}

	public Integer getCdresponsable() {
		return this.cdresponsable;
	}

	public void setCdresponsable(Integer cdresponsable) {
		this.cdresponsable = cdresponsable;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsresponsable() {
		return this.dsresponsable;
	}

	public void setDsresponsable(String dsresponsable) {
		this.dsresponsable = dsresponsable;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public Integer getOrdenFirma() {
		return this.ordenFirma;
	}

	public void setOrdenFirma(Integer ordenFirma) {
		this.ordenFirma = ordenFirma;
	}

}