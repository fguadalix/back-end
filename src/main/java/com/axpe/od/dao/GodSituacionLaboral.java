package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_situacion_laboral database table.
 * 
 */
@Entity
@Table(name="god_situacion_laboral", schema = "monolito_god")
@NamedQuery(name="GodSituacionLaboral.findAll", query="SELECT g FROM GodSituacionLaboral g")
public class GodSituacionLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdsituacion_laboral")
	private Integer cdsituacionLaboral;

	private Integer cdusuario;

	private Integer deleted;

	@Column(name="dssituacion_laboral")
	private String dssituacionLaboral;

	private Timestamp femodificacion;

	public GodSituacionLaboral() {
	}

	public Integer getCdsituacionLaboral() {
		return this.cdsituacionLaboral;
	}

	public void setCdsituacionLaboral(Integer cdsituacionLaboral) {
		this.cdsituacionLaboral = cdsituacionLaboral;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getDssituacionLaboral() {
		return this.dssituacionLaboral;
	}

	public void setDssituacionLaboral(String dssituacionLaboral) {
		this.dssituacionLaboral = dssituacionLaboral;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}