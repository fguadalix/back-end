package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cat_tipo_herramienta database table.
 * 
 */
@Entity
@Table(name="cat_tipo_herramienta", schema="monolito_god")
@NamedQuery(name="CatTipoHerramienta.findAll", query="SELECT c FROM CatTipoHerramienta c")
public class CatTipoHerramienta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_herram")
	private Integer cdtipoHerram;

	private Integer cdusuario;

	@Column(name="dstipo_herram")
	private String dstipoHerram;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to CatHerramienta
	@OneToMany(mappedBy="catTipoHerramienta")
	private List<CatHerramienta> catHerramientas;

	public CatTipoHerramienta() {
	}

	public Integer getCdtipoHerram() {
		return this.cdtipoHerram;
	}

	public void setCdtipoHerram(Integer cdtipoHerram) {
		this.cdtipoHerram = cdtipoHerram;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDstipoHerram() {
		return this.dstipoHerram;
	}

	public void setDstipoHerram(String dstipoHerram) {
		this.dstipoHerram = dstipoHerram;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<CatHerramienta> getCatHerramientas() {
		return this.catHerramientas;
	}

	public void setCatHerramientas(List<CatHerramienta> catHerramientas) {
		this.catHerramientas = catHerramientas;
	}

	public CatHerramienta addCatHerramienta(CatHerramienta catHerramienta) {
		getCatHerramientas().add(catHerramienta);
		catHerramienta.setCatTipoHerramienta(this);

		return catHerramienta;
	}

	public CatHerramienta removeCatHerramienta(CatHerramienta catHerramienta) {
		getCatHerramientas().remove(catHerramienta);
		catHerramienta.setCatTipoHerramienta(null);

		return catHerramienta;
	}

}