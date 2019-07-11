package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_universidad_cf database table.
 * 
 */
@Entity
@Table(name="cat_universidad_cf", schema="monolito_god")
@NamedQuery(name="CatUniversidadCf.findAll", query="SELECT c FROM CatUniversidadCf c")
public class CatUniversidadCf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdcentro_formativo")
	private Integer cdcentroFormativo;

	private Integer cdusuario;

	@Column(name="dscentro_formativo")
	private String dscentroFormativo;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to GodProfTitulacione
	@OneToMany(mappedBy="catUniversidadCf")
	private List<GodProfTitulacione> godProfTitulaciones;

	public CatUniversidadCf() {
	}

	public Integer getCdcentroFormativo() {
		return this.cdcentroFormativo;
	}

	public void setCdcentroFormativo(Integer cdcentroFormativo) {
		this.cdcentroFormativo = cdcentroFormativo;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDscentroFormativo() {
		return this.dscentroFormativo;
	}

	public void setDscentroFormativo(String dscentroFormativo) {
		this.dscentroFormativo = dscentroFormativo;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<GodProfTitulacione> getGodProfTitulaciones() {
		return this.godProfTitulaciones;
	}

	public void setGodProfTitulaciones(List<GodProfTitulacione> godProfTitulaciones) {
		this.godProfTitulaciones = godProfTitulaciones;
	}

	public GodProfTitulacione addGodProfTitulacione(GodProfTitulacione godProfTitulacione) {
		getGodProfTitulaciones().add(godProfTitulacione);
		godProfTitulacione.setCatUniversidadCf(this);

		return godProfTitulacione;
	}

	public GodProfTitulacione removeGodProfTitulacione(GodProfTitulacione godProfTitulacione) {
		getGodProfTitulaciones().remove(godProfTitulacione);
		godProfTitulacione.setCatUniversidadCf(null);

		return godProfTitulacione;
	}

}