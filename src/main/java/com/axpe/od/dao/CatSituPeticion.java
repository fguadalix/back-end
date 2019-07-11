package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_situ_peticion database table.
 * 
 */
@Entity
@Table(name="cat_situ_peticion", schema="monolito_god")
@NamedQuery(name="CatSituPeticion.findAll", query="SELECT c FROM CatSituPeticion c")
public class CatSituPeticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdsitu_peti")
	private Integer cdsituPeti;

	private Integer cdusuario;

	@Column(name="dssitu_peti")
	private String dssituPeti;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to GodPeticione
	@OneToMany(mappedBy="catSituPeticion")
	private List<GodPeticiones> godPeticiones;

	//bi-directional many-to-one association to GodTrazaEstadoPet
	@OneToMany(mappedBy="catSituPeticion")
	private List<GodTrazaEstadoPet> godTrazaEstadoPets;

	public CatSituPeticion() {
	}

	public Integer getCdsituPeti() {
		return this.cdsituPeti;
	}

	public void setCdsituPeti(Integer cdsituPeti) {
		this.cdsituPeti = cdsituPeti;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDssituPeti() {
		return this.dssituPeti;
	}

	public void setDssituPeti(String dssituPeti) {
		this.dssituPeti = dssituPeti;
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
		godPeticione.setCatSituPeticion(this);

		return godPeticione;
	}

	public GodPeticiones removeGodPeticione(GodPeticiones godPeticione) {
		getGodPeticiones().remove(godPeticione);
		godPeticione.setCatSituPeticion(null);

		return godPeticione;
	}

	public List<GodTrazaEstadoPet> getGodTrazaEstadoPets() {
		return this.godTrazaEstadoPets;
	}

	public void setGodTrazaEstadoPets(List<GodTrazaEstadoPet> godTrazaEstadoPets) {
		this.godTrazaEstadoPets = godTrazaEstadoPets;
	}

	public GodTrazaEstadoPet addGodTrazaEstadoPet(GodTrazaEstadoPet godTrazaEstadoPet) {
		getGodTrazaEstadoPets().add(godTrazaEstadoPet);
		godTrazaEstadoPet.setCatSituPeticion(this);

		return godTrazaEstadoPet;
	}

	public GodTrazaEstadoPet removeGodTrazaEstadoPet(GodTrazaEstadoPet godTrazaEstadoPet) {
		getGodTrazaEstadoPets().remove(godTrazaEstadoPet);
		godTrazaEstadoPet.setCatSituPeticion(null);

		return godTrazaEstadoPet;
	}

}