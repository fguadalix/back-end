package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_traducciones database table.
 * 
 */
@Entity
@Table(name="god_traducciones", schema = "monolito_god")
@NamedQuery(name="GodTraduccione.findAll", query="SELECT g FROM GodTraduccione g")
public class GodTraduccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GodTraduccionePK id;

	private Integer cdusuario;

	private Integer deleted;

	private Timestamp femodificacion;

	private String texto;

	public GodTraduccione() {
	}

	public GodTraduccionePK getId() {
		return this.id;
	}

	public void setId(GodTraduccionePK id) {
		this.id = id;
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

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}