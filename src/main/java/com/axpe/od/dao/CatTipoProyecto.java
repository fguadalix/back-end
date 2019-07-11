package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_proyecto database table.
 * 
 */
@Entity
@Table(name="cat_tipo_proyecto", schema="monolito_god")
@NamedQuery(name="CatTipoProyecto.findAll", query="SELECT c FROM CatTipoProyecto c")
public class CatTipoProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_proyecto")
	private Integer cdtipoProyecto;

	private String cdsagex3;

	private Integer cdusuario;

	@Column(name="dstipo_proyecto")
	private String dstipoProyecto;

	private Timestamp femodificacion;

	public CatTipoProyecto() {
	}

	public Integer getCdtipoProyecto() {
		return this.cdtipoProyecto;
	}

	public void setCdtipoProyecto(Integer cdtipoProyecto) {
		this.cdtipoProyecto = cdtipoProyecto;
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

	public String getDstipoProyecto() {
		return this.dstipoProyecto;
	}

	public void setDstipoProyecto(String dstipoProyecto) {
		this.dstipoProyecto = dstipoProyecto;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}