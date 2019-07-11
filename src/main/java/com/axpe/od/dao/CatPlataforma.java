package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_plataforma database table.
 * 
 */
@Entity
@Table(name="cat_plataforma", schema="monolito_god")
@NamedQuery(name="CatPlataforma.findAll", query="SELECT c FROM CatPlataforma c")
public class CatPlataforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdplataforma;

	private Integer cdusuario;

	private String dsplataforma;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to GodPeticionHerram
	@OneToMany(mappedBy="catPlataforma")
	private List<GodPeticionHerram> godPeticionHerrams;

	//bi-directional many-to-one association to GodProfesHerram
	@OneToMany(mappedBy="catPlataforma")
	private List<GodProfesHerram> godProfesHerrams;

	public CatPlataforma() {
	}

	public Integer getCdplataforma() {
		return this.cdplataforma;
	}

	public void setCdplataforma(Integer cdplataforma) {
		this.cdplataforma = cdplataforma;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsplataforma() {
		return this.dsplataforma;
	}

	public void setDsplataforma(String dsplataforma) {
		this.dsplataforma = dsplataforma;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public List<GodPeticionHerram> getGodPeticionHerrams() {
		return this.godPeticionHerrams;
	}

	public void setGodPeticionHerrams(List<GodPeticionHerram> godPeticionHerrams) {
		this.godPeticionHerrams = godPeticionHerrams;
	}

	public GodPeticionHerram addGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().add(godPeticionHerram);
		godPeticionHerram.setCatPlataforma(this);

		return godPeticionHerram;
	}

	public GodPeticionHerram removeGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().remove(godPeticionHerram);
		godPeticionHerram.setCatPlataforma(null);

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
		godProfesHerram.setCatPlataforma(this);

		return godProfesHerram;
	}

	public GodProfesHerram removeGodProfesHerram(GodProfesHerram godProfesHerram) {
		getGodProfesHerrams().remove(godProfesHerram);
		godProfesHerram.setCatPlataforma(null);

		return godProfesHerram;
	}

}