package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_eval_nivel database table.
 * 
 */
@Entity
@Table(name="cat_eval_nivel", schema="monolito_god")
@NamedQuery(name="CatEvalNivel.findAll", query="SELECT c FROM CatEvalNivel c")
public class CatEvalNivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdeval_nivel")
	private Integer cdevalNivel;

	private Integer cdusuario;

	@Column(name="dseval_nivel")
	private String dsevalNivel;

	private Timestamp femodificacion;

	public CatEvalNivel() {
	}

	public Integer getCdevalNivel() {
		return this.cdevalNivel;
	}

	public void setCdevalNivel(Integer cdevalNivel) {
		this.cdevalNivel = cdevalNivel;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsevalNivel() {
		return this.dsevalNivel;
	}

	public void setDsevalNivel(String dsevalNivel) {
		this.dsevalNivel = dsevalNivel;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}