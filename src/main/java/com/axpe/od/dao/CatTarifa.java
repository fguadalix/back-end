package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tarifas database table.
 * 
 */
@Entity
@Table(name="cat_tarifas", schema="monolito_god")
@NamedQuery(name="CatTarifa.findAll", query="SELECT c FROM CatTarifa c")
public class CatTarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdtarifa;

	private Integer cdusuario;

	private Timestamp fcmodificacion;

	private BigDecimal importe;

	//bi-directional many-to-one association to CatCategoria
	@ManyToOne
	@JoinColumn(name="cdcategoria")
	private CatCategoria catCategoria;

	//bi-directional many-to-one association to CatHerramienta
	@ManyToOne
	@JoinColumn(name="cdherramienta")
	private CatHerramienta catHerramienta;

	public CatTarifa() {
	}

	public Integer getCdtarifa() {
		return this.cdtarifa;
	}

	public void setCdtarifa(Integer cdtarifa) {
		this.cdtarifa = cdtarifa;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public CatCategoria getCatCategoria() {
		return this.catCategoria;
	}

	public void setCatCategoria(CatCategoria catCategoria) {
		this.catCategoria = catCategoria;
	}

	public CatHerramienta getCatHerramienta() {
		return this.catHerramienta;
	}

	public void setCatHerramienta(CatHerramienta catHerramienta) {
		this.catHerramienta = catHerramienta;
	}

}