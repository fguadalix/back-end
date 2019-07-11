//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the god_config database table.
// * 
// */
//@Entity
//@Table(name="god_config")
//@NamedQuery(name="GodConfig.findAll", query="SELECT g FROM GodConfig g")
//public class GodConfig implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	private Integer deleted;
//
//	@Column(name="situ_peticion_encurso")
//	private Integer situPeticionEncurso;
//
//	@Column(name="situ_peticion_finalizada")
//	private Integer situPeticionFinalizada;
//
//	@Column(name="situ_profesional_aceptado")
//	private Integer situProfesionalAceptado;
//
//	@Column(name="situ_profesional_contratado")
//	private Integer situProfesionalContratado;
//
//	@Column(name="situ_profesional_inicial")
//	private Integer situProfesionalInicial;
//
//	@Column(name="situ_profesional_rechazado")
//	private Integer situProfesionalRechazado;
//
//	public GodConfig() {
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
//	public Integer getSituPeticionEncurso() {
//		return this.situPeticionEncurso;
//	}
//
//	public void setSituPeticionEncurso(Integer situPeticionEncurso) {
//		this.situPeticionEncurso = situPeticionEncurso;
//	}
//
//	public Integer getSituPeticionFinalizada() {
//		return this.situPeticionFinalizada;
//	}
//
//	public void setSituPeticionFinalizada(Integer situPeticionFinalizada) {
//		this.situPeticionFinalizada = situPeticionFinalizada;
//	}
//
//	public Integer getSituProfesionalAceptado() {
//		return this.situProfesionalAceptado;
//	}
//
//	public void setSituProfesionalAceptado(Integer situProfesionalAceptado) {
//		this.situProfesionalAceptado = situProfesionalAceptado;
//	}
//
//	public Integer getSituProfesionalContratado() {
//		return this.situProfesionalContratado;
//	}
//
//	public void setSituProfesionalContratado(Integer situProfesionalContratado) {
//		this.situProfesionalContratado = situProfesionalContratado;
//	}
//
//	public Integer getSituProfesionalInicial() {
//		return this.situProfesionalInicial;
//	}
//
//	public void setSituProfesionalInicial(Integer situProfesionalInicial) {
//		this.situProfesionalInicial = situProfesionalInicial;
//	}
//
//	public Integer getSituProfesionalRechazado() {
//		return this.situProfesionalRechazado;
//	}
//
//	public void setSituProfesionalRechazado(Integer situProfesionalRechazado) {
//		this.situProfesionalRechazado = situProfesionalRechazado;
//	}
//
//}