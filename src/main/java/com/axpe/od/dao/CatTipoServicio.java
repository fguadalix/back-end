package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_servicio database table.
 * 
 */
@Entity
@Table(name="cat_tipo_servicio", schema="monolito_god")
@NamedQuery(name="CatTipoServicio.findAll", query="SELECT c FROM CatTipoServicio c")
public class CatTipoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_servicio")
	private Integer cdtipoServicio;

	private Integer cdusuario;

	@Column(name="dstipo_servicio")
	private String dstipoServicio;

	private Timestamp femodificacion;

	public CatTipoServicio() {
	}

	public Integer getCdtipoServicio() {
		return this.cdtipoServicio;
	}

	public void setCdtipoServicio(Integer cdtipoServicio) {
		this.cdtipoServicio = cdtipoServicio;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoServicio() {
		return this.dstipoServicio;
	}

	public void setDstipoServicio(String dstipoServicio) {
		this.dstipoServicio = dstipoServicio;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}