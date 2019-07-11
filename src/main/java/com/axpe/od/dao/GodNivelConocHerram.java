package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the god_nivel_conoc_herram database table.
 * 
 */
@Entity
@Table(name="god_nivel_conoc_herram", schema="monolito_god")
@NamedQuery(name="GodNivelConocHerram.findAll", query="SELECT g FROM GodNivelConocHerram g")
public class GodNivelConocHerram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdnivel_conoc_herram")
	private Integer cdnivelConocHerram;

	private Integer cdusuario;

	private Integer deleted;

	private String dsayuda;

	@Column(name="dsnivel_conoc_herram")
	private String dsnivelConocHerram;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to GodPeticionHerram
	@OneToMany(mappedBy="godNivelConocHerram")
	private List<GodPeticionHerram> godPeticionHerrams;

	public GodNivelConocHerram() {
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

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getDsayuda() {
		return this.dsayuda;
	}

	public void setDsayuda(String dsayuda) {
		this.dsayuda = dsayuda;
	}

	public String getDsnivelConocHerram() {
		return this.dsnivelConocHerram;
	}

	public void setDsnivelConocHerram(String dsnivelConocHerram) {
		this.dsnivelConocHerram = dsnivelConocHerram;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<GodPeticionHerram> getGodPeticionHerrams() {
		return this.godPeticionHerrams;
	}

	public void setGodPeticionHerrams(List<GodPeticionHerram> godPeticionHerrams) {
		this.godPeticionHerrams = godPeticionHerrams;
	}

	public GodPeticionHerram addGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().add(godPeticionHerram);
		godPeticionHerram.setGodNivelConocHerram(this);

		return godPeticionHerram;
	}

	public GodPeticionHerram removeGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().remove(godPeticionHerram);
		godPeticionHerram.setGodNivelConocHerram(null);

		return godPeticionHerram;
	}

}