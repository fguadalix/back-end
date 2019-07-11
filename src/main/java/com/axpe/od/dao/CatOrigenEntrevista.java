package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_origen_entrevista database table.
 * 
 */
@Entity
@Table(name="cat_origen_entrevista", schema="monolito_god")
@NamedQuery(name="CatOrigenEntrevista.findAll", query="SELECT c FROM CatOrigenEntrevista c")
public class CatOrigenEntrevista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdorigen;

	private Integer cdusuario;

	private String dsorigen;

	private Timestamp femodificacion;

	public CatOrigenEntrevista() {
	}

	public Integer getCdorigen() {
		return this.cdorigen;
	}

	public void setCdorigen(Integer cdorigen) {
		this.cdorigen = cdorigen;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsorigen() {
		return this.dsorigen;
	}

	public void setDsorigen(String dsorigen) {
		this.dsorigen = dsorigen;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}