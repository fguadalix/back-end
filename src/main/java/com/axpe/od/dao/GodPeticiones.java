package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the god_peticiones database table.
 * 
 */
@Entity
@Table(name="god_peticiones" ,schema="monolito_god")
@NamedQuery(name="GodPeticiones.findAll", query="SELECT g FROM GodPeticiones g")

public class GodPeticiones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdpeticion;

	@Column(name="adj_binary")
	private byte[] adjBinary;

	@Column(name="adj_ext")
	private String adjExt;

	@Column(name="cd_tipo_titulacion")
	private Integer cdTipoTitulacion;

	@Column(name="cdempr_clie")
	private Integer cdemprClie;

	private Integer cdgerente;

	private String cdoportunidad;

	private Integer cdproyecto;

	private Integer cdtitulacion;

	private Integer cdunidad;

	private Integer cdusuario;

	@Column(name="clave_externa")
	private String claveExterna;

	private String comentarios;

	private Integer deleted;

	private String descripcion;

	@Column(name="duracion_serv")
	private String duracionServ;

	@Column(name="exp_salario1")
	private BigDecimal expSalario1;

	@Column(name="exp_salario2")
	private BigDecimal expSalario2;

	private Timestamp fcentrada;

	private Timestamp fcincorporacion;

	private Timestamp fcmodificacion;

	private Timestamp fcsolicitud;

	@Column(name="num_tecnicos")
	private Integer numTecnicos;

	private String tarifa;
	
	private String palabrasclaves;
	
	private String departamento;
	
	@Column(name="archivo", columnDefinition="Boolean")
	private Boolean archivo;
	
	private String tecnico;
	
	private String manager;
	
	private String proyecto;
	
	private String cliente;

	//bi-directional many-to-one association to GodHContacto
	@OneToMany(mappedBy="godPeticione")
	private List<GodHContacto> godHContactos;

	//bi-directional many-to-one association to GodPetiTitulacione
	@OneToMany(mappedBy="godPeticione")
	private List<GodPetiTitulacione> godPetiTitulaciones;

	//bi-directional many-to-one association to GodPeticionHerram
	@OneToMany(mappedBy="godPeticione")
	private List<GodPeticionHerram> godPeticionHerrams;

	//bi-directional many-to-one association to CatCategoria
	@ManyToOne
	@JoinColumn(name="cdcategoria")
	private CatCategoria catCategoria;

	//bi-directional many-to-one association to CatPrioridad
	@ManyToOne
	@JoinColumn(name="cdprioridad")
	private CatPrioridad catPrioridad;

	//bi-directional many-to-one association to CatSituPeticion
	@ManyToOne
	@JoinColumn(name="cdsitu_peti")
	private CatSituPeticion catSituPeticion;

	//bi-directional one-to-one association to GodPeticione
	@OneToOne
	@JoinColumn(name="cdpeticion")
	private GodPeticiones godPeticione1;

	//bi-directional one-to-one association to GodPeticione
	@OneToOne(mappedBy="godPeticione1")
	private GodPeticiones godPeticione2;

	//bi-directional many-to-one association to GodTrazaEstadoPet
	@OneToMany(mappedBy="godPeticione")
	private List<GodTrazaEstadoPet> godTrazaEstadoPets;

	public GodPeticiones() {
	}

	public Integer getCdpeticion() {
		return this.cdpeticion;
	}

	public void setCdpeticion(Integer cdpeticion) {
		this.cdpeticion = cdpeticion;
	}

	public byte[] getAdjBinary() {
		return this.adjBinary;
	}

	public void setAdjBinary(byte[] adjBinary) {
		this.adjBinary = adjBinary;
	}

	public String getAdjExt() {
		return this.adjExt;
	}

	public void setAdjExt(String adjExt) {
		this.adjExt = adjExt;
	}

	public Integer getCdTipoTitulacion() {
		return this.cdTipoTitulacion;
	}

	public void setCdTipoTitulacion(Integer cdTipoTitulacion) {
		this.cdTipoTitulacion = cdTipoTitulacion;
	}

	public Integer getCdemprClie() {
		return this.cdemprClie;
	}

	public void setCdemprClie(Integer cdemprClie) {
		this.cdemprClie = cdemprClie;
	}

	public Integer getCdgerente() {
		return this.cdgerente;
	}

	public void setCdgerente(Integer cdgerente) {
		this.cdgerente = cdgerente;
	}

	public String getCdoportunidad() {
		return this.cdoportunidad;
	}

	public void setCdoportunidad(String cdoportunidad) {
		this.cdoportunidad = cdoportunidad;
	}

	public Integer getCdproyecto() {
		return this.cdproyecto;
	}

	public void setCdproyecto(Integer cdproyecto) {
		this.cdproyecto = cdproyecto;
	}

	public Integer getCdtitulacion() {
		return this.cdtitulacion;
	}

	public void setCdtitulacion(Integer cdtitulacion) {
		this.cdtitulacion = cdtitulacion;
	}

	public Integer getCdunidad() {
		return this.cdunidad;
	}

	public void setCdunidad(Integer cdunidad) {
		this.cdunidad = cdunidad;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getClaveExterna() {
		return this.claveExterna;
	}

	public void setClaveExterna(String claveExterna) {
		this.claveExterna = claveExterna;
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDuracionServ() {
		return this.duracionServ;
	}

	public void setDuracionServ(String duracionServ) {
		this.duracionServ = duracionServ;
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

	public Timestamp getFcentrada() {
		return this.fcentrada;
	}

	public void setFcentrada(Timestamp fcentrada) {
		this.fcentrada = fcentrada;
	}

	public Timestamp getFcincorporacion() {
		return this.fcincorporacion;
	}

	public void setFcincorporacion(Timestamp fcincorporacion) {
		this.fcincorporacion = fcincorporacion;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public Timestamp getFcsolicitud() {
		return this.fcsolicitud;
	}

	public void setFcsolicitud(Timestamp fcsolicitud) {
		this.fcsolicitud = fcsolicitud;
	}

	public Integer getNumTecnicos() {
		return this.numTecnicos;
	}

	public void setNumTecnicos(Integer numTecnicos) {
		this.numTecnicos = numTecnicos;
	}

	public String getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}
	
	
	public String getPalabrasclaves() {
		return this.palabrasclaves;
	}

	public void setPalabrasclaves(String palabrasclaves) {
		this.palabrasclaves = palabrasclaves;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public Boolean getArchivo() {
		return this.archivo;
	}

	public void setArchivo(Boolean archivo) {
		this.archivo = archivo;
	}

	public String getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	
	
	

	public List<GodHContacto> getGodHContactos() {
		return this.godHContactos;
	}

	public void setGodHContactos(List<GodHContacto> godHContactos) {
		this.godHContactos = godHContactos;
	}

	public GodHContacto addGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().add(godHContacto);
		godHContacto.setGodPeticione(this);

		return godHContacto;
	}

	public GodHContacto removeGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().remove(godHContacto);
		godHContacto.setGodPeticione(null);

		return godHContacto;
	}

	public List<GodPetiTitulacione> getGodPetiTitulaciones() {
		return this.godPetiTitulaciones;
	}

	public void setGodPetiTitulaciones(List<GodPetiTitulacione> godPetiTitulaciones) {
		this.godPetiTitulaciones = godPetiTitulaciones;
	}

	public GodPetiTitulacione addGodPetiTitulacione(GodPetiTitulacione godPetiTitulacione) {
		getGodPetiTitulaciones().add(godPetiTitulacione);
		godPetiTitulacione.setGodPeticione(this);

		return godPetiTitulacione;
	}

	public GodPetiTitulacione removeGodPetiTitulacione(GodPetiTitulacione godPetiTitulacione) {
		getGodPetiTitulaciones().remove(godPetiTitulacione);
		godPetiTitulacione.setGodPeticione(null);

		return godPetiTitulacione;
	}

	public List<GodPeticionHerram> getGodPeticionHerrams() {
		return this.godPeticionHerrams;
	}

	public void setGodPeticionHerrams(List<GodPeticionHerram> godPeticionHerrams) {
		this.godPeticionHerrams = godPeticionHerrams;
	}

	public GodPeticionHerram addGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().add(godPeticionHerram);
		godPeticionHerram.setGodPeticione(this);

		return godPeticionHerram;
	}

	public GodPeticionHerram removeGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().remove(godPeticionHerram);
		godPeticionHerram.setGodPeticione(null);

		return godPeticionHerram;
	}

	public CatCategoria getCatCategoria() {
		return this.catCategoria;
	}

	public void setCatCategoria(CatCategoria catCategoria) {
		this.catCategoria = catCategoria;
	}

	public CatPrioridad getCatPrioridad() {
		return this.catPrioridad;
	}

	public void setCatPrioridad(CatPrioridad catPrioridad) {
		this.catPrioridad = catPrioridad;
	}

	public CatSituPeticion getCatSituPeticion() {
		return this.catSituPeticion;
	}

	public void setCatSituPeticion(CatSituPeticion catSituPeticion) {
		this.catSituPeticion = catSituPeticion;
	}

	public GodPeticiones getGodPeticione1() {
		return this.godPeticione1;
	}

	public void setGodPeticione1(GodPeticiones godPeticione1) {
		this.godPeticione1 = godPeticione1;
	}

	public GodPeticiones getGodPeticione2() {
		return this.godPeticione2;
	}

	public void setGodPeticione2(GodPeticiones godPeticione2) {
		this.godPeticione2 = godPeticione2;
	}

	public List<GodTrazaEstadoPet> getGodTrazaEstadoPets() {
		return this.godTrazaEstadoPets;
	}

	public void setGodTrazaEstadoPets(List<GodTrazaEstadoPet> godTrazaEstadoPets) {
		this.godTrazaEstadoPets = godTrazaEstadoPets;
	}

	public GodTrazaEstadoPet addGodTrazaEstadoPet(GodTrazaEstadoPet godTrazaEstadoPet) {
		getGodTrazaEstadoPets().add(godTrazaEstadoPet);
		godTrazaEstadoPet.setGodPeticione(this);

		return godTrazaEstadoPet;
	}

	public GodTrazaEstadoPet removeGodTrazaEstadoPet(GodTrazaEstadoPet godTrazaEstadoPet) {
		getGodTrazaEstadoPets().remove(godTrazaEstadoPet);
		godTrazaEstadoPet.setGodPeticione(null);

		return godTrazaEstadoPet;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	

}