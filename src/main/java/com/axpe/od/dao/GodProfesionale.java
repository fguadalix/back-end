package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the god_profesionales database table.
 * 
 */
@Entity
@Table(name="god_profesionales", schema = "monolito_god")
@NamedQuery(name="GodProfesionale.findAll", query="SELECT g FROM GodProfesionale g")
public class GodProfesionale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdprofesional;

	private String apellido1;

	private String apellido2;

	private Integer cdambfuncional;

	private Integer cdcategoria;

	private Integer cddisponibilidad;

	private Integer cdempresa;

	private Integer cdpais;

	private Integer cdprovincia;

	@Column(name="cdsitu_prof")
	private Integer cdsituProf;

	@Column(name="cdtipo_documento")
	private Integer cdtipoDocumento;

	private Integer cdusuario;

	private Integer cdvaloracion;

	private String comentarios;

	private String correo;

	private byte[] cvbinary;

	private Timestamp cvdate;

	private String cvfileext;

	private String cvtexto;

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

	//bi-directional many-to-one association to GodAlerta
	@OneToMany(mappedBy="godProfesionale")
	private List<GodAlerta> godAlertas;

	//bi-directional many-to-one association to GodHContacto
	@OneToMany(mappedBy="godProfesionale")
	private List<GodHContacto> godHContactos;

	//bi-directional many-to-one association to GodProfExp
	@OneToMany(mappedBy="godProfesionale")
	private List<GodProfExp> godProfExps;

	//bi-directional many-to-one association to GodProfTitulacione
	@OneToMany(mappedBy="godProfesionale")
	private List<GodProfTitulacione> godProfTitulaciones;

	//bi-directional many-to-one association to GodProfesHerram
	@OneToMany(mappedBy="godProfesionale")
	private List<GodProfesHerram> godProfesHerrams;

	public GodProfesionale() {
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

	public Integer getCdAmbFuncional() {
		return this.cdambfuncional;
	}

	public void setCdAmbFuncional(Integer cdambfuncional) {
		this.cdambfuncional = cdambfuncional;
	}

	public Integer getCdcategoria() {
		return this.cdcategoria;
	}

	public void setCdcategoria(Integer cdcategoria) {
		this.cdcategoria = cdcategoria;
	}

	public Integer getCddisponibilidad() {
		return this.cddisponibilidad;
	}

	public void setCddisponibilidad(Integer cddisponibilidad) {
		this.cddisponibilidad = cddisponibilidad;
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

	public Integer getCdprovincia() {
		return this.cdprovincia;
	}

	public void setCdprovincia(Integer cdprovincia) {
		this.cdprovincia = cdprovincia;
	}

	public Integer getCdsituProf() {
		return this.cdsituProf;
	}

	public void setCdsituProf(Integer cdsituProf) {
		this.cdsituProf = cdsituProf;
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

	public Integer getCdvaloracion() {
		return this.cdvaloracion;
	}

	public void setCdvaloracion(Integer cdvaloracion) {
		this.cdvaloracion = cdvaloracion;
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

	public String getCvtexto() {
		return this.cvtexto;
	}

	public void setCvtexto(String cvtexto) {
		this.cvtexto = cvtexto;
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

	public List<GodAlerta> getGodAlertas() {
		return this.godAlertas;
	}

	public void setGodAlertas(List<GodAlerta> godAlertas) {
		this.godAlertas = godAlertas;
	}

	public GodAlerta addGodAlerta(GodAlerta godAlerta) {
		getGodAlertas().add(godAlerta);
		godAlerta.setGodProfesionale(this);

		return godAlerta;
	}

	public GodAlerta removeGodAlerta(GodAlerta godAlerta) {
		getGodAlertas().remove(godAlerta);
		godAlerta.setGodProfesionale(null);

		return godAlerta;
	}

	public List<GodHContacto> getGodHContactos() {
		return this.godHContactos;
	}

	public void setGodHContactos(List<GodHContacto> godHContactos) {
		this.godHContactos = godHContactos;
	}

	public GodHContacto addGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().add(godHContacto);
		godHContacto.setGodProfesionale(this);

		return godHContacto;
	}

	public GodHContacto removeGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().remove(godHContacto);
		godHContacto.setGodProfesionale(null);

		return godHContacto;
	}

	public List<GodProfExp> getGodProfExps() {
		return this.godProfExps;
	}

	public void setGodProfExps(List<GodProfExp> godProfExps) {
		this.godProfExps = godProfExps;
	}

	public GodProfExp addGodProfExp(GodProfExp godProfExp) {
		getGodProfExps().add(godProfExp);
		godProfExp.setGodProfesionale(this);

		return godProfExp;
	}

	public GodProfExp removeGodProfExp(GodProfExp godProfExp) {
		getGodProfExps().remove(godProfExp);
		godProfExp.setGodProfesionale(null);

		return godProfExp;
	}

	public List<GodProfTitulacione> getGodProfTitulaciones() {
		return this.godProfTitulaciones;
	}

	public void setGodProfTitulaciones(List<GodProfTitulacione> godProfTitulaciones) {
		this.godProfTitulaciones = godProfTitulaciones;
	}

	public GodProfTitulacione addGodProfTitulacione(GodProfTitulacione godProfTitulacione) {
		getGodProfTitulaciones().add(godProfTitulacione);
		godProfTitulacione.setGodProfesionale(this);

		return godProfTitulacione;
	}

	public GodProfTitulacione removeGodProfTitulacione(GodProfTitulacione godProfTitulacione) {
		getGodProfTitulaciones().remove(godProfTitulacione);
		godProfTitulacione.setGodProfesionale(null);

		return godProfTitulacione;
	}

	public List<GodProfesHerram> getGodProfesHerrams() {
		return this.godProfesHerrams;
	}

	public void setGodProfesHerrams(List<GodProfesHerram> godProfesHerrams) {
		this.godProfesHerrams = godProfesHerrams;
	}

	public GodProfesHerram addGodProfesHerram(GodProfesHerram godProfesHerram) {
		getGodProfesHerrams().add(godProfesHerram);
		godProfesHerram.setGodProfesionale(this);

		return godProfesHerram;
	}

	public GodProfesHerram removeGodProfesHerram(GodProfesHerram godProfesHerram) {
		getGodProfesHerrams().remove(godProfesHerram);
		godProfesHerram.setGodProfesionale(null);

		return godProfesHerram;
	}

}