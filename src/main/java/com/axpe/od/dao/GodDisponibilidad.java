package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the god_disponibilidad database table.
 * 
 */
@Entity
@Table(name="god_disponibilidad", schema="monolito_god")
@NamedQuery(name="GodDisponibilidad.findAll", query="SELECT g FROM GodDisponibilidad g")
public class GodDisponibilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cddisponibilidad;

	private Integer cdusuario;

	private Integer deleted;

	private String dsdisponibilidad;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to GodHContacto
	@OneToMany(mappedBy="godDisponibilidad")
	private List<GodHContacto> godHContactos;

	//bi-directional many-to-one association to GodProfesionalesInfojob
	@OneToMany(mappedBy="godDisponibilidad")
	private List<GodProfesionalesInfojob> godProfesionalesInfojobs;

	public GodDisponibilidad() {
	}

	public Integer getCddisponibilidad() {
		return this.cddisponibilidad;
	}

	public void setCddisponibilidad(Integer cddisponibilidad) {
		this.cddisponibilidad = cddisponibilidad;
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

	public String getDsdisponibilidad() {
		return this.dsdisponibilidad;
	}

	public void setDsdisponibilidad(String dsdisponibilidad) {
		this.dsdisponibilidad = dsdisponibilidad;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<GodHContacto> getGodHContactos() {
		return this.godHContactos;
	}

	public void setGodHContactos(List<GodHContacto> godHContactos) {
		this.godHContactos = godHContactos;
	}

	public GodHContacto addGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().add(godHContacto);
		godHContacto.setGodDisponibilidad(this);

		return godHContacto;
	}

	public GodHContacto removeGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().remove(godHContacto);
		godHContacto.setGodDisponibilidad(null);

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
		godProfesionalesInfojob.setGodDisponibilidad(this);

		return godProfesionalesInfojob;
	}

	public GodProfesionalesInfojob removeGodProfesionalesInfojob(GodProfesionalesInfojob godProfesionalesInfojob) {
		getGodProfesionalesInfojobs().remove(godProfesionalesInfojob);
		godProfesionalesInfojob.setGodDisponibilidad(null);

		return godProfesionalesInfojob;
	}

}