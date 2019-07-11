package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_prioridad database table.
 * 
 */
@Entity
@Table(name="cat_prioridad", schema="monolito_god")
@NamedQuery(name="CatPrioridad.findAll", query="SELECT c FROM CatPrioridad c")
public class CatPrioridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdprioridad;

	private Integer cdusuario;

	private String dsprioridad;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to GodPeticione
	@OneToMany(mappedBy="catPrioridad")
	private List<GodPeticiones> godPeticiones;

	public CatPrioridad() {
	}

	public Integer getCdprioridad() {
		return this.cdprioridad;
	}

	public void setCdprioridad(Integer cdprioridad) {
		this.cdprioridad = cdprioridad;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsprioridad() {
		return this.dsprioridad;
	}

	public void setDsprioridad(String dsprioridad) {
		this.dsprioridad = dsprioridad;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public List<GodPeticiones> getGodPeticiones() {
		return this.godPeticiones;
	}

	public void setGodPeticiones(List<GodPeticiones> godPeticiones) {
		this.godPeticiones = godPeticiones;
	}

	public GodPeticiones addGodPeticione(GodPeticiones godPeticione) {
		getGodPeticiones().add(godPeticione);
		godPeticione.setCatPrioridad(this);

		return godPeticione;
	}

	public GodPeticiones removeGodPeticione(GodPeticiones godPeticione) {
		getGodPeticiones().remove(godPeticione);
		godPeticione.setCatPrioridad(null);

		return godPeticione;
	}

}