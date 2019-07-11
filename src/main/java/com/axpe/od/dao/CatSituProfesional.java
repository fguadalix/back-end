package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_situ_profesional database table.
 * 
 */
@Entity
@Table(name="cat_situ_profesional", schema="monolito_god")
@NamedQuery(name="CatSituProfesional.findAll", query="SELECT c FROM CatSituProfesional c")
public class CatSituProfesional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdsitu_prof")
	private Integer cdsituProf;

	private Integer cdusuario;

	@Column(name="dssitu_prof")
	private String dssituProf;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to GodHContacto
	@OneToMany(mappedBy="catSituProfesional")
	private List<GodHContacto> godHContactos;

	//bi-directional many-to-one association to GodProfesionalesInfojob
	@OneToMany(mappedBy="catSituProfesional")
	private List<GodProfesionalesInfojob> godProfesionalesInfojobs;

	public CatSituProfesional() {
	}

	public Integer getCdsituProf() {
		return this.cdsituProf;
	}

	public void setCdsituProf(Integer cdsituProf) {
		this.cdsituProf = cdsituProf;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDssituProf() {
		return this.dssituProf;
	}

	public void setDssituProf(String dssituProf) {
		this.dssituProf = dssituProf;
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
		godHContacto.setCatSituProfesional(this);

		return godHContacto;
	}

	public GodHContacto removeGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().remove(godHContacto);
		godHContacto.setCatSituProfesional(null);

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
		godProfesionalesInfojob.setCatSituProfesional(this);

		return godProfesionalesInfojob;
	}

	public GodProfesionalesInfojob removeGodProfesionalesInfojob(GodProfesionalesInfojob godProfesionalesInfojob) {
		getGodProfesionalesInfojobs().remove(godProfesionalesInfojob);
		godProfesionalesInfojob.setCatSituProfesional(null);

		return godProfesionalesInfojob;
	}

}