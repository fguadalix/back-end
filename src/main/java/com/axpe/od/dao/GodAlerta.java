package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_alertas database table.
 * 
 */
@Entity
@Table(name="god_alertas", schema="monolito_god")
@NamedQuery(name="GodAlerta.findAll", query="SELECT g FROM GodAlerta g")
public class GodAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdalerta;

	@Column(name="cdemple_cumpli")
	private Integer cdempleCumpli;

	private Integer cdempleado;

	@Column(name="cdestado_alerta")
	private Integer cdestadoAlerta;

	private Integer cdusuario;

	@Column(name="cl_h_contactos")
	private Integer clHContactos;

	private Integer deleted;

	private String descripcion;

	@Column(name="fc_alerta")
	private Timestamp fcAlerta;

	@Column(name="fc_creacion")
	private Timestamp fcCreacion;

	@Column(name="fc_cumplimentacion")
	private Timestamp fcCumplimentacion;

	@Column(name="fchora_entrevista")
	private Timestamp fchoraEntrevista;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to GodProfesionale
	@ManyToOne
	@JoinColumn(name="cdprofesional")
	private GodProfesionale godProfesionale;

	public GodAlerta() {
	}

	public Integer getCdalerta() {
		return this.cdalerta;
	}

	public void setCdalerta(Integer cdalerta) {
		this.cdalerta = cdalerta;
	}

	public Integer getCdempleCumpli() {
		return this.cdempleCumpli;
	}

	public void setCdempleCumpli(Integer cdempleCumpli) {
		this.cdempleCumpli = cdempleCumpli;
	}

	public Integer getCdempleado() {
		return this.cdempleado;
	}

	public void setCdempleado(Integer cdempleado) {
		this.cdempleado = cdempleado;
	}

	public Integer getCdestadoAlerta() {
		return this.cdestadoAlerta;
	}

	public void setCdestadoAlerta(Integer cdestadoAlerta) {
		this.cdestadoAlerta = cdestadoAlerta;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getClHContactos() {
		return this.clHContactos;
	}

	public void setClHContactos(Integer clHContactos) {
		this.clHContactos = clHContactos;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFcAlerta() {
		return this.fcAlerta;
	}

	public void setFcAlerta(Timestamp fcAlerta) {
		this.fcAlerta = fcAlerta;
	}

	public Timestamp getFcCreacion() {
		return this.fcCreacion;
	}

	public void setFcCreacion(Timestamp fcCreacion) {
		this.fcCreacion = fcCreacion;
	}

	public Timestamp getFcCumplimentacion() {
		return this.fcCumplimentacion;
	}

	public void setFcCumplimentacion(Timestamp fcCumplimentacion) {
		this.fcCumplimentacion = fcCumplimentacion;
	}

	public Timestamp getFchoraEntrevista() {
		return this.fchoraEntrevista;
	}

	public void setFchoraEntrevista(Timestamp fchoraEntrevista) {
		this.fchoraEntrevista = fchoraEntrevista;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public GodProfesionale getGodProfesionale() {
		return this.godProfesionale;
	}

	public void setGodProfesionale(GodProfesionale godProfesionale) {
		this.godProfesionale = godProfesionale;
	}

}