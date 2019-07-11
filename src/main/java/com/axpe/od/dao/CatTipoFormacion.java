package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_formacion database table.
 * 
 */
@Entity
@Table(name="cat_tipo_formacion", schema="monolito_god")
@NamedQuery(name="CatTipoFormacion.findAll", query="SELECT c FROM CatTipoFormacion c")
public class CatTipoFormacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_formacion")
	private Integer cdtipoFormacion;

	private Integer cdusuario;

	@Column(name="dstipo_formacion")
	private String dstipoFormacion;

	private Timestamp femodificacion;

	public CatTipoFormacion() {
	}

	public Integer getCdtipoFormacion() {
		return this.cdtipoFormacion;
	}

	public void setCdtipoFormacion(Integer cdtipoFormacion) {
		this.cdtipoFormacion = cdtipoFormacion;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoFormacion() {
		return this.dstipoFormacion;
	}

	public void setDstipoFormacion(String dstipoFormacion) {
		this.dstipoFormacion = dstipoFormacion;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}