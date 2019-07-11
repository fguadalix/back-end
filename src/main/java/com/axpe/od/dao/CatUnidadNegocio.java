package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_unidad_negocio database table.
 * 
 */
@Entity
@Table(name="cat_unidad_negocio", schema="monolito_god")
@NamedQuery(name="CatUnidadNegocio.findAll", query="SELECT c FROM CatUnidadNegocio c")
public class CatUnidadNegocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdunidad;

	private String cdsagex3;

	@Column(name="cdsagex3_delega")
	private String cdsagex3Delega;

	private Integer cdusuario;

	private String dsunidad;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatEmprGrupo
	@ManyToOne
	@JoinColumn(name="cdempresa")
	private CatEmprGrupo catEmprGrupo;

	public CatUnidadNegocio() {
	}

	public Integer getCdunidad() {
		return this.cdunidad;
	}

	public void setCdunidad(Integer cdunidad) {
		this.cdunidad = cdunidad;
	}

	public String getCdsagex3() {
		return this.cdsagex3;
	}

	public void setCdsagex3(String cdsagex3) {
		this.cdsagex3 = cdsagex3;
	}

	public String getCdsagex3Delega() {
		return this.cdsagex3Delega;
	}

	public void setCdsagex3Delega(String cdsagex3Delega) {
		this.cdsagex3Delega = cdsagex3Delega;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsunidad() {
		return this.dsunidad;
	}

	public void setDsunidad(String dsunidad) {
		this.dsunidad = dsunidad;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public CatEmprGrupo getCatEmprGrupo() {
		return this.catEmprGrupo;
	}

	public void setCatEmprGrupo(CatEmprGrupo catEmprGrupo) {
		this.catEmprGrupo = catEmprGrupo;
	}

}