package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_entrevistadores database table.
 * 
 */
@Entity
@Table(name="god_entrevistadores", schema="monolito_god")
@NamedQuery(name="GodEntrevistadore.findAll", query="SELECT g FROM GodEntrevistadore g")
public class GodEntrevistadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GodEntrevistadorePK id;

	private Integer cdgerente;

	private Integer cdusuario;

	private Integer deleted;

	private Timestamp fcmodificacion;

	public GodEntrevistadore() {
	}

	public GodEntrevistadorePK getId() {
		return this.id;
	}

	public void setId(GodEntrevistadorePK id) {
		this.id = id;
	}

	public Integer getCdgerente() {
		return this.cdgerente;
	}

	public void setCdgerente(Integer cdgerente) {
		this.cdgerente = cdgerente;
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

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

}