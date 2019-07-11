package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the god_idiomas_prof database table.
 * 
 */
@Entity
@Table(name="god_idiomas_prof", schema="monolito_god")
@NamedQuery(name="GodIdiomasProf.findAll", query="SELECT g FROM GodIdiomasProf g")
public class GodIdiomasProf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdidiomas_prof")
	private Integer cdidiomasProf;

	private Integer cdidioma;

	@Column(name="cdnivel_conoc")
	private Integer cdnivelConoc;

	private Integer cdprofesional;

	private Integer deleted;

	public GodIdiomasProf() {
	}

	public Integer getCdidiomasProf() {
		return this.cdidiomasProf;
	}

	public void setCdidiomasProf(Integer cdidiomasProf) {
		this.cdidiomasProf = cdidiomasProf;
	}

	public Integer getCdidioma() {
		return this.cdidioma;
	}

	public void setCdidioma(Integer cdidioma) {
		this.cdidioma = cdidioma;
	}

	public Integer getCdnivelConoc() {
		return this.cdnivelConoc;
	}

	public void setCdnivelConoc(Integer cdnivelConoc) {
		this.cdnivelConoc = cdnivelConoc;
	}

	public Integer getCdprofesional() {
		return this.cdprofesional;
	}

	public void setCdprofesional(Integer cdprofesional) {
		this.cdprofesional = cdprofesional;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}