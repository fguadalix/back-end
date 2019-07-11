package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_valoracion database table.
 * 
 */
@Entity
@Table(name="cat_valoracion", schema="monolito_god")
@NamedQuery(name="CatValoracion.findAll", query="SELECT c FROM CatValoracion c")
public class CatValoracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdvaloracion;

	private Integer cdusuario;

	private String dsvaloracion;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to GodHContacto
	@OneToMany(mappedBy="catValoracion")
	private List<GodHContacto> godHContactos;

	//bi-directional many-to-one association to GodProfesionalesInfojob
	@OneToMany(mappedBy="catValoracion")
	private List<GodProfesionalesInfojob> godProfesionalesInfojobs;

	public CatValoracion() {
	}

	public Integer getCdvaloracion() {
		return this.cdvaloracion;
	}

	public void setCdvaloracion(Integer cdvaloracion) {
		this.cdvaloracion = cdvaloracion;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsvaloracion() {
		return this.dsvaloracion;
	}

	public void setDsvaloracion(String dsvaloracion) {
		this.dsvaloracion = dsvaloracion;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public List<GodHContacto> getGodHContactos() {
		return this.godHContactos;
	}

	public void setGodHContactos(List<GodHContacto> godHContactos) {
		this.godHContactos = godHContactos;
	}

	public GodHContacto addGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().add(godHContacto);
		godHContacto.setCatValoracion(this);

		return godHContacto;
	}

	public GodHContacto removeGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().remove(godHContacto);
		godHContacto.setCatValoracion(null);

		return godHContacto;
	}

	public List<GodProfesionalesInfojob> getGodProfesionalesInfojobs() {
		return this.godProfesionalesInfojobs;
	}

	public void setGodProfesionalesInfojobs(List<GodProfesionalesInfojob> godProfesionalesInfojobs) {
		this.godProfesionalesInfojobs = godProfesionalesInfojobs;
	}

	public GodProfesionalesInfojob addGodProfesionalesInfojob(GodProfesionalesInfojob godProfesionalesInfojob) {
		getGodProfesionalesInfojobs().add(godProfesionalesInfojob);
		godProfesionalesInfojob.setCatValoracion(this);

		return godProfesionalesInfojob;
	}

	public GodProfesionalesInfojob removeGodProfesionalesInfojob(GodProfesionalesInfojob godProfesionalesInfojob) {
		getGodProfesionalesInfojobs().remove(godProfesionalesInfojob);
		godProfesionalesInfojob.setCatValoracion(null);

		return godProfesionalesInfojob;
	}

}