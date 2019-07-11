package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_facturas database table.
 * 
 */
@Entity
@Table(name="cat_tipo_facturas", schema="monolito_god")
@NamedQuery(name="CatTipoFactura.findAll", query="SELECT c FROM CatTipoFactura c")
public class CatTipoFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_factura")
	private Integer cdtipoFactura;

	private Integer cdusuario;

	@Column(name="dstipo_factura")
	private String dstipoFactura;

	private Timestamp fcmodificacion;

	public CatTipoFactura() {
	}

	public Integer getCdtipoFactura() {
		return this.cdtipoFactura;
	}

	public void setCdtipoFactura(Integer cdtipoFactura) {
		this.cdtipoFactura = cdtipoFactura;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoFactura() {
		return this.dstipoFactura;
	}

	public void setDstipoFactura(String dstipoFactura) {
		this.dstipoFactura = dstipoFactura;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

}