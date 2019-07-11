//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the cat_origen_candidato database table.
// * 
// */
//@Entity
//@Table(name="cat_origen_candidato")
//@NamedQuery(name="CatOrigenCandidato.findAll", query="SELECT c FROM CatOrigenCandidato c")
//public class CatOrigenCandidato implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="cdorigen_cand")
//	private Integer cdorigenCand;
//
//	private Integer cdusuario;
//
//	private Integer deleted;
//
//	@Column(name="dsorigen_cand")
//	private String dsorigenCand;
//
//	public CatOrigenCandidato() {
//	}
//
//	public Integer getCdorigenCand() {
//		return this.cdorigenCand;
//	}
//
//	public void setCdorigenCand(Integer cdorigenCand) {
//		this.cdorigenCand = cdorigenCand;
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
//	public String getDsorigenCand() {
//		return this.dsorigenCand;
//	}
//
//	public void setDsorigenCand(String dsorigenCand) {
//		this.dsorigenCand = dsorigenCand;
//	}
//
//}