package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_tipo_contrato_new database table.
 * 
 */
@Entity
@Table(name="cat_tipo_contrato_new", schema="monolito_god")
@NamedQuery(name="CatTipoContratoNew.findAll", query="SELECT c FROM CatTipoContratoNew c")
public class CatTipoContratoNew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdtipo_contrato")
	private Integer cdtipoContrato;

	private Integer cdusuario;

	@Column(name="cod_contrato")
	private Integer codContrato;

	@Column(name="dstipo_contrato")
	private String dstipoContrato;

	private Timestamp femodificacion;

	@Column(name="sub_contrato")
	private Integer subContrato;

	public CatTipoContratoNew() {
	}

	public Integer getCdtipoContrato() {
		return this.cdtipoContrato;
	}

	public void setCdtipoContrato(Integer cdtipoContrato) {
		this.cdtipoContrato = cdtipoContrato;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public Integer getCodContrato() {
		return this.codContrato;
	}

	public void setCodContrato(Integer codContrato) {
		this.codContrato = codContrato;
	}

	public String getDstipoContrato() {
		return this.dstipoContrato;
	}

	public void setDstipoContrato(String dstipoContrato) {
		this.dstipoContrato = dstipoContrato;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

	public Integer getSubContrato() {
		return this.subContrato;
	}

	public void setSubContrato(Integer subContrato) {
		this.subContrato = subContrato;
	}

}