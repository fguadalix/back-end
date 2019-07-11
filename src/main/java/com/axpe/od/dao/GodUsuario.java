//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the god_usuarios database table.
// * 
// */
//@Entity
//@Table(name="god_usuarios")
//@NamedQuery(name="GodUsuario.findAll", query="SELECT g FROM GodUsuario g")
//public class GodUsuario implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="acctot_peti")
//	private Integer acctotPeti;
//
//	private String apellido1;
//
//	private String apellido2;
//
//	private Integer cdempleado;
//
//	private Integer cdempresa;
//
//	private String cdidioma;
//
//	private Integer cdunidad;
//
//	private Integer cdusuario;
//
//	@Column(name="cdusuario_god")
//	private Integer cdusuarioGod;
//
//	@Column(name="\"contraseÑa\"")
//	private String contraseÑa;
//
//	private Integer deleted;
//
//	private Timestamp fcmodificacion;
//
//	private String login;
//
//	private String nombre;
//
//	private Integer tipousuario;
//
//	private String usuario;
//
//	public GodUsuario() {
//	}
//
//	public Integer getAcctotPeti() {
//		return this.acctotPeti;
//	}
//
//	public void setAcctotPeti(Integer acctotPeti) {
//		this.acctotPeti = acctotPeti;
//	}
//
//	public String getApellido1() {
//		return this.apellido1;
//	}
//
//	public void setApellido1(String apellido1) {
//		this.apellido1 = apellido1;
//	}
//
//	public String getApellido2() {
//		return this.apellido2;
//	}
//
//	public void setApellido2(String apellido2) {
//		this.apellido2 = apellido2;
//	}
//
//	public Integer getCdempleado() {
//		return this.cdempleado;
//	}
//
//	public void setCdempleado(Integer cdempleado) {
//		this.cdempleado = cdempleado;
//	}
//
//	public Integer getCdempresa() {
//		return this.cdempresa;
//	}
//
//	public void setCdempresa(Integer cdempresa) {
//		this.cdempresa = cdempresa;
//	}
//
//	public String getCdidioma() {
//		return this.cdidioma;
//	}
//
//	public void setCdidioma(String cdidioma) {
//		this.cdidioma = cdidioma;
//	}
//
//	public Integer getCdunidad() {
//		return this.cdunidad;
//	}
//
//	public void setCdunidad(Integer cdunidad) {
//		this.cdunidad = cdunidad;
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
//	public Integer getCdusuarioGod() {
//		return this.cdusuarioGod;
//	}
//
//	public void setCdusuarioGod(Integer cdusuarioGod) {
//		this.cdusuarioGod = cdusuarioGod;
//	}
//
//	public String getContraseÑa() {
//		return this.contraseÑa;
//	}
//
//	public void setContraseÑa(String contraseÑa) {
//		this.contraseÑa = contraseÑa;
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
//	public String getLogin() {
//		return this.login;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getNombre() {
//		return this.nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public Integer getTipousuario() {
//		return this.tipousuario;
//	}
//
//	public void setTipousuario(Integer tipousuario) {
//		this.tipousuario = tipousuario;
//	}
//
//	public String getUsuario() {
//		return this.usuario;
//	}
//
//	public void setUsuario(String usuario) {
//		this.usuario = usuario;
//	}
//
//}