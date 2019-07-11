//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the cat_estado_peti database table.
// * 
// */
//@Entity
//@Table(name="cat_estado_peti", schema="monolito_god")
//@NamedQuery(name="CatEstadoPeti.findAll", query="SELECT c FROM CatEstadoPeti c")
//public class CatEstadoPeti implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="cdestado_peti")
//	private Integer cdestadoPeti;
//
//	private Integer cdusuario;
//
//	@Column(name="dsestado_peti")
//	private String dsestadoPeti;
//
//	private Timestamp femodificacion;
//
//	public CatEstadoPeti() {
//	}
//
//	public Integer getCdestadoPeti() {
//		return this.cdestadoPeti;
//	}
//
//	public void setCdestadoPeti(Integer cdestadoPeti) {
//		this.cdestadoPeti = cdestadoPeti;
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
//	public String getDsestadoPeti() {
//		return this.dsestadoPeti;
//	}
//
//	public void setDsestadoPeti(String dsestadoPeti) {
//		this.dsestadoPeti = dsestadoPeti;
//	}
//
//	public Timestamp getFemodificacion() {
//		return this.femodificacion;
//	}
//
//	public void setFemodificacion(Timestamp femodificacion) {
//		this.femodificacion = femodificacion;
//	}
//
//}