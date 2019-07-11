package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_tipo_titulacion database table.
 * 
 */
@Entity
@Table(name="cat_tipo_titulacion", schema="monolito_god")
@NamedQuery(name="CatTipoTitulacion.findAll", query="SELECT c FROM CatTipoTitulacion c")
public class CatTipoTitulacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_titulacion")
	private Integer cdtipoTitulacion;

	private Integer cdusuario;

	@Column(name="dstipo_titulacion")
	private String dstipoTitulacion;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatTitulacione
	@OneToMany(mappedBy="catTipoTitulacion")
	private List<CatTitulacione> catTitulaciones;

	public CatTipoTitulacion() {
	}

	public Integer getCdtipoTitulacion() {
		return this.cdtipoTitulacion;
	}

	public void setCdtipoTitulacion(Integer cdtipoTitulacion) {
		this.cdtipoTitulacion = cdtipoTitulacion;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoTitulacion() {
		return this.dstipoTitulacion;
	}

	public void setDstipoTitulacion(String dstipoTitulacion) {
		this.dstipoTitulacion = dstipoTitulacion;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<CatTitulacione> getCatTitulaciones() {
		return this.catTitulaciones;
	}

	public void setCatTitulaciones(List<CatTitulacione> catTitulaciones) {
		this.catTitulaciones = catTitulaciones;
	}

	public CatTitulacione addCatTitulacione(CatTitulacione catTitulacione) {
		getCatTitulaciones().add(catTitulacione);
		catTitulacione.setCatTipoTitulacion(this);

		return catTitulacione;
	}

	public CatTitulacione removeCatTitulacione(CatTitulacione catTitulacione) {
		getCatTitulaciones().remove(catTitulacione);
		catTitulacione.setCatTipoTitulacion(null);

		return catTitulacione;
	}

}