//package com.axpe.od.dao;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the god_tmp_2 database table.
// * 
// */
//@Entity
//@Table(name="god_tmp_2")
//@NamedQuery(name="GodTmp2.findAll", query="SELECT g FROM GodTmp2 g")
//public class GodTmp2 implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	private Integer cdherramienta;
//
//	@Column(name="cdper_tiempo")
//	private Integer cdperTiempo;
//
//	private Integer cdpeticion;
//
//	private Integer cdprofesional;
//
//	private Integer cdusuario;
//
//	@Column(name="col_asignado")
//	private Integer colAsignado;
//
//	@Column(name="col_categoria")
//	private String colCategoria;
//
//	@Column(name="col_herramientas")
//	private String colHerramientas;
//
//	@Column(name="col_salario")
//	private String colSalario;
//
//	@Column(name="col_titulacion")
//	private String colTitulacion;
//
//	@Column(name="col_valoracion")
//	private String colValoracion;
//
//	private String nombre;
//
//	public GodTmp2() {
//	}
//
//	public Integer getCdherramienta() {
//		return this.cdherramienta;
//	}
//
//	public void setCdherramienta(Integer cdherramienta) {
//		this.cdherramienta = cdherramienta;
//	}
//
//	public Integer getCdperTiempo() {
//		return this.cdperTiempo;
//	}
//
//	public void setCdperTiempo(Integer cdperTiempo) {
//		this.cdperTiempo = cdperTiempo;
//	}
//
//	public Integer getCdpeticion() {
//		return this.cdpeticion;
//	}
//
//	public void setCdpeticion(Integer cdpeticion) {
//		this.cdpeticion = cdpeticion;
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
//	public Integer getColAsignado() {
//		return this.colAsignado;
//	}
//
//	public void setColAsignado(Integer colAsignado) {
//		this.colAsignado = colAsignado;
//	}
//
//	public String getColCategoria() {
//		return this.colCategoria;
//	}
//
//	public void setColCategoria(String colCategoria) {
//		this.colCategoria = colCategoria;
//	}
//
//	public String getColHerramientas() {
//		return this.colHerramientas;
//	}
//
//	public void setColHerramientas(String colHerramientas) {
//		this.colHerramientas = colHerramientas;
//	}
//
//	public String getColSalario() {
//		return this.colSalario;
//	}
//
//	public void setColSalario(String colSalario) {
//		this.colSalario = colSalario;
//	}
//
//	public String getColTitulacion() {
//		return this.colTitulacion;
//	}
//
//	public void setColTitulacion(String colTitulacion) {
//		this.colTitulacion = colTitulacion;
//	}
//
//	public String getColValoracion() {
//		return this.colValoracion;
//	}
//
//	public void setColValoracion(String colValoracion) {
//		this.colValoracion = colValoracion;
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
//}