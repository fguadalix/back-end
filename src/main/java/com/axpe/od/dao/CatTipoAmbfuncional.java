package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_tipo_ambfuncional database table.
 * 
 */
@Entity
@Table(name="cat_tipo_ambfuncional",schema="monolito_god")
@NamedQuery(name="CatTipoAmbfuncional.findAll", query="SELECT c FROM CatTipoAmbfuncional c")
public class CatTipoAmbfuncional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_ambfuncional")
	private Integer cdtipoAmbfuncional;

	private Integer cdusuario;

	@Column(name="dstipo_ambfuncional")
	private String dstipoAmbfuncional;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatAmbfuncional
	@OneToMany(mappedBy="catTipoAmbfuncional")
	private List<CatAmbfuncional> catAmbfuncionals;

	public CatTipoAmbfuncional() {
	}

	public Integer getCdtipoAmbfuncional() {
		return this.cdtipoAmbfuncional;
	}

	public void setCdtipoAmbfuncional(Integer cdtipoAmbfuncional) {
		this.cdtipoAmbfuncional = cdtipoAmbfuncional;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoAmbfuncional() {
		return this.dstipoAmbfuncional;
	}

	public void setDstipoAmbfuncional(String dstipoAmbfuncional) {
		this.dstipoAmbfuncional = dstipoAmbfuncional;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<CatAmbfuncional> getCatAmbfuncionals() {
		return this.catAmbfuncionals;
	}

	public void setCatAmbfuncionals(List<CatAmbfuncional> catAmbfuncionals) {
		this.catAmbfuncionals = catAmbfuncionals;
	}

	public CatAmbfuncional addCatAmbfuncional(CatAmbfuncional catAmbfuncional) {
		getCatAmbfuncionals().add(catAmbfuncional);
		catAmbfuncional.setCatTipoAmbfuncional(this);

		return catAmbfuncional;
	}

	public CatAmbfuncional removeCatAmbfuncional(CatAmbfuncional catAmbfuncional) {
		getCatAmbfuncionals().remove(catAmbfuncional);
		catAmbfuncional.setCatTipoAmbfuncional(null);

		return catAmbfuncional;
	}

}