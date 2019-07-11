//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the god_bloqueos database table.
// * 
// */
//@Entity
//@Table(name="god_bloqueos")
//@NamedQuery(name="GodBloqueo.findAll", query="SELECT g FROM GodBloqueo g")
//public class GodBloqueo implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	private Integer cdusuario;
//
//	private Integer deleted;
//
//	private Timestamp fcmodificacion;
//
//	private Integer id;
//
//	private String idstr;
//
//	private String tabla;
//
//	public GodBloqueo() {
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
//	public Integer getDeleted() {
//		return this.deleted;
//	}
//
//	public void setDeleted(Integer deleted) {
//		this.deleted = deleted;
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
//	public Integer getId() {
//		return this.id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getIdstr() {
//		return this.idstr;
//	}
//
//	public void setIdstr(String idstr) {
//		this.idstr = idstr;
//	}
//
//	public String getTabla() {
//		return this.tabla;
//	}
//
//	public void setTabla(String tabla) {
//		this.tabla = tabla;
//	}
//
//}