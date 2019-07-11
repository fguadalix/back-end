package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_tipo_certificacion database table.
 * 
 */
@Entity
@Table(name="cat_tipo_certificacion", schema="monolito_god")
@NamedQuery(name="CatTipoCertificacion.findAll", query="SELECT c FROM CatTipoCertificacion c")
public class CatTipoCertificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_certif")
	private Integer cdtipoCertif;

	private Integer cdusuario;

	@Column(name="dstipo_certif")
	private String dstipoCertif;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatCertificacione
	@OneToMany(mappedBy="catTipoCertificacion")
	private List<CatCertificacione> catCertificaciones;

	public CatTipoCertificacion() {
	}

	public Integer getCdtipoCertif() {
		return this.cdtipoCertif;
	}

	public void setCdtipoCertif(Integer cdtipoCertif) {
		this.cdtipoCertif = cdtipoCertif;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoCertif() {
		return this.dstipoCertif;
	}

	public void setDstipoCertif(String dstipoCertif) {
		this.dstipoCertif = dstipoCertif;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<CatCertificacione> getCatCertificaciones() {
		return this.catCertificaciones;
	}

	public void setCatCertificaciones(List<CatCertificacione> catCertificaciones) {
		this.catCertificaciones = catCertificaciones;
	}

	public CatCertificacione addCatCertificacione(CatCertificacione catCertificacione) {
		getCatCertificaciones().add(catCertificacione);
		catCertificacione.setCatTipoCertificacion(this);

		return catCertificacione;
	}

	public CatCertificacione removeCatCertificacione(CatCertificacione catCertificacione) {
		getCatCertificaciones().remove(catCertificacione);
		catCertificacione.setCatTipoCertificacion(null);

		return catCertificacione;
	}

}