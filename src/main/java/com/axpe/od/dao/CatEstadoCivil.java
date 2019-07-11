package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_estado_civil database table.
 * 
 */
@Entity
@Table(name="cat_estado_civil", schema="monolito_god")
@NamedQuery(name="CatEstadoCivil.findAll", query="SELECT c FROM CatEstadoCivil c")
public class CatEstadoCivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdestado_civil")
	private Integer cdestadoCivil;

	private Integer cdusuario;

	@Column(name="codestado_civil")
	private Integer codestadoCivil;

	@Column(name="dsestado_civil")
	private String dsestadoCivil;

	private Timestamp femodificacion;

	public CatEstadoCivil() {
	}

	public Integer getCdestadoCivil() {
		return this.cdestadoCivil;
	}

	public void setCdestadoCivil(Integer cdestadoCivil) {
		this.cdestadoCivil = cdestadoCivil;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getCodestadoCivil() {
		return this.codestadoCivil;
	}

	public void setCodestadoCivil(Integer codestadoCivil) {
		this.codestadoCivil = codestadoCivil;
	}

	public String getDsestadoCivil() {
		return this.dsestadoCivil;
	}

	public void setDsestadoCivil(String dsestadoCivil) {
		this.dsestadoCivil = dsestadoCivil;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}