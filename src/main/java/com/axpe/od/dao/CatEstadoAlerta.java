package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_estado_alerta database table.
 * 
 */
@Entity
@Table(name="cat_estado_alerta", schema="monolito_god")
@NamedQuery(name="CatEstadoAlerta.findAll", query="SELECT c FROM CatEstadoAlerta c")
public class CatEstadoAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdestado_alerta")
	private Integer cdestadoAlerta;

	private Integer cdusuario;

	@Column(name="dsestado_alerta")
	private String dsestadoAlerta;

	private Timestamp femodificacion;

	public CatEstadoAlerta() {
	}

	public Integer getCdestadoAlerta() {
		return this.cdestadoAlerta;
	}

	public void setCdestadoAlerta(Integer cdestadoAlerta) {
		this.cdestadoAlerta = cdestadoAlerta;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsestadoAlerta() {
		return this.dsestadoAlerta;
	}

	public void setDsestadoAlerta(String dsestadoAlerta) {
		this.dsestadoAlerta = dsestadoAlerta;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}