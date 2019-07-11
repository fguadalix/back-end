package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_profes_herram database table.
 * 
 */
@Entity
@Table(name="god_profes_herram")
@NamedQuery(name="GodProfesHerram.findAll", query="SELECT g FROM GodProfesHerram g")
public class GodProfesHerram implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GodProfesHerramPK id;

	@Column(name="cdnivel_conoc_herram")
	private Integer cdnivelConocHerram;

	private Integer cdusuario;

	private String comentarios;

	private Integer deleted;

	private Timestamp fcmodificacion;

	private Timestamp fcultima;

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

	//bi-directional many-to-one association to GodProfesionale
	@ManyToOne
	@JoinColumn(name="cdprofesional", referencedColumnName="cdprofesional", insertable=false, updatable=false)
	private GodProfesionale godProfesionale;

	//bi-directional many-to-one association to GodTipoPerfil
	@ManyToOne
	@JoinColumn(name="cdtipo_perfil")
	private GodTipoPerfil godTipoPerfil;

	public GodProfesHerram() {
	}

	public GodProfesHerramPK getId() {
		return this.id;
	}

	public void setId(GodProfesHerramPK id) {
		this.id = id;
	}

	public Integer getCdnivelConocHerram() {
		return this.cdnivelConocHerram;
	}

	public void setCdnivelConocHerram(Integer cdnivelConocHerram) {
		this.cdnivelConocHerram = cdnivelConocHerram;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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

	public Timestamp getFcultima() {
		return this.fcultima;
	}

	public void setFcultima(Timestamp fcultima) {
		this.fcultima = fcultima;
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

	public GodProfesionale getGodProfesionale() {
		return this.godProfesionale;
	}

	public void setGodProfesionale(GodProfesionale godProfesionale) {
		this.godProfesionale = godProfesionale;
	}

	public GodTipoPerfil getGodTipoPerfil() {
		return this.godTipoPerfil;
	}

	public void setGodTipoPerfil(GodTipoPerfil godTipoPerfil) {
		this.godTipoPerfil = godTipoPerfil;
	}

}