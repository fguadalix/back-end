package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_bonus database table.
 * 
 */
@Entity
@Table(name="cat_tipo_bonus", schema="monolito_god")
@NamedQuery(name="CatTipoBonus.findAll", query="SELECT c FROM CatTipoBonus c")
public class CatTipoBonus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_bonus")
	private Integer cdtipoBonus;

	private Integer cdusuario;

	@Column(name="dstipo_bonus")
	private String dstipoBonus;

	private Timestamp fealta;

	private Timestamp femodificacion;

	private BigDecimal importe;

	public CatTipoBonus() {
	}

	public Integer getCdtipoBonus() {
		return this.cdtipoBonus;
	}

	public void setCdtipoBonus(Integer cdtipoBonus) {
		this.cdtipoBonus = cdtipoBonus;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoBonus() {
		return this.dstipoBonus;
	}

	public void setDstipoBonus(String dstipoBonus) {
		this.dstipoBonus = dstipoBonus;
	}

	public Timestamp getFealta() {
		return this.fealta;
	}

	public void setFealta(Timestamp fealta) {
		this.fealta = fealta;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

}