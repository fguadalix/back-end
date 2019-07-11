package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the god_tipo_req_herram database table.
 * 
 */
@Entity
@Table(name="god_tipo_req_herram", schema = "monolito_god")
@NamedQuery(name="GodTipoReqHerram.findAll", query="SELECT g FROM GodTipoReqHerram g")
public class GodTipoReqHerram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_req_herram")
	private Integer cdtipoReqHerram;

	private Integer cdusuario;

	private Integer deleted;

	@Column(name="dstipo_req_herram")
	private String dstipoReqHerram;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to GodPeticionHerram
	@OneToMany(mappedBy="godTipoReqHerram")
	private List<GodPeticionHerram> godPeticionHerrams;

	public GodTipoReqHerram() {
	}

	public Integer getCdtipoReqHerram() {
		return this.cdtipoReqHerram;
	}

	public void setCdtipoReqHerram(Integer cdtipoReqHerram) {
		this.cdtipoReqHerram = cdtipoReqHerram;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getDstipoReqHerram() {
		return this.dstipoReqHerram;
	}

	public void setDstipoReqHerram(String dstipoReqHerram) {
		this.dstipoReqHerram = dstipoReqHerram;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public List<GodPeticionHerram> getGodPeticionHerrams() {
		return this.godPeticionHerrams;
	}

	public void setGodPeticionHerrams(List<GodPeticionHerram> godPeticionHerrams) {
		this.godPeticionHerrams = godPeticionHerrams;
	}

	public GodPeticionHerram addGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().add(godPeticionHerram);
		godPeticionHerram.setGodTipoReqHerram(this);

		return godPeticionHerram;
	}

	public GodPeticionHerram removeGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().remove(godPeticionHerram);
		godPeticionHerram.setGodTipoReqHerram(null);

		return godPeticionHerram;
	}

}