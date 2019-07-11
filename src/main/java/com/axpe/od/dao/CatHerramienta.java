package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_herramientas database table.
 * 
 */
@Entity
@Table(name="cat_herramientas", schema="monolito_god")
@NamedQuery(name="CatHerramienta.findAll", query="SELECT c FROM CatHerramienta c")
public class CatHerramienta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdherramienta;

	private Integer cdusuario;

	private Integer deleted;

	private String dsherramienta;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatTipoHerramienta
	@ManyToOne
	@JoinColumn(name="cdtipo_herram")
	private CatTipoHerramienta catTipoHerramienta;

	//bi-directional many-to-one association to CatTarifa
	@OneToMany(mappedBy="catHerramienta")
	private List<CatTarifa> catTarifas;

	//bi-directional many-to-one association to GodPeticionHerram
	@OneToMany(mappedBy="catHerramienta")
	private List<GodPeticionHerram> godPeticionHerrams;

	//bi-directional many-to-one association to GodProfesHerram
	@OneToMany(mappedBy="catHerramienta")
	private List<GodProfesHerram> godProfesHerrams;

	public CatHerramienta() {
	}

	public Integer getCdherramienta() {
		return this.cdherramienta;
	}

	public void setCdherramienta(Integer cdherramienta) {
		this.cdherramienta = cdherramienta;
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

	public String getDsherramienta() {
		return this.dsherramienta;
	}

	public void setDsherramienta(String dsherramienta) {
		this.dsherramienta = dsherramienta;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public CatTipoHerramienta getCatTipoHerramienta() {
		return this.catTipoHerramienta;
	}

	public void setCatTipoHerramienta(CatTipoHerramienta catTipoHerramienta) {
		this.catTipoHerramienta = catTipoHerramienta;
	}

	public List<CatTarifa> getCatTarifas() {
		return this.catTarifas;
	}

	public void setCatTarifas(List<CatTarifa> catTarifas) {
		this.catTarifas = catTarifas;
	}

	public CatTarifa addCatTarifa(CatTarifa catTarifa) {
		getCatTarifas().add(catTarifa);
		catTarifa.setCatHerramienta(this);

		return catTarifa;
	}

	public CatTarifa removeCatTarifa(CatTarifa catTarifa) {
		getCatTarifas().remove(catTarifa);
		catTarifa.setCatHerramienta(null);

		return catTarifa;
	}

	public List<GodPeticionHerram> getGodPeticionHerrams() {
		return this.godPeticionHerrams;
	}

	public void setGodPeticionHerrams(List<GodPeticionHerram> godPeticionHerrams) {
		this.godPeticionHerrams = godPeticionHerrams;
	}

	public GodPeticionHerram addGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().add(godPeticionHerram);
		godPeticionHerram.setCatHerramienta(this);

		return godPeticionHerram;
	}

	public GodPeticionHerram removeGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().remove(godPeticionHerram);
		godPeticionHerram.setCatHerramienta(null);

		return godPeticionHerram;
	}

	public List<GodProfesHerram> getGodProfesHerrams() {
		return this.godProfesHerrams;
	}

	public void setGodProfesHerrams(List<GodProfesHerram> godProfesHerrams) {
		this.godProfesHerrams = godProfesHerrams;
	}

	public GodProfesHerram addGodProfesHerram(GodProfesHerram godProfesHerram) {
		getGodProfesHerrams().add(godProfesHerram);
		godProfesHerram.setCatHerramienta(this);

		return godProfesHerram;
	}

	public GodProfesHerram removeGodProfesHerram(GodProfesHerram godProfesHerram) {
		getGodProfesHerrams().remove(godProfesHerram);
		godProfesHerram.setCatHerramienta(null);

		return godProfesHerram;
	}

}