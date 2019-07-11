package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_gerente database table.
 * 
 */
@Entity
@Table(name="cat_tipo_gerente", schema="monolito_god")
@NamedQuery(name="CatTipoGerente.findAll", query="SELECT c FROM CatTipoGerente c")
public class CatTipoGerente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_gerente")
	private Integer cdtipoGerente;

	private Integer cdusuario;

	@Column(name="dstipo_gerente")
	private String dstipoGerente;

	private Timestamp femodificacion;

	public CatTipoGerente() {
	}

	public Integer getCdtipoGerente() {
		return this.cdtipoGerente;
	}

	public void setCdtipoGerente(Integer cdtipoGerente) {
		this.cdtipoGerente = cdtipoGerente;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoGerente() {
		return this.dstipoGerente;
	}

	public void setDstipoGerente(String dstipoGerente) {
		this.dstipoGerente = dstipoGerente;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}