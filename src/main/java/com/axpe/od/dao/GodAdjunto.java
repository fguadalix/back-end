package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_adjuntos database table.
 * 
 */
@Entity
@Table(name="god_adjunto",schema="monolito_god")
@NamedQuery(name="GodAdjunto.findAll", query="SELECT g FROM GodAdjunto g")
public class GodAdjunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer fileid;

	private String createdby;

	private Timestamp creationdate;

	private byte[] datos;

	private String filename;

	private String filetype;

	private Timestamp lastmodifiedby;

	private Timestamp lastmodifieddate;

	private Integer positionid;

	private Integer professionalid;

	public GodAdjunto() {
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Timestamp getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Timestamp creationdate) {
		this.creationdate = creationdate;
	}

	public byte[] getDatos() {
		return this.datos;
	}

	public void setDatos(byte[] datos) {
		this.datos = datos;
	}

	public Integer getFileid() {
		return this.fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public Timestamp getLastmodifiedby() {
		return this.lastmodifiedby;
	}

	public void setLastmodifiedby(Timestamp lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}

	public Timestamp getLastmodifieddate() {
		return this.lastmodifieddate;
	}

	public void setLastmodifieddate(Timestamp lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}

	public Integer getPositionid() {
		return this.positionid;
	}

	public void setPositionid(Integer positionid) {
		this.positionid = positionid;
	}

	public Integer getProfessionalid() {
		return this.professionalid;
	}

	public void setProfessionalid(Integer professionalid) {
		this.professionalid = professionalid;
	}

}