package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the god_h_contactos database table.
 * 
 */
@Entity
@Table(name="god_h_contactos", schema="monolito_god")
@NamedQuery(name="GodHContacto.findAll", query="SELECT g FROM GodHContacto g")
public class GodHContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cl_h_contactos")
	private Integer clHContactos;

	private Integer cdempleado;

	private Integer cdusuario;

	private String comentarios;

	private Integer deleted;

	@Column(name="exp_salarial1")
	private BigDecimal expSalarial1;

	@Column(name="exp_salarial2")
	private BigDecimal expSalarial2;

	private Timestamp fcmodificacion;

	private Timestamp fecha;

	@Column(name="salario_recomendado")
	private BigDecimal salarioRecomendado;

	//bi-directional many-to-one association to CatEstadoContacto
	@ManyToOne
	@JoinColumn(name="cdestado_contac")
	private CatEstadoContacto catEstadoContacto;

	//bi-directional many-to-one association to CatSituProfesional
	@ManyToOne
	@JoinColumn(name="cdsitu_prof")
	private CatSituProfesional catSituProfesional;

	//bi-directional many-to-one association to CatValoracion
	@ManyToOne
	@JoinColumn(name="cdvaloracion")
	private CatValoracion catValoracion;

	//bi-directional many-to-one association to GodDisponibilidad
	@ManyToOne
	@JoinColumn(name="cddisponibilidad")
	private GodDisponibilidad godDisponibilidad;

	//bi-directional many-to-one association to GodPeticione
	@ManyToOne
	@JoinColumn(name="cdpeticion")
	private GodPeticiones godPeticione;

	//bi-directional many-to-one association to GodProfesionale
	@ManyToOne
	@JoinColumn(name="cdprofesional")
	private GodProfesionale godProfesionale;

	public GodHContacto() {
	}

	public Integer getClHContactos() {
		return this.clHContactos;
	}

	public void setClHContactos(Integer clHContactos) {
		this.clHContactos = clHContactos;
	}

	public Integer getCdempleado() {
		return this.cdempleado;
	}

	public void setCdempleado(Integer cdempleado) {
		this.cdempleado = cdempleado;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public BigDecimal getExpSalarial1() {
		return this.expSalarial1;
	}

	public void setExpSalarial1(BigDecimal expSalarial1) {
		this.expSalarial1 = expSalarial1;
	}

	public BigDecimal getExpSalarial2() {
		return this.expSalarial2;
	}

	public void setExpSalarial2(BigDecimal expSalarial2) {
		this.expSalarial2 = expSalarial2;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getSalarioRecomendado() {
		return this.salarioRecomendado;
	}

	public void setSalarioRecomendado(BigDecimal salarioRecomendado) {
		this.salarioRecomendado = salarioRecomendado;
	}

	public CatEstadoContacto getCatEstadoContacto() {
		return this.catEstadoContacto;
	}

	public void setCatEstadoContacto(CatEstadoContacto catEstadoContacto) {
		this.catEstadoContacto = catEstadoContacto;
	}

	public CatSituProfesional getCatSituProfesional() {
		return this.catSituProfesional;
	}

	public void setCatSituProfesional(CatSituProfesional catSituProfesional) {
		this.catSituProfesional = catSituProfesional;
	}

	public CatValoracion getCatValoracion() {
		return this.catValoracion;
	}

	public void setCatValoracion(CatValoracion catValoracion) {
		this.catValoracion = catValoracion;
	}

	public GodDisponibilidad getGodDisponibilidad() {
		return this.godDisponibilidad;
	}

	public void setGodDisponibilidad(GodDisponibilidad godDisponibilidad) {
		this.godDisponibilidad = godDisponibilidad;
	}

	public GodPeticiones getGodPeticione() {
		return this.godPeticione;
	}

	public void setGodPeticione(GodPeticiones godPeticione) {
		this.godPeticione = godPeticione;
	}

	public GodProfesionale getGodProfesionale() {
		return this.godProfesionale;
	}

	public void setGodProfesionale(GodProfesionale godProfesionale) {
		this.godProfesionale = godProfesionale;
	}

}