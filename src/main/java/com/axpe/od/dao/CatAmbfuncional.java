package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_ambfuncional database table.
 * 
 */
@Entity
@Table(name="cat_ambfuncional", schema="monolito_god")
@NamedQuery(name="CatAmbfuncional.findAll", query="SELECT c FROM CatAmbfuncional c")
public class CatAmbfuncional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdambfuncional;

	private Integer cdusuario;

	private Integer deleted;

	private String dsambfuncional;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatTipoAmbfuncional
	@ManyToOne
	@JoinColumn(name="cdtip_ambfuncionla")
	private CatTipoAmbfuncional catTipoAmbfuncional;

	public CatAmbfuncional() {
	}

	public Integer getCdambfuncional() {
		return this.cdambfuncional;
	}

	public void setCdambfuncional(Integer cdambfuncional) {
		this.cdambfuncional = cdambfuncional;
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

	public String getDsambfuncional() {
		return this.dsambfuncional;
	}

	public void setDsambfuncional(String dsambfuncional) {
		this.dsambfuncional = dsambfuncional;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public CatTipoAmbfuncional getCatTipoAmbfuncional() {
		return this.catTipoAmbfuncional;
	}

	public void setCatTipoAmbfuncional(CatTipoAmbfuncional catTipoAmbfuncional) {
		this.catTipoAmbfuncional = catTipoAmbfuncional;
	}

}