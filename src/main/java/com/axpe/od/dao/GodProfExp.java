package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_prof_exp database table.
 * 
 */
@Entity
@Table(name="god_prof_exp", schema = "monolito_god")
@NamedQuery(name="GodProfExp.findAll", query="SELECT g FROM GodProfExp g")
public class GodProfExp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdprof_exp")
	private Integer cdprofExp;

	private Integer cdusuario;

	private String cliente;

	private String comentarios;

	private Integer deleted;

	private Timestamp fcmodificacion;

	private Boolean stillthere;

	@Column(name="fecha_desde")
	private Timestamp fechaDesde;

	@Column(name="fecha_hasta")
	private Timestamp fechaHasta;

	//bi-directional many-to-one association to CatCategoria
	@ManyToOne
	@JoinColumn(name="cdcategoria")
	private CatCategoria catCategoria;

	//bi-directional many-to-one association to GodProfesionale
	@ManyToOne
	@JoinColumn(name="cdprofesional")
	private GodProfesionale godProfesionale;

	public GodProfExp() {
	}

	public Integer getCdprofExp() {
		return this.cdprofExp;
	}

	public void setCdprofExp(Integer cdprofExp) {
		this.cdprofExp = cdprofExp;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public Boolean getStillthere() {
		return stillthere;
	}

	public void setStillthere(Boolean stillthere) {
		this.stillthere = stillthere;
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

	public Timestamp getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Timestamp fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Timestamp getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Timestamp fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public CatCategoria getCatCategoria() {
		return this.catCategoria;
	}

	public void setCatCategoria(CatCategoria catCategoria) {
		this.catCategoria = catCategoria;
	}

	public GodProfesionale getGodProfesionale() {
		return this.godProfesionale;
	}

	public void setGodProfesionale(GodProfesionale godProfesionale) {
		this.godProfesionale = godProfesionale;
	}

}