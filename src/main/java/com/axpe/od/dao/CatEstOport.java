package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_est_oport database table.
 * 
 */
@Entity
@Table(name="cat_est_oport", schema="monolito_god")
@NamedQuery(name="CatEstOport.findAll", query="SELECT c FROM CatEstOport c")
public class CatEstOport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdestado_oportunidad")
	private Integer cdestadoOportunidad;

	private Integer cdusuario;

	@Column(name="dsestado_oportunidad")
	private String dsestadoOportunidad;

	private Timestamp fcmodificacion;

	public CatEstOport() {
	}

	public Integer getCdestadoOportunidad() {
		return this.cdestadoOportunidad;
	}

	public void setCdestadoOportunidad(Integer cdestadoOportunidad) {
		this.cdestadoOportunidad = cdestadoOportunidad;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsestadoOportunidad() {
		return this.dsestadoOportunidad;
	}

	public void setDsestadoOportunidad(String dsestadoOportunidad) {
		this.dsestadoOportunidad = dsestadoOportunidad;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

}