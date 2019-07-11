package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_conceptos_parte database table.
 * 
 */
@Entity
@Table(name="cat_conceptos_parte", schema="monolito_god")
@NamedQuery(name="CatConceptosParte.findAll", query="SELECT c FROM CatConceptosParte c")
public class CatConceptosParte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdconcepto;

	private Integer cdusuario;

	private String dsconcepto;

	private Timestamp femodificacion;

	private Integer idtrabajo;

	public CatConceptosParte() {
	}

	public Integer getCdconcepto() {
		return this.cdconcepto;
	}

	public void setCdconcepto(Integer cdconcepto) {
		this.cdconcepto = cdconcepto;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsconcepto() {
		return this.dsconcepto;
	}

	public void setDsconcepto(String dsconcepto) {
		this.dsconcepto = dsconcepto;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public Integer getIdtrabajo() {
		return this.idtrabajo;
	}

	public void setIdtrabajo(Integer idtrabajo) {
		this.idtrabajo = idtrabajo;
	}

}