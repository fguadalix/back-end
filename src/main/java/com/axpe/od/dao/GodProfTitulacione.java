package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_prof_titulaciones database table.
 * 
 */
@Entity
@Table(name="god_prof_titulaciones", schema = "monolito_god")
@NamedQuery(name="GodProfTitulacione.findAll", query="SELECT g FROM GodProfTitulacione g")
public class GodProfTitulacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdprof_titulacion")
	private Integer cdprofTitulacion;

	private Integer cdtitulacion;

	private Integer cdusuario;

	private Integer deleted;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to CatUniversidadCf
	@ManyToOne
	@JoinColumn(name="cdcentro_formativo")
	private CatUniversidadCf catUniversidadCf;

	//bi-directional many-to-one association to GodProfesionale
	@ManyToOne
	@JoinColumn(name="cdprofesional")
	private GodProfesionale godProfesionale;

	public GodProfTitulacione() {
	}

	public Integer getCdprofTitulacion() {
		return this.cdprofTitulacion;
	}

	public void setCdprofTitulacion(Integer cdprofTitulacion) {
		this.cdprofTitulacion = cdprofTitulacion;
	}

	public Integer getCdtitulacion() {
		return this.cdtitulacion;
	}

	public void setCdtitulacion(Integer cdtitulacion) {
		this.cdtitulacion = cdtitulacion;
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

	public CatUniversidadCf getCatUniversidadCf() {
		return this.catUniversidadCf;
	}

	public void setCatUniversidadCf(CatUniversidadCf catUniversidadCf) {
		this.catUniversidadCf = catUniversidadCf;
	}

	public GodProfesionale getGodProfesionale() {
		return this.godProfesionale;
	}

	public void setGodProfesionale(GodProfesionale godProfesionale) {
		this.godProfesionale = godProfesionale;
	}

}