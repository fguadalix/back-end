package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_certificaciones database table.
 * 
 */
@Entity
@Table(name="cat_certificaciones", schema="monolito_god")
@NamedQuery(name="CatCertificacione.findAll", query="SELECT c FROM CatCertificacione c")
public class CatCertificacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdcertificacion;

	private Integer cdusuario;

	private String codigo;

	private String dscertificacion;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatTipoCertificacion
	@ManyToOne
	@JoinColumn(name="cdtipo_certif")
	private CatTipoCertificacion catTipoCertificacion;

	public CatCertificacione() {
	}

	public Integer getCdcertificacion() {
		return this.cdcertificacion;
	}

	public void setCdcertificacion(Integer cdcertificacion) {
		this.cdcertificacion = cdcertificacion;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDscertificacion() {
		return this.dscertificacion;
	}

	public void setDscertificacion(String dscertificacion) {
		this.dscertificacion = dscertificacion;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public CatTipoCertificacion getCatTipoCertificacion() {
		return this.catTipoCertificacion;
	}

	public void setCatTipoCertificacion(CatTipoCertificacion catTipoCertificacion) {
		this.catTipoCertificacion = catTipoCertificacion;
	}

}