package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tecnologias database table.
 * 
 */
@Entity
@Table(name="cat_tecnologias", schema="monolito_god")
@NamedQuery(name="CatTecnologia.findAll", query="SELECT c FROM CatTecnologia c")
public class CatTecnologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdtecnologia;

	private Integer cdusuario;

	private String dstecnologia;

	private Timestamp femodificacion;

	public CatTecnologia() {
	}

	public Integer getCdtecnologia() {
		return this.cdtecnologia;
	}

	public void setCdtecnologia(Integer cdtecnologia) {
		this.cdtecnologia = cdtecnologia;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstecnologia() {
		return this.dstecnologia;
	}

	public void setDstecnologia(String dstecnologia) {
		this.dstecnologia = dstecnologia;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}