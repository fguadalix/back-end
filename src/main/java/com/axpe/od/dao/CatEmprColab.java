package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_empr_colab database table.
 * 
 */
@Entity
@Table(name="cat_empr_colab", schema="monolito_god")
@NamedQuery(name="CatEmprColab.findAll", query="SELECT c FROM CatEmprColab c")
public class CatEmprColab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdempr_colab")
	private Integer cdemprColab;

	private Integer cdusuario;

	private String cif;

	private String domicilio;

	@Column(name="dsempr_colab")
	private String dsemprColab;

	private Timestamp fealta;

	private Timestamp femodificacion;

	private String municipio;

	private String observaciones;

	//bi-directional many-to-one association to CatPais
	@ManyToOne
	@JoinColumn(name="pais")
	private CatPais catPais;

	//bi-directional many-to-one association to CatProvincia
	@ManyToOne
	@JoinColumn(name="cdprov")
	private CatProvincia catProvincia;

	public CatEmprColab() {
	}

	public Integer getCdemprColab() {
		return this.cdemprColab;
	}

	public void setCdemprColab(Integer cdemprColab) {
		this.cdemprColab = cdemprColab;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDsemprColab() {
		return this.dsemprColab;
	}

	public void setDsemprColab(String dsemprColab) {
		this.dsemprColab = dsemprColab;
	}

	public Timestamp getFealta() {
		return this.fealta;
	}

	public void setFealta(Timestamp fealta) {
		this.fealta = fealta;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public CatPais getCatPais() {
		return this.catPais;
	}

	public void setCatPais(CatPais catPais) {
		this.catPais = catPais;
	}

	public CatProvincia getCatProvincia() {
		return this.catProvincia;
	}

	public void setCatProvincia(CatProvincia catProvincia) {
		this.catProvincia = catProvincia;
	}

}