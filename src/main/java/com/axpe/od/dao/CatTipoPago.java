//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the cat_tipo_pago database table.
// * 
// */
//@Entity
//@Table(name="cat_tipo_pago")
//@NamedQuery(name="CatTipoPago.findAll", query="SELECT c FROM CatTipoPago c")
//public class CatTipoPago implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="cdtipo_pago")
//	private Integer cdtipoPago;
//
//	private Integer cdusuario;
//
//	@Column(name="dstipo_pago")
//	private String dstipoPago;
//
//	private Timestamp fcmodificacion;
//
//	public CatTipoPago() {
//	}
//
//	public Integer getCdtipoPago() {
//		return this.cdtipoPago;
//	}
//
//	public void setCdtipoPago(Integer cdtipoPago) {
//		this.cdtipoPago = cdtipoPago;
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
//	public String getDstipoPago() {
//		return this.dstipoPago;
//	}
//
//	public void setDstipoPago(String dstipoPago) {
//		this.dstipoPago = dstipoPago;
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