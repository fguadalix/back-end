package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_peti_tecnico database table.
 * 
 */
@Entity
@Table(name="god_peti_tecnico")
@NamedQuery(name="GodPetiTecnico.findAll", query="SELECT g FROM GodPetiTecnico g")
public class GodPetiTecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GodPetiTecnicoPK id;

	@Column(name="cdusuario_asignacion")
	private Integer cdusuarioAsignacion;

	@Column(name="cdusuario_modificacion")
	private Integer cdusuarioModificacion;

	@Column(name="cv_comprados")
	private Integer cvComprados;

	private Integer deleted;

	private Timestamp fcasignacion;

	private Timestamp fcmodificacion;

	@Column(name="ofertas_publicadas")
	private Integer ofertasPublicadas;

	public GodPetiTecnico() {
	}

	public GodPetiTecnicoPK getId() {
		return this.id;
	}

	public void setId(GodPetiTecnicoPK id) {
		this.id = id;
	}

	public Integer getCdusuarioAsignacion() {
		return this.cdusuarioAsignacion;
	}

	public void setCdusuarioAsignacion(Integer cdusuarioAsignacion) {
		this.cdusuarioAsignacion = cdusuarioAsignacion;
	}

	public Integer getCdusuarioModificacion() {
		return this.cdusuarioModificacion;
	}

	public void setCdusuarioModificacion(Integer cdusuarioModificacion) {
		this.cdusuarioModificacion = cdusuarioModificacion;
	}

	public Integer getCvComprados() {
		return this.cvComprados;
	}

	public void setCvComprados(Integer cvComprados) {
		this.cvComprados = cvComprados;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Timestamp getFcasignacion() {
		return this.fcasignacion;
	}

	public void setFcasignacion(Timestamp fcasignacion) {
		this.fcasignacion = fcasignacion;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public Integer getOfertasPublicadas() {
		return this.ofertasPublicadas;
	}

	public void setOfertasPublicadas(Integer ofertasPublicadas) {
		this.ofertasPublicadas = ofertasPublicadas;
	}

}