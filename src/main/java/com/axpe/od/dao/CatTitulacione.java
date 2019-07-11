package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_titulaciones database table.
 * 
 */
@Entity
@Table(name="cat_titulaciones", schema="monolito_god")
@NamedQuery(name="CatTitulacione.findAll", query="SELECT c FROM CatTitulacione c")
public class CatTitulacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdtitulacion;

	private Integer cdusuario;

	private Timestamp femodificacion;

	private String titulacion;

	//bi-directional many-to-one association to CatTipoTitulacion
	@ManyToOne
	@JoinColumn(name="cdtipo_titulacion")
	private CatTipoTitulacion catTipoTitulacion;

	//bi-directional many-to-one association to GodPetiTitulacione
	@OneToMany(mappedBy="catTitulacione")
	private List<GodPetiTitulacione> godPetiTitulaciones;

	public CatTitulacione() {
	}

	public Integer getCdtitulacion() {
		return this.cdtitulacion;
	}

	public void setCdtitulacion(Integer cdtitulacion) {
		this.cdtitulacion = cdtitulacion;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public String getTitulacion() {
		return this.titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public CatTipoTitulacion getCatTipoTitulacion() {
		return this.catTipoTitulacion;
	}

	public void setCatTipoTitulacion(CatTipoTitulacion catTipoTitulacion) {
		this.catTipoTitulacion = catTipoTitulacion;
	}

	public List<GodPetiTitulacione> getGodPetiTitulaciones() {
		return this.godPetiTitulaciones;
	}

	public void setGodPetiTitulaciones(List<GodPetiTitulacione> godPetiTitulaciones) {
		this.godPetiTitulaciones = godPetiTitulaciones;
	}

	public GodPetiTitulacione addGodPetiTitulacione(GodPetiTitulacione godPetiTitulacione) {
		getGodPetiTitulaciones().add(godPetiTitulacione);
		godPetiTitulacione.setCatTitulacione(this);

		return godPetiTitulacione;
	}

	public GodPetiTitulacione removeGodPetiTitulacione(GodPetiTitulacione godPetiTitulacione) {
		getGodPetiTitulaciones().remove(godPetiTitulacione);
		godPetiTitulacione.setCatTitulacione(null);

		return godPetiTitulacione;
	}

}