package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_estado_contacto database table.
 * 
 */
@Entity
@Table(name="cat_estado_contacto", schema="monolito_god")
@NamedQuery(name="CatEstadoContacto.findAll", query="SELECT c FROM CatEstadoContacto c")
public class CatEstadoContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdestado_contac")
	private Integer cdestadoContac;

	private Integer cdusuario;

	@Column(name="dsestado_contac")
	private String dsestadoContac;

	private Timestamp fcmodificacion;

	//bi-directional many-to-one association to GodHContacto
	@OneToMany(mappedBy="catEstadoContacto")
	private List<GodHContacto> godHContactos;

	public CatEstadoContacto() {
	}

	public Integer getCdestadoContac() {
		return this.cdestadoContac;
	}

	public void setCdestadoContac(Integer cdestadoContac) {
		this.cdestadoContac = cdestadoContac;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsestadoContac() {
		return this.dsestadoContac;
	}

	public void setDsestadoContac(String dsestadoContac) {
		this.dsestadoContac = dsestadoContac;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public List<GodHContacto> getGodHContactos() {
		return this.godHContactos;
	}

	public void setGodHContactos(List<GodHContacto> godHContactos) {
		this.godHContactos = godHContactos;
	}

	public GodHContacto addGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().add(godHContacto);
		godHContacto.setCatEstadoContacto(this);

		return godHContacto;
	}

	public GodHContacto removeGodHContacto(GodHContacto godHContacto) {
		getGodHContactos().remove(godHContacto);
		godHContacto.setCatEstadoContacto(null);

		return godHContacto;
	}

}