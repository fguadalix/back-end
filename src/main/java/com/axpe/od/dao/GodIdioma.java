package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_idiomas database table.
 * 
 */
@Entity
@Table(name="god_idiomas", schema="monolito_god")
@NamedQuery(name="GodIdioma.findAll", query="SELECT g FROM GodIdioma g")
public class GodIdioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdidioma;

	private Integer cdusuario;

	private Integer deleted;

	private Timestamp femodificacion;

	public GodIdioma() {
	}

	public Integer getCdidioma() {
		return this.cdidioma;
	}

	public void setCdidioma(Integer cdidioma) {
		this.cdidioma = cdidioma;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}