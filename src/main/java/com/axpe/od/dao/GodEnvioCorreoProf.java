//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the god_envio_correo_prof database table.
// * 
// */
//@Entity
//@Table(name="god_envio_correo_prof")
//@NamedQuery(name="GodEnvioCorreoProf.findAll", query="SELECT g FROM GodEnvioCorreoProf g")
//public class GodEnvioCorreoProf implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	private Integer cdprofesional;
//
//	@Column(name="fecha_envio")
//	private Timestamp fechaEnvio;
//
//	private Integer idcorreo;
//
//	public GodEnvioCorreoProf() {
//	}
//
//	public Integer getCdprofesional() {
//		return this.cdprofesional;
//	}
//
//	public void setCdprofesional(Integer cdprofesional) {
//		this.cdprofesional = cdprofesional;
//	}
//
//	public Timestamp getFechaEnvio() {
//		return this.fechaEnvio;
//	}
//
//	public void setFechaEnvio(Timestamp fechaEnvio) {
//		this.fechaEnvio = fechaEnvio;
//	}
//
//	public Integer getIdcorreo() {
//		return this.idcorreo;
//	}
//
//	public void setIdcorreo(Integer idcorreo) {
//		this.idcorreo = idcorreo;
//	}
//
//}