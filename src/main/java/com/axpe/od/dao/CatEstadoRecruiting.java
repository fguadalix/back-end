//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the cat_estado_recruiting database table.
// * 
// */
//@Entity
//@Table(name="cat_estado_recruiting", schema="monolito_god")
//@NamedQuery(name="CatEstadoRecruiting.findAll", query="SELECT c FROM CatEstadoRecruiting c")
//public class CatEstadoRecruiting implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="cdestado_recruiting")
//	private Integer cdestadoRecruiting;
//
//	private Integer cdusuario;
//
//	private Integer deleted;
//
//	@Column(name="dsestado_recruiting")
//	private String dsestadoRecruiting;
//
//	public CatEstadoRecruiting() {
//	}
//
//	public Integer getCdestadoRecruiting() {
//		return this.cdestadoRecruiting;
//	}
//
//	public void setCdestadoRecruiting(Integer cdestadoRecruiting) {
//		this.cdestadoRecruiting = cdestadoRecruiting;
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
//	public String getDsestadoRecruiting() {
//		return this.dsestadoRecruiting;
//	}
//
//	public void setDsestadoRecruiting(String dsestadoRecruiting) {
//		this.dsestadoRecruiting = dsestadoRecruiting;
//	}
//
//}