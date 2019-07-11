package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_categorias database table.
 * 
 */
@Entity
@Table(name="cat_categorias", schema="monolito_god")
@NamedQuery(name="CatCategoria.findAll", query="SELECT c FROM CatCategoria c")
public class CatCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdcategoria;

	private Integer cdusuario;

	private Integer codcategoria;

	private Integer deleted;

	private String dscategoria;

	private Timestamp femodificacion;

	private String idconvenio;

	//bi-directional many-to-one association to CatTarifa
	@OneToMany(mappedBy="catCategoria")
	private List<CatTarifa> catTarifas;

	//bi-directional many-to-one association to GodPeticione
	@OneToMany(mappedBy="catCategoria")
	private List<GodPeticiones> godPeticiones;

	//bi-directional many-to-one association to GodProfExp
	@OneToMany(mappedBy="catCategoria")
	private List<GodProfExp> godProfExps;

	//bi-directional many-to-one association to GodProfesionalesInfojob
	@OneToMany(mappedBy="catCategoria")
	private List<GodProfesionalesInfojob> godProfesionalesInfojobs;

	public CatCategoria() {
	}

	public Integer getCdcategoria() {
		return this.cdcategoria;
	}

	public void setCdcategoria(Integer cdcategoria) {
		this.cdcategoria = cdcategoria;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getCodcategoria() {
		return this.codcategoria;
	}

	public void setCodcategoria(Integer codcategoria) {
		this.codcategoria = codcategoria;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getDscategoria() {
		return this.dscategoria;
	}

	public void setDscategoria(String dscategoria) {
		this.dscategoria = dscategoria;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public String getIdconvenio() {
		return this.idconvenio;
	}

	public void setIdconvenio(String idconvenio) {
		this.idconvenio = idconvenio;
	}

	public List<CatTarifa> getCatTarifas() {
		return this.catTarifas;
	}

	public void setCatTarifas(List<CatTarifa> catTarifas) {
		this.catTarifas = catTarifas;
	}

	public CatTarifa addCatTarifa(CatTarifa catTarifa) {
		getCatTarifas().add(catTarifa);
		catTarifa.setCatCategoria(this);

		return catTarifa;
	}

	public CatTarifa removeCatTarifa(CatTarifa catTarifa) {
		getCatTarifas().remove(catTarifa);
		catTarifa.setCatCategoria(null);

		return catTarifa;
	}

	public List<GodPeticiones> getGodPeticiones() {
		return this.godPeticiones;
	}

	public void setGodPeticiones(List<GodPeticiones> godPeticiones) {
		this.godPeticiones = godPeticiones;
	}

	public GodPeticiones addGodPeticione(GodPeticiones godPeticione) {
		getGodPeticiones().add(godPeticione);
		godPeticione.setCatCategoria(this);

		return godPeticione;
	}

	public GodPeticiones removeGodPeticione(GodPeticiones godPeticione) {
		getGodPeticiones().remove(godPeticione);
		godPeticione.setCatCategoria(null);

		return godPeticione;
	}

	public List<GodProfExp> getGodProfExps() {
		return this.godProfExps;
	}

	public void setGodProfExps(List<GodProfExp> godProfExps) {
		this.godProfExps = godProfExps;
	}

	public GodProfExp addGodProfExp(GodProfExp godProfExp) {
		getGodProfExps().add(godProfExp);
		godProfExp.setCatCategoria(this);

		return godProfExp;
	}

	public GodProfExp removeGodProfExp(GodProfExp godProfExp) {
		getGodProfExps().remove(godProfExp);
		godProfExp.setCatCategoria(null);

		return godProfExp;
	}

	public List<GodProfesionalesInfojob> getGodProfesionalesInfojobs() {
		return this.godProfesionalesInfojobs;
	}

	public void setGodProfesionalesInfojobs(List<GodProfesionalesInfojob> godProfesionalesInfojobs) {
		this.godProfesionalesInfojobs = godProfesionalesInfojobs;
	}

	public GodProfesionalesInfojob addGodProfesionalesInfojob(GodProfesionalesInfojob godProfesionalesInfojob) {
		getGodProfesionalesInfojobs().add(godProfesionalesInfojob);
		godProfesionalesInfojob.setCatCategoria(this);

		return godProfesionalesInfojob;
	}

	public GodProfesionalesInfojob removeGodProfesionalesInfojob(GodProfesionalesInfojob godProfesionalesInfojob) {
		getGodProfesionalesInfojobs().remove(godProfesionalesInfojob);
		godProfesionalesInfojob.setCatCategoria(null);

		return godProfesionalesInfojob;
	}

}