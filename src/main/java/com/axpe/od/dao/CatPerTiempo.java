package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_per_tiempos database table.
 * 
 */
@Entity
@Table(name="cat_per_tiempos", schema="monolito_god")
@NamedQuery(name="CatPerTiempo.findAll", query="SELECT c FROM CatPerTiempo c")
public class CatPerTiempo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdper_tiempo")
	private Integer cdperTiempo;

	private Integer cdusuario;

	@Column(name="dias_lim_inf")
	private Integer diasLimInf;

	@Column(name="dias_lim_sup")
	private Integer diasLimSup;

	@Column(name="dsper_tiempo")
	private String dsperTiempo;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to GodPeticionHerram
	@OneToMany(mappedBy="catPerTiempo")
	private List<GodPeticionHerram> godPeticionHerrams;

	//bi-directional many-to-one association to GodProfesHerram
	@OneToMany(mappedBy="catPerTiempo")
	private List<GodProfesHerram> godProfesHerrams;

	public CatPerTiempo() {
	}

	public Integer getCdperTiempo() {
		return this.cdperTiempo;
	}

	public void setCdperTiempo(Integer cdperTiempo) {
		this.cdperTiempo = cdperTiempo;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getDiasLimInf() {
		return this.diasLimInf;
	}

	public void setDiasLimInf(Integer diasLimInf) {
		this.diasLimInf = diasLimInf;
	}

	public Integer getDiasLimSup() {
		return this.diasLimSup;
	}

	public void setDiasLimSup(Integer diasLimSup) {
		this.diasLimSup = diasLimSup;
	}

	public String getDsperTiempo() {
		return this.dsperTiempo;
	}

	public void setDsperTiempo(String dsperTiempo) {
		this.dsperTiempo = dsperTiempo;
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
		godPeticionHerram.setCatPerTiempo(this);

		return godPeticionHerram;
	}

	public GodPeticionHerram removeGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().remove(godPeticionHerram);
		godPeticionHerram.setCatPerTiempo(null);

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
		godProfesHerram.setCatPerTiempo(this);

		return godProfesHerram;
	}

	public GodProfesHerram removeGodProfesHerram(GodProfesHerram godProfesHerram) {
		getGodProfesHerrams().remove(godProfesHerram);
		godProfesHerram.setCatPerTiempo(null);

		return godProfesHerram;
	}

}