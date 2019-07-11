package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the god_usuarios_roles database table.
 * 
 */
@Entity
@Table(name="god_usuarios_roles")
@NamedQuery(name="GodUsuariosRole.findAll", query="SELECT g FROM GodUsuariosRole g")
public class GodUsuariosRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer cdrol;

	private String dsrol;

	public GodUsuariosRole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCdrol() {
		return this.cdrol;
	}

	public void setCdrol(Integer cdrol) {
		this.cdrol = cdrol;
	}

	public String getDsrol() {
		return this.dsrol;
	}

	public void setDsrol(String dsrol) {
		this.dsrol = dsrol;
	}

}