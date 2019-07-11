package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_idiomas database table.
 * 
 */
@Entity
@Table(name="cat_idiomas", schema="monolito_god")
@NamedQuery(name="CatIdioma.findAll", query="SELECT c FROM CatIdioma c")
public class CatIdioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdidioma;

	private Integer cdusuario;

	private String dsidioma;

	private Timestamp fcmodificacion;

	public CatIdioma() {
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

	public String getDsidioma() {
		return this.dsidioma;
	}

	public void setDsidioma(String dsidioma) {
		this.dsidioma = dsidioma;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

}