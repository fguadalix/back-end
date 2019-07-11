//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the cat_motivo_nofit database table.
// * 
// */
//@Entity
//@Table(name="cat_motivo_nofit")
//@NamedQuery(name="CatMotivoNofit.findAll", query="SELECT c FROM CatMotivoNofit c")
//public class CatMotivoNofit implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="cdmotivo_nofit")
//	private Integer cdmotivoNofit;
//
//	private Integer deleted;
//
//	@Column(name="dsmotivo_nofit")
//	private String dsmotivoNofit;
//
//	private Timestamp fcmodificacion;
//
//	private Integer usuario;
//
//	public CatMotivoNofit() {
//	}
//
//	public Integer getCdmotivoNofit() {
//		return this.cdmotivoNofit;
//	}
//
//	public void setCdmotivoNofit(Integer cdmotivoNofit) {
//		this.cdmotivoNofit = cdmotivoNofit;
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
//	public String getDsmotivoNofit() {
//		return this.dsmotivoNofit;
//	}
//
//	public void setDsmotivoNofit(String dsmotivoNofit) {
//		this.dsmotivoNofit = dsmotivoNofit;
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
//	public Integer getUsuario() {
//		return this.usuario;
//	}
//
//	public void setUsuario(Integer usuario) {
//		this.usuario = usuario;
//	}
//
//}