package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_emple database table.
 * 
 */
@Entity
@Table(name="cat_tipo_emple", schema="monolito_god")
@NamedQuery(name="CatTipoEmple.findAll", query="SELECT c FROM CatTipoEmple c")
public class CatTipoEmple implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_emple")
	private Integer cdtipoEmple;

	private Integer cdusuario;

	@Column(name="dstipo_emple")
	private String dstipoEmple;

	private Timestamp femodificacion;

	public CatTipoEmple() {
	}

	public Integer getCdtipoEmple() {
		return this.cdtipoEmple;
	}

	public void setCdtipoEmple(Integer cdtipoEmple) {
		this.cdtipoEmple = cdtipoEmple;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoEmple() {
		return this.dstipoEmple;
	}

	public void setDstipoEmple(String dstipoEmple) {
		this.dstipoEmple = dstipoEmple;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}