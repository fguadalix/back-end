package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_empr_grupo database table.
 * 
 */
@Entity
@Table(name="cat_empr_grupo", schema="monolito_god")
@NamedQuery(name="CatEmprGrupo.findAll", query="SELECT c FROM CatEmprGrupo c")
public class CatEmprGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdempresa;

	private String cdpostal;

	private Integer cdproyecto;

	private String cdsagex3;

	private Integer cdusuario;

	private String cif;

	private String codempresa;

	private String correo;

	private String domicilio;

	private String dsempresa;

	@Column(name="dsreg_mercantil")
	private String dsregMercantil;

	private String fax;

	private Timestamp fealta;

	@Column(name="fecha_iva")
	private Integer fechaIva;

	private Timestamp femodificacion;

	private String municipio;

	private String telefono;

	//bi-directional many-to-one association to CatPais
	@ManyToOne
	@JoinColumn(name="cdpais")
	private CatPais catPais;

	//bi-directional many-to-one association to CatProvincia
	@ManyToOne
	@JoinColumn(name="cdprov")
	private CatProvincia catProvincia;

	//bi-directional many-to-one association to CatUnidadNegocio
	@OneToMany(mappedBy="catEmprGrupo")
	private List<CatUnidadNegocio> catUnidadNegocios;

	public CatEmprGrupo() {
	}

	public Integer getCdempresa() {
		return this.cdempresa;
	}

	public void setCdempresa(Integer cdempresa) {
		this.cdempresa = cdempresa;
	}

	public String getCdpostal() {
		return this.cdpostal;
	}

	public void setCdpostal(String cdpostal) {
		this.cdpostal = cdpostal;
	}

	public Integer getCdproyecto() {
		return this.cdproyecto;
	}

	public void setCdproyecto(Integer cdproyecto) {
		this.cdproyecto = cdproyecto;
	}

	public String getCdsagex3() {
		return this.cdsagex3;
	}

	public void setCdsagex3(String cdsagex3) {
		this.cdsagex3 = cdsagex3;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getCodempresa() {
		return this.codempresa;
	}

	public void setCodempresa(String codempresa) {
		this.codempresa = codempresa;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDsempresa() {
		return this.dsempresa;
	}

	public void setDsempresa(String dsempresa) {
		this.dsempresa = dsempresa;
	}

	public String getDsregMercantil() {
		return this.dsregMercantil;
	}

	public void setDsregMercantil(String dsregMercantil) {
		this.dsregMercantil = dsregMercantil;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Timestamp getFealta() {
		return this.fealta;
	}

	public void setFealta(Timestamp fealta) {
		this.fealta = fealta;
	}

	public Integer getFechaIva() {
		return this.fechaIva;
	}

	public void setFechaIva(Integer fechaIva) {
		this.fechaIva = fechaIva;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public CatPais getCatPais() {
		return this.catPais;
	}

	public void setCatPais(CatPais catPais) {
		this.catPais = catPais;
	}

	public CatProvincia getCatProvincia() {
		return this.catProvincia;
	}

	public void setCatProvincia(CatProvincia catProvincia) {
		this.catProvincia = catProvincia;
	}

	public List<CatUnidadNegocio> getCatUnidadNegocios() {
		return this.catUnidadNegocios;
	}

	public void setCatUnidadNegocios(List<CatUnidadNegocio> catUnidadNegocios) {
		this.catUnidadNegocios = catUnidadNegocios;
	}

	public CatUnidadNegocio addCatUnidadNegocio(CatUnidadNegocio catUnidadNegocio) {
		getCatUnidadNegocios().add(catUnidadNegocio);
		catUnidadNegocio.setCatEmprGrupo(this);

		return catUnidadNegocio;
	}

	public CatUnidadNegocio removeCatUnidadNegocio(CatUnidadNegocio catUnidadNegocio) {
		getCatUnidadNegocios().remove(catUnidadNegocio);
		catUnidadNegocio.setCatEmprGrupo(null);

		return catUnidadNegocio;
	}

}