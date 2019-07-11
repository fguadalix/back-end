//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the god_certificaciones_prof database table.
// * 
// */
//@Entity
//@Table(name="god_certificaciones_prof", schema="monolito_god")
//@NamedQuery(name="GodCertificacionesProf.findAll", query="SELECT g FROM GodCertificacionesProf g")
//public class GodCertificacionesProf implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	private Integer cdcertificacion;
//
//	private Integer cdprofesional;
//
//	private Integer cdusuario;
//
//	private Timestamp fcmodificacion;
//
//	private Timestamp fcultima;
//
//	public GodCertificacionesProf() {
//	}
//
//	public Integer getCdcertificacion() {
//		return this.cdcertificacion;
//	}
//
//	public void setCdcertificacion(Integer cdcertificacion) {
//		this.cdcertificacion = cdcertificacion;
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
//	public Integer getCdusuario() {
//		return this.cdusuario;
//	}
//
//	public void setCdusuario(Integer cdusuario) {
//		this.cdusuario = cdusuario;
//	}
//
//	public Timestamp getFcmodificacion() {
//		return this.fcmodificacion;
//	}
//
//	public void setFcmodificacion(Timestamp fcmodificacion) {
//		this.fcmodificacion = fcmodificacion;
//	}
//
//	public Timestamp getFcultima() {
//		return this.fcultima;
//	}
//
//	public void setFcultima(Timestamp fcultima) {
//		this.fcultima = fcultima;
//	}
//
//}