package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_documento database table.
 * 
 */
@Entity
@Table(name="cat_tipo_documento", schema="monolito_god")
@NamedQuery(name="CatTipoDocumento.findAll", query="SELECT c FROM CatTipoDocumento c")
public class CatTipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_documento")
	private Integer cdtipoDocumento;

	private Integer cdusuario;

	private Integer coddocumento;

	@Column(name="dstipo_documento")
	private String dstipoDocumento;

	private Timestamp femodificacion;

	public CatTipoDocumento() {
	}

	public Integer getCdtipoDocumento() {
		return this.cdtipoDocumento;
	}

	public void setCdtipoDocumento(Integer cdtipoDocumento) {
		this.cdtipoDocumento = cdtipoDocumento;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getCoddocumento() {
		return this.coddocumento;
	}

	public void setCoddocumento(Integer coddocumento) {
		this.coddocumento = coddocumento;
	}

	public String getDstipoDocumento() {
		return this.dstipoDocumento;
	}

	public void setDstipoDocumento(String dstipoDocumento) {
		this.dstipoDocumento = dstipoDocumento;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}