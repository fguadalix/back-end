package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_peti_titulaciones database table.
 * 
 */
@Entity
@Table(name="god_peti_titulaciones",schema="monolito_god" )
@NamedQuery(name="GodPetiTitulacione.findAll", query="SELECT g FROM GodPetiTitulacione g")
public class GodPetiTitulacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdpeti_titulacion")
	private Integer cdpetiTitulacion;

	@Column(name="cdcentro_formativo")
	private Integer cdcentroFormativo;

	private Integer cdusuario;

	private Integer deleted;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to CatTitulacione
	@ManyToOne
	@JoinColumn(name="cdtitulacion")
	private CatTitulacione catTitulacione;

	//bi-directional many-to-one association to GodPeticione
	@ManyToOne
	@JoinColumn(name="cdpeticion")
	private GodPeticiones godPeticione;

	public GodPetiTitulacione() {
	}

	public Integer getCdpetiTitulacion() {
		return this.cdpetiTitulacion;
	}

	public void setCdpetiTitulacion(Integer cdpetiTitulacion) {
		this.cdpetiTitulacion = cdpetiTitulacion;
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

	public CatTitulacione getCatTitulacione() {
		return this.catTitulacione;
	}

	public void setCatTitulacione(CatTitulacione catTitulacione) {
		this.catTitulacione = catTitulacione;
	}

	public GodPeticiones getGodPeticione() {
		return this.godPeticione;
	}

	public void setGodPeticione(GodPeticiones godPeticione) {
		this.godPeticione = godPeticione;
	}

}