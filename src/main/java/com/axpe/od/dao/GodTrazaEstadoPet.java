package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_traza_estado_pet database table.
 * 
 */
@Entity
@Table(name="god_traza_estado_pet")
@NamedQuery(name="GodTrazaEstadoPet.findAll", query="SELECT g FROM GodTrazaEstadoPet g")
public class GodTrazaEstadoPet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtraza_situ_peti")
	private Integer cdtrazaSituPeti;

	private String comentarios;

	private Integer deleted;

	private Timestamp festado;

	//bi-directional many-to-one association to CatSituPeticion
	@ManyToOne
	@JoinColumn(name="cdsitu_peticion")
	private CatSituPeticion catSituPeticion;

	//bi-directional many-to-one association to GodPeticione
	@ManyToOne
	@JoinColumn(name="cdpeticion")
	private GodPeticiones godPeticione;

	public GodTrazaEstadoPet() {
	}

	public Integer getCdtrazaSituPeti() {
		return this.cdtrazaSituPeti;
	}

	public void setCdtrazaSituPeti(Integer cdtrazaSituPeti) {
		this.cdtrazaSituPeti = cdtrazaSituPeti;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Timestamp getFestado() {
		return this.festado;
	}

	public void setFestado(Timestamp festado) {
		this.festado = festado;
	}

	public CatSituPeticion getCatSituPeticion() {
		return this.catSituPeticion;
	}

	public void setCatSituPeticion(CatSituPeticion catSituPeticion) {
		this.catSituPeticion = catSituPeticion;
	}

	public GodPeticiones getGodPeticione() {
		return this.godPeticione;
	}

	public void setGodPeticione(GodPeticiones godPeticione) {
		this.godPeticione = godPeticione;
	}

}