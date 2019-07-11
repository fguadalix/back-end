package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.search.annotations.Indexed;

import java.sql.Timestamp;


/**
 * The persistent class for the cat_actividad_negocio database table.
 * 
 */
@Entity
@Table(name="cat_actividad_negocio", schema="monolito_god")
@Indexed
@NamedQuery(name="CatActividadNegocio.findAll", query="SELECT c FROM CatActividadNegocio c")
public class CatActividadNegocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdactividad;

	private Integer cdusuario;

	private String dsactividad;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatSectorNegocio
	@ManyToOne
	@JoinColumn(name="cdsectorn")
	private CatSectorNegocio catSectorNegocio;

	public CatActividadNegocio() {
	}

	public Integer getCdactividad() {
		return this.cdactividad;
	}

	public void setCdactividad(Integer cdactividad) {
		this.cdactividad = cdactividad;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsactividad() {
		return this.dsactividad;
	}

	public void setDsactividad(String dsactividad) {
		this.dsactividad = dsactividad;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public CatSectorNegocio getCatSectorNegocio() {
		return this.catSectorNegocio;
	}

	public void setCatSectorNegocio(CatSectorNegocio catSectorNegocio) {
		this.catSectorNegocio = catSectorNegocio;
	}

}