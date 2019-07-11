package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_paises database table.
 * 
 */
@Entity
@Table(name="cat_paises", schema="monolito_god")
@NamedQuery(name="CatPais.findAll", query="SELECT c FROM CatPais c")
public class CatPais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdpais;

	private Integer cdusuario;

	private Integer codpais;

	private Timestamp fmodificacion;

	private String gentilicio;

	@Column(name="iso", columnDefinition="bpchar(2)")
	private String iso;

	private String pais;

	//bi-directional many-to-one association to CatEmprColab
	@OneToMany(mappedBy="catPais")
	private List<CatEmprColab> catEmprColabs;

	//bi-directional many-to-one association to CatEmprGrupo
	@OneToMany(mappedBy="catPais")
	private List<CatEmprGrupo> catEmprGrupos;

	//bi-directional many-to-one association to CatProvincia
	@OneToMany(mappedBy="catPais")
	private List<CatProvincia> catProvincias;

	public CatPais() {
	}

	public Integer getCdpais() {
		return this.cdpais;
	}

	public void setCdpais(Integer cdpais) {
		this.cdpais = cdpais;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getCodpais() {
		return this.codpais;
	}

	public void setCodpais(Integer codpais) {
		this.codpais = codpais;
	}

	public Timestamp getFmodificacion() {
		return this.fmodificacion;
	}

	public void setFmodificacion(Timestamp fmodificacion) {
		this.fmodificacion = fmodificacion;
	}

	public String getGentilicio() {
		return this.gentilicio;
	}

	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}

	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<CatEmprColab> getCatEmprColabs() {
		return this.catEmprColabs;
	}

	public void setCatEmprColabs(List<CatEmprColab> catEmprColabs) {
		this.catEmprColabs = catEmprColabs;
	}

	public CatEmprColab addCatEmprColab(CatEmprColab catEmprColab) {
		getCatEmprColabs().add(catEmprColab);
		catEmprColab.setCatPais(this);

		return catEmprColab;
	}

	public CatEmprColab removeCatEmprColab(CatEmprColab catEmprColab) {
		getCatEmprColabs().remove(catEmprColab);
		catEmprColab.setCatPais(null);

		return catEmprColab;
	}

	public List<CatEmprGrupo> getCatEmprGrupos() {
		return this.catEmprGrupos;
	}

	public void setCatEmprGrupos(List<CatEmprGrupo> catEmprGrupos) {
		this.catEmprGrupos = catEmprGrupos;
	}

	public CatEmprGrupo addCatEmprGrupo(CatEmprGrupo catEmprGrupo) {
		getCatEmprGrupos().add(catEmprGrupo);
		catEmprGrupo.setCatPais(this);

		return catEmprGrupo;
	}

	public CatEmprGrupo removeCatEmprGrupo(CatEmprGrupo catEmprGrupo) {
		getCatEmprGrupos().remove(catEmprGrupo);
		catEmprGrupo.setCatPais(null);

		return catEmprGrupo;
	}

	public List<CatProvincia> getCatProvincias() {
		return this.catProvincias;
	}

	public void setCatProvincias(List<CatProvincia> catProvincias) {
		this.catProvincias = catProvincias;
	}

	public CatProvincia addCatProvincia(CatProvincia catProvincia) {
		getCatProvincias().add(catProvincia);
		catProvincia.setCatPais(this);

		return catProvincia;
	}

	public CatProvincia removeCatProvincia(CatProvincia catProvincia) {
		getCatProvincias().remove(catProvincia);
		catProvincia.setCatPais(null);

		return catProvincia;
	}

}