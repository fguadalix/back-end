package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_estado_proy database table.
 * 
 */
@Entity
@Table(name="cat_estado_proy", schema="monolito_god")
@NamedQuery(name="CatEstadoProy.findAll", query="SELECT c FROM CatEstadoProy c")
public class CatEstadoProy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdestado_proy")
	private Integer cdestadoProy;

	private Integer cdusuario;

	@Column(name="dsestado_proy")
	private String dsestadoProy;

	private Timestamp femodificacion;

	public CatEstadoProy() {
	}

	public Integer getCdestadoProy() {
		return this.cdestadoProy;
	}

	public void setCdestadoProy(Integer cdestadoProy) {
		this.cdestadoProy = cdestadoProy;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsestadoProy() {
		return this.dsestadoProy;
	}

	public void setDsestadoProy(String dsestadoProy) {
		this.dsestadoProy = dsestadoProy;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}