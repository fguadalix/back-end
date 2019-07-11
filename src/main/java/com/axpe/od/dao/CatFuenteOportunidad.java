package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_fuente_oportunidad database table.
 * 
 */
@Entity
@Table(name="cat_fuente_oportunidad", schema="monolito_god")
@NamedQuery(name="CatFuenteOportunidad.findAll", query="SELECT c FROM CatFuenteOportunidad c")
public class CatFuenteOportunidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdfuente;

	private Integer cdusuario;

	private String dsfuente;

	private Timestamp femodificacion;

	public CatFuenteOportunidad() {
	}

	public Integer getCdfuente() {
		return this.cdfuente;
	}

	public void setCdfuente(Integer cdfuente) {
		this.cdfuente = cdfuente;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsfuente() {
		return this.dsfuente;
	}

	public void setDsfuente(String dsfuente) {
		this.dsfuente = dsfuente;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}