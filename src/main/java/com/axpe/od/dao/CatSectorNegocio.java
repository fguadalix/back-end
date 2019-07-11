package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_sector_negocio database table.
 * 
 */
@Entity
@Table(name="cat_sector_negocio", schema="monolito_god")
@NamedQuery(name="CatSectorNegocio.findAll", query="SELECT c FROM CatSectorNegocio c")
public class CatSectorNegocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdsectorn;

	private Integer cdusuario;

	@Column(name="codsectorn", columnDefinition="bpchar(2)")
	private String codsectorn;

	private String dssectorn;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatActividadNegocio
	@OneToMany(mappedBy="catSectorNegocio")
	private List<CatActividadNegocio> catActividadNegocios;

	public CatSectorNegocio() {
	}

	public Integer getCdsectorn() {
		return this.cdsectorn;
	}

	public void setCdsectorn(Integer cdsectorn) {
		this.cdsectorn = cdsectorn;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getCodsectorn() {
		return this.codsectorn;
	}

	public void setCodsectorn(String codsectorn) {
		this.codsectorn = codsectorn;
	}

	public String getDssectorn() {
		return this.dssectorn;
	}

	public void setDssectorn(String dssectorn) {
		this.dssectorn = dssectorn;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<CatActividadNegocio> getCatActividadNegocios() {
		return this.catActividadNegocios;
	}

	public void setCatActividadNegocios(List<CatActividadNegocio> catActividadNegocios) {
		this.catActividadNegocios = catActividadNegocios;
	}

	public CatActividadNegocio addCatActividadNegocio(CatActividadNegocio catActividadNegocio) {
		getCatActividadNegocios().add(catActividadNegocio);
		catActividadNegocio.setCatSectorNegocio(this);

		return catActividadNegocio;
	}

	public CatActividadNegocio removeCatActividadNegocio(CatActividadNegocio catActividadNegocio) {
		getCatActividadNegocios().remove(catActividadNegocio);
		catActividadNegocio.setCatSectorNegocio(null);

		return catActividadNegocio;
	}

}