package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_peticion_herram database table.
 * 
 */
@Entity
@Table(name="god_peticion_herram")
@NamedQuery(name="GodPeticionHerram.findAll", query="SELECT g FROM GodPeticionHerram g")
public class GodPeticionHerram implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GodPeticionHerramPK id;

	private Integer cdusuario;

	private Integer deleted;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to CatHerramienta
	@ManyToOne
	@JoinColumn(name="cdherramienta", referencedColumnName="cdherramienta", insertable=false, updatable=false)
	private CatHerramienta catHerramienta;

	//bi-directional many-to-one association to CatPerTiempo
	@ManyToOne
	@JoinColumn(name="cdper_tiempo")
	private CatPerTiempo catPerTiempo;

	//bi-directional many-to-one association to CatPlataforma
	@ManyToOne
	@JoinColumn(name="cdplataforma")
	private CatPlataforma catPlataforma;

	//bi-directional many-to-one association to GodNivelConocHerram
	@ManyToOne
	@JoinColumn(name="cdnivel_conoc_herram")
	private GodNivelConocHerram godNivelConocHerram;

	//bi-directional many-to-one association to GodPeticione
	@ManyToOne
	@JoinColumn(name="cdpeticion", referencedColumnName="cdpeticion", insertable=false, updatable=false)
	private GodPeticiones godPeticione;

	//bi-directional many-to-one association to GodTipoPerfil
	@ManyToOne
	@JoinColumn(name="cdtipo_perfil")
	private GodTipoPerfil godTipoPerfil;

	//bi-directional many-to-one association to GodTipoReqHerram
	@ManyToOne
	@JoinColumn(name="cdtipo_req_herram")
	private GodTipoReqHerram godTipoReqHerram;

	public GodPeticionHerram() {
	}

	public GodPeticionHerramPK getId() {
		return this.id;
	}

	public void setId(GodPeticionHerramPK id) {
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

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public CatHerramienta getCatHerramienta() {
		return this.catHerramienta;
	}

	public void setCatHerramienta(CatHerramienta catHerramienta) {
		this.catHerramienta = catHerramienta;
	}

	public CatPerTiempo getCatPerTiempo() {
		return this.catPerTiempo;
	}

	public void setCatPerTiempo(CatPerTiempo catPerTiempo) {
		this.catPerTiempo = catPerTiempo;
	}

	public CatPlataforma getCatPlataforma() {
		return this.catPlataforma;
	}

	public void setCatPlataforma(CatPlataforma catPlataforma) {
		this.catPlataforma = catPlataforma;
	}

	public GodNivelConocHerram getGodNivelConocHerram() {
		return this.godNivelConocHerram;
	}

	public void setGodNivelConocHerram(GodNivelConocHerram godNivelConocHerram) {
		this.godNivelConocHerram = godNivelConocHerram;
	}

	public GodPeticiones getGodPeticione() {
		return this.godPeticione;
	}

	public void setGodPeticione(GodPeticiones godPeticione) {
		this.godPeticione = godPeticione;
	}

	public GodTipoPerfil getGodTipoPerfil() {
		return this.godTipoPerfil;
	}

	public void setGodTipoPerfil(GodTipoPerfil godTipoPerfil) {
		this.godTipoPerfil = godTipoPerfil;
	}

	public GodTipoReqHerram getGodTipoReqHerram() {
		return this.godTipoReqHerram;
	}

	public void setGodTipoReqHerram(GodTipoReqHerram godTipoReqHerram) {
		this.godTipoReqHerram = godTipoReqHerram;
	}

}