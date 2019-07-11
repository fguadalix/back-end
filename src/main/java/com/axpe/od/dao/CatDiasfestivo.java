package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_diasfestivos database table.
 * 
 */
@Entity
@Table(name="cat_diasfestivos", schema="monolito_god")
@NamedQuery(name="CatDiasfestivo.findAll", query="SELECT c FROM CatDiasfestivo c")
public class CatDiasfestivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdfestivo;

	private Integer ano;

	private Integer cdusuario;

	private Integer dia;

	private String dsfestivo;

	private Timestamp femodificacion;

	private Integer mes;

	public CatDiasfestivo() {
	}

	public Integer getCdfestivo() {
		return this.cdfestivo;
	}

	public void setCdfestivo(Integer cdfestivo) {
		this.cdfestivo = cdfestivo;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDsfestivo() {
		return this.dsfestivo;
	}

	public void setDsfestivo(String dsfestivo) {
		this.dsfestivo = dsfestivo;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

}