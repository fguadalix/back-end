package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_periodos_evaluacion database table.
 * 
 */
@Entity
@Table(name="cat_periodos_evaluacion", schema="monolito_god")
@NamedQuery(name="CatPeriodosEvaluacion.findAll", query="SELECT c FROM CatPeriodosEvaluacion c")
public class CatPeriodosEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdperiodo_eval")
	private Integer cdperiodoEval;

	private Integer cdusuario;

	@Column(name="dsperiodo_eval")
	private String dsperiodoEval;

	private Timestamp femodificacion;

	public CatPeriodosEvaluacion() {
	}

	public Integer getCdperiodoEval() {
		return this.cdperiodoEval;
	}

	public void setCdperiodoEval(Integer cdperiodoEval) {
		this.cdperiodoEval = cdperiodoEval;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsperiodoEval() {
		return this.dsperiodoEval;
	}

	public void setDsperiodoEval(String dsperiodoEval) {
		this.dsperiodoEval = dsperiodoEval;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}