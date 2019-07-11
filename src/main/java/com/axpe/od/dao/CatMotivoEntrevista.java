package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_motivo_entrevista database table.
 * 
 */
@Entity
@Table(name="cat_motivo_entrevista", schema="monolito_god")
@NamedQuery(name="CatMotivoEntrevista.findAll", query="SELECT c FROM CatMotivoEntrevista c")
public class CatMotivoEntrevista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdmotivo;

	private Integer cdusuario;

	private String dsmotivo;

	private Timestamp femodificacion;

	public CatMotivoEntrevista() {
	}

	public Integer getCdmotivo() {
		return this.cdmotivo;
	}

	public void setCdmotivo(Integer cdmotivo) {
		this.cdmotivo = cdmotivo;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsmotivo() {
		return this.dsmotivo;
	}

	public void setDsmotivo(String dsmotivo) {
		this.dsmotivo = dsmotivo;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}