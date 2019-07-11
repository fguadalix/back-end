//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the cat_motivo_cancelado database table.
// * 
// */
//@Entity
//@Table(name="cat_motivo_cancelado")
//@NamedQuery(name="CatMotivoCancelado.findAll", query="SELECT c FROM CatMotivoCancelado c")
//public class CatMotivoCancelado implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="cdmotivo_cancelado")
//	private Integer cdmotivoCancelado;
//
//	private Integer cdusuario;
//
//	private Integer deleted;
//
//	@Column(name="dsmotivo_cancelado")
//	private String dsmotivoCancelado;
//
//	private Timestamp fcmodificacion;
//
//	public CatMotivoCancelado() {
//	}
//
//	public Integer getCdmotivoCancelado() {
//		return this.cdmotivoCancelado;
//	}
//
//	public void setCdmotivoCancelado(Integer cdmotivoCancelado) {
//		this.cdmotivoCancelado = cdmotivoCancelado;
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
//	public String getDsmotivoCancelado() {
//		return this.dsmotivoCancelado;
//	}
//
//	public void setDsmotivoCancelado(String dsmotivoCancelado) {
//		this.dsmotivoCancelado = dsmotivoCancelado;
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
//}