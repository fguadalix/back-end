package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_gastos database table.
 * 
 */
@Entity
@Table(name="cat_tipo_gastos", schema="monolito_god")
@NamedQuery(name="CatTipoGasto.findAll", query="SELECT c FROM CatTipoGasto c")
public class CatTipoGasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_gasto")
	private Integer cdtipoGasto;

	private String cdsagex3;

	private Integer cdusuario;

	@Column(name="dstipo_gasto")
	private String dstipoGasto;

	private Timestamp femodificacion;

	@Column(name="porcentaje_recargo")
	private BigDecimal porcentajeRecargo;

	private Integer tipo;

	//bi-directional many-to-one association to CatGrpTipoGasto
	@ManyToOne
	@JoinColumn(name="cdgrp_tipo_gasto")
	private CatGrpTipoGasto catGrpTipoGasto;

	public CatTipoGasto() {
	}

	public Integer getCdtipoGasto() {
		return this.cdtipoGasto;
	}

	public void setCdtipoGasto(Integer cdtipoGasto) {
		this.cdtipoGasto = cdtipoGasto;
	}

	public String getCdsagex3() {
		return this.cdsagex3;
	}

	public void setCdsagex3(String cdsagex3) {
		this.cdsagex3 = cdsagex3;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoGasto() {
		return this.dstipoGasto;
	}

	public void setDstipoGasto(String dstipoGasto) {
		this.dstipoGasto = dstipoGasto;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public BigDecimal getPorcentajeRecargo() {
		return this.porcentajeRecargo;
	}

	public void setPorcentajeRecargo(BigDecimal porcentajeRecargo) {
		this.porcentajeRecargo = porcentajeRecargo;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public CatGrpTipoGasto getCatGrpTipoGasto() {
		return this.catGrpTipoGasto;
	}

	public void setCatGrpTipoGasto(CatGrpTipoGasto catGrpTipoGasto) {
		this.catGrpTipoGasto = catGrpTipoGasto;
	}

}