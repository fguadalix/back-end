package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_contacto database table.
 * 
 */
@Entity
@Table(name="cat_tipo_contacto", schema="monolito_god")
@NamedQuery(name="CatTipoContacto.findAll", query="SELECT c FROM CatTipoContacto c")
public class CatTipoContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_contacto")
	private Integer cdtipoContacto;

	private Integer cdusuario;

	@Column(name="dstipo_contacto")
	private String dstipoContacto;

	private Timestamp fcmodificacion;

	public CatTipoContacto() {
	}

	public Integer getCdtipoContacto() {
		return this.cdtipoContacto;
	}

	public void setCdtipoContacto(Integer cdtipoContacto) {
		this.cdtipoContacto = cdtipoContacto;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoContacto() {
		return this.dstipoContacto;
	}

	public void setDstipoContacto(String dstipoContacto) {
		this.dstipoContacto = dstipoContacto;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

}