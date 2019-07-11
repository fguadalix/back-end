package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_grp_tipo_gastos database table.
 * 
 */
@Entity
@Table(name="cat_grp_tipo_gastos", schema="monolito_god")
@NamedQuery(name="CatGrpTipoGasto.findAll", query="SELECT c FROM CatGrpTipoGasto c")
public class CatGrpTipoGasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdgrp_tipo_gasto")
	private Integer cdgrpTipoGasto;

	@Column(name="cdgrp_tipo_gasto_nominas")
	private Integer cdgrpTipoGastoNominas;

	private Integer cdusuario;

	@Column(name="dsgrp_tipo_gasto")
	private String dsgrpTipoGasto;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatTipoGasto
	@OneToMany(mappedBy="catGrpTipoGasto")
	private List<CatTipoGasto> catTipoGastos;

	public CatGrpTipoGasto() {
	}

	public Integer getCdgrpTipoGasto() {
		return this.cdgrpTipoGasto;
	}

	public void setCdgrpTipoGasto(Integer cdgrpTipoGasto) {
		this.cdgrpTipoGasto = cdgrpTipoGasto;
	}

	public Integer getCdgrpTipoGastoNominas() {
		return this.cdgrpTipoGastoNominas;
	}

	public void setCdgrpTipoGastoNominas(Integer cdgrpTipoGastoNominas) {
		this.cdgrpTipoGastoNominas = cdgrpTipoGastoNominas;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsgrpTipoGasto() {
		return this.dsgrpTipoGasto;
	}

	public void setDsgrpTipoGasto(String dsgrpTipoGasto) {
		this.dsgrpTipoGasto = dsgrpTipoGasto;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<CatTipoGasto> getCatTipoGastos() {
		return this.catTipoGastos;
	}

	public void setCatTipoGastos(List<CatTipoGasto> catTipoGastos) {
		this.catTipoGastos = catTipoGastos;
	}

	public CatTipoGasto addCatTipoGasto(CatTipoGasto catTipoGasto) {
		getCatTipoGastos().add(catTipoGasto);
		catTipoGasto.setCatGrpTipoGasto(this);

		return catTipoGasto;
	}

	public CatTipoGasto removeCatTipoGasto(CatTipoGasto catTipoGasto) {
		getCatTipoGastos().remove(catTipoGasto);
		catTipoGasto.setCatGrpTipoGasto(null);

		return catTipoGasto;
	}

}