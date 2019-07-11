package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_estado_oferta database table.
 * 
 */
@Entity
@Table(name="cat_estado_oferta", schema="monolito_god")
@NamedQuery(name="CatEstadoOferta.findAll", query="SELECT c FROM CatEstadoOferta c")
public class CatEstadoOferta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdestado_oferta")
	private Integer cdestadoOferta;

	private Integer cdusuario;

	@Column(name="dsestado_oferta")
	private String dsestadoOferta;

	private Timestamp femodificacion;

	public CatEstadoOferta() {
	}

	public Integer getCdestadoOferta() {
		return this.cdestadoOferta;
	}

	public void setCdestadoOferta(Integer cdestadoOferta) {
		this.cdestadoOferta = cdestadoOferta;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsestadoOferta() {
		return this.dsestadoOferta;
	}

	public void setDsestadoOferta(String dsestadoOferta) {
		this.dsestadoOferta = dsestadoOferta;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}