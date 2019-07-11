package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_provincias database table.
 * 
 */
@Entity
@Table(name="cat_provincias", schema="monolito_god")
@NamedQuery(name="CatProvincia.findAll", query="SELECT c FROM CatProvincia c")
public class CatProvincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdprovincia;

	private Integer cdusuario;

	private Integer codprovincia;

	private String dsprovincia;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatEmprColab
	@OneToMany(mappedBy="catProvincia")
	private List<CatEmprColab> catEmprColabs;

	//bi-directional many-to-one association to CatEmprGrupo
	@OneToMany(mappedBy="catProvincia")
	private List<CatEmprGrupo> catEmprGrupos;

	//bi-directional many-to-one association to CatPais
	@ManyToOne
	@JoinColumn(name="cdpais")
	private CatPais catPais;

	//bi-directional many-to-one association to GodProfesionalesInfojob
	@OneToMany(mappedBy="catProvincia")
	private List<GodProfesionalesInfojob> godProfesionalesInfojobs;

	public CatProvincia() {
	}

	public Integer getCdprovincia() {
		return this.cdprovincia;
	}

	public void setCdprovincia(Integer cdprovincia) {
		this.cdprovincia = cdprovincia;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getCodprovincia() {
		return this.codprovincia;
	}

	public void setCodprovincia(Integer codprovincia) {
		this.codprovincia = codprovincia;
	}

	public String getDsprovincia() {
		return this.dsprovincia;
	}

	public void setDsprovincia(String dsprovincia) {
		this.dsprovincia = dsprovincia;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<CatEmprColab> getCatEmprColabs() {
		return this.catEmprColabs;
	}

	public void setCatEmprColabs(List<CatEmprColab> catEmprColabs) {
		this.catEmprColabs = catEmprColabs;
	}

	public CatEmprColab addCatEmprColab(CatEmprColab catEmprColab) {
		getCatEmprColabs().add(catEmprColab);
		catEmprColab.setCatProvincia(this);

		return catEmprColab;
	}

	public CatEmprColab removeCatEmprColab(CatEmprColab catEmprColab) {
		getCatEmprColabs().remove(catEmprColab);
		catEmprColab.setCatProvincia(null);

		return catEmprColab;
	}

	public List<CatEmprGrupo> getCatEmprGrupos() {
		return this.catEmprGrupos;
	}

	public void setCatEmprGrupos(List<CatEmprGrupo> catEmprGrupos) {
		this.catEmprGrupos = catEmprGrupos;
	}

	public CatEmprGrupo addCatEmprGrupo(CatEmprGrupo catEmprGrupo) {
		getCatEmprGrupos().add(catEmprGrupo);
		catEmprGrupo.setCatProvincia(this);

		return catEmprGrupo;
	}

	public CatEmprGrupo removeCatEmprGrupo(CatEmprGrupo catEmprGrupo) {
		getCatEmprGrupos().remove(catEmprGrupo);
		catEmprGrupo.setCatProvincia(null);

		return catEmprGrupo;
	}

	public CatPais getCatPais() {
		return this.catPais;
	}

	public void setCatPais(CatPais catPais) {
		this.catPais = catPais;
	}

	public List<GodProfesionalesInfojob> getGodProfesionalesInfojobs() {
		return this.godProfesionalesInfojobs;
	}

	public void setGodProfesionalesInfojobs(List<GodProfesionalesInfojob> godProfesionalesInfojobs) {
		this.godProfesionalesInfojobs = godProfesionalesInfojobs;
	}

	public GodProfesionalesInfojob addGodProfesionalesInfojob(GodProfesionalesInfojob godProfesionalesInfojob) {
		getGodProfesionalesInfojobs().add(godProfesionalesInfojob);
		godProfesionalesInfojob.setCatProvincia(this);

		return godProfesionalesInfojob;
	}

	public GodProfesionalesInfojob removeGodProfesionalesInfojob(GodProfesionalesInfojob godProfesionalesInfojob) {
		getGodProfesionalesInfojobs().remove(godProfesionalesInfojob);
		godProfesionalesInfojob.setCatProvincia(null);

		return godProfesionalesInfojob;
	}

}