package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the god_profesionales_infojobs database table.
 * 
 */
@Entity
@Table(name="god_profesionales_infojobs", schema = "monolito_god")
@NamedQuery(name="GodProfesionalesInfojob.findAll", query="SELECT g FROM GodProfesionalesInfojob g")
public class GodProfesionalesInfojob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdprofesional;

	private String apellido1;

	private String apellido2;

	private Integer cdambfuncional;

	private Integer cdempresa;

	private Integer cdpais;

	@Column(name="cdtipo_documento")
	private Integer cdtipoDocumento;

	private Integer cdusuario;

	private String comentarios;

	private String correo;

	private byte[] cvbinary;

	private Timestamp cvdate;

	private String cvfileext;

	private Integer deleted;

	private String dni;

	private String dsoferta;

	@Column(name="exp_salario1")
	private BigDecimal expSalario1;

	@Column(name="exp_salario2")
	private BigDecimal expSalario2;

	@Column(name="fcalta_bd")
	private Timestamp fcaltaBd;

	private Timestamp fccontratacion;

	private Timestamp fcmodificacion;

	private Timestamp fcnacimiento;

	private String linkedin;

	private String nombre;

	private String telefono1;

	private String telefono2;

	//bi-directional many-to-one association to CatCategoria
	@ManyToOne
	@JoinColumn(name="cdcategoria")
	private CatCategoria catCategoria;

	//bi-directional many-to-one association to CatProvincia
	@ManyToOne
	@JoinColumn(name="cdprovincia")
	private CatProvincia catProvincia;

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

	public GodProfesionalesInfojob() {
	}

	public Integer getCdprofesional() {
		return this.cdprofesional;
	}

	public void setCdprofesional(Integer cdprofesional) {
		this.cdprofesional = cdprofesional;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Integer getCdambfuncional() {
		return this.cdambfuncional;
	}

	public void setCdambfuncional(Integer cdambfuncional) {
		this.cdambfuncional = cdambfuncional;
	}

	public Integer getCdempresa() {
		return this.cdempresa;
	}

	public void setCdempresa(Integer cdempresa) {
		this.cdempresa = cdempresa;
	}

	public Integer getCdpais() {
		return this.cdpais;
	}

	public void setCdpais(Integer cdpais) {
		this.cdpais = cdpais;
	}

	public Integer getCdtipoDocumento() {
		return this.cdtipoDocumento;
	}

	public void setCdtipoDocumento(Integer cdtipoDocumento) {
		this.cdtipoDocumento = cdtipoDocumento;
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

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public byte[] getCvbinary() {
		return this.cvbinary;
	}

	public void setCvbinary(byte[] cvbinary) {
		this.cvbinary = cvbinary;
	}

	public Timestamp getCvdate() {
		return this.cvdate;
	}

	public void setCvdate(Timestamp cvdate) {
		this.cvdate = cvdate;
	}

	public String getCvfileext() {
		return this.cvfileext;
	}

	public void setCvfileext(String cvfileext) {
		this.cvfileext = cvfileext;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDsoferta() {
		return this.dsoferta;
	}

	public void setDsoferta(String dsoferta) {
		this.dsoferta = dsoferta;
	}

	public BigDecimal getExpSalario1() {
		return this.expSalario1;
	}

	public void setExpSalario1(BigDecimal expSalario1) {
		this.expSalario1 = expSalario1;
	}

	public BigDecimal getExpSalario2() {
		return this.expSalario2;
	}

	public void setExpSalario2(BigDecimal expSalario2) {
		this.expSalario2 = expSalario2;
	}

	public Timestamp getFcaltaBd() {
		return this.fcaltaBd;
	}

	public void setFcaltaBd(Timestamp fcaltaBd) {
		this.fcaltaBd = fcaltaBd;
	}

	public Timestamp getFccontratacion() {
		return this.fccontratacion;
	}

	public void setFccontratacion(Timestamp fccontratacion) {
		this.fccontratacion = fccontratacion;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public Timestamp getFcnacimiento() {
		return this.fcnacimiento;
	}

	public void setFcnacimiento(Timestamp fcnacimiento) {
		this.fcnacimiento = fcnacimiento;
	}

	public String getLinkedin() {
		return this.linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return this.telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public CatCategoria getCatCategoria() {
		return this.catCategoria;
	}

	public void setCatCategoria(CatCategoria catCategoria) {
		this.catCategoria = catCategoria;
	}

	public CatProvincia getCatProvincia() {
		return this.catProvincia;
	}

	public void setCatProvincia(CatProvincia catProvincia) {
		this.catProvincia = catProvincia;
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

}