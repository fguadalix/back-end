package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the god_tipo_perfil database table.
 * 
 */
@Entity
@Table(name="god_tipo_perfil", schema = "monolito_god")
@NamedQuery(name="GodTipoPerfil.findAll", query="SELECT g FROM GodTipoPerfil g")
public class GodTipoPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_perfil")
	private Integer cdtipoPerfil;

	private Integer cdusuario;

	private Integer deleted;

	@Column(name="dstipo_perfil")
	private String dstipoPerfil;

	private Timestamp femodificacion;

	//bi-directional many-to-one association to GodPeticionHerram
	@OneToMany(mappedBy="godTipoPerfil")
	private List<GodPeticionHerram> godPeticionHerrams;

	//bi-directional many-to-one association to GodProfesHerram
	@OneToMany(mappedBy="godTipoPerfil")
	private List<GodProfesHerram> godProfesHerrams;

	public GodTipoPerfil() {
	}

	public Integer getCdtipoPerfil() {
		return this.cdtipoPerfil;
	}

	public void setCdtipoPerfil(Integer cdtipoPerfil) {
		this.cdtipoPerfil = cdtipoPerfil;
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

	public String getDstipoPerfil() {
		return this.dstipoPerfil;
	}

	public void setDstipoPerfil(String dstipoPerfil) {
		this.dstipoPerfil = dstipoPerfil;
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
		godPeticionHerram.setGodTipoPerfil(this);

		return godPeticionHerram;
	}

	public GodPeticionHerram removeGodPeticionHerram(GodPeticionHerram godPeticionHerram) {
		getGodPeticionHerrams().remove(godPeticionHerram);
		godPeticionHerram.setGodTipoPerfil(null);

		return godPeticionHerram;
	}

	public List<GodProfesHerram> getGodProfesHerrams() {
		return this.godProfesHerrams;
	}

	public void setGodProfesHerrams(List<GodProfesHerram> godProfesHerrams) {
		this.godProfesHerrams = godProfesHerrams;
	}

	public GodProfesHerram addGodProfesHerram(GodProfesHerram godProfesHerram) {
		getGodProfesHerrams().add(godProfesHerram);
		godProfesHerram.setGodTipoPerfil(this);

		return godProfesHerram;
	}

	public GodProfesHerram removeGodProfesHerram(GodProfesHerram godProfesHerram) {
		getGodProfesHerrams().remove(godProfesHerram);
		godProfesHerram.setGodTipoPerfil(null);

		return godProfesHerram;
	}

}