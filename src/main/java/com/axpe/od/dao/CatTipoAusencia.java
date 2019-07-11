package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_ausencia database table.
 * 
 */
@Entity
@Table(name="cat_tipo_ausencia", schema="monolito_god")
@NamedQuery(name="CatTipoAusencia.findAll", query="SELECT c FROM CatTipoAusencia c")
public class CatTipoAusencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdausencia;

	private Integer cdusuario;

	private String dsausencia;

	private Timestamp femodificacion;

	public CatTipoAusencia() {
	}

	public Integer getCdausencia() {
		return this.cdausencia;
	}

	public void setCdausencia(Integer cdausencia) {
		this.cdausencia = cdausencia;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsausencia() {
		return this.dsausencia;
	}

	public void setDsausencia(String dsausencia) {
		this.dsausencia = dsausencia;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}