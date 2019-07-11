package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cat_forma_pago database table.
 * 
 */
@Entity
@Table(name="cat_forma_pago", schema="monolito_god")
@NamedQuery(name="CatFormaPago.findAll", query="SELECT c FROM CatFormaPago c")
public class CatFormaPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdforma_pago")
	private Integer cdformaPago;

	private Integer cdusuario;

	@Column(name="dsforma_pago")
	private String dsformaPago;

	private Timestamp femodificacion;

	public CatFormaPago() {
	}

	public Integer getCdformaPago() {
		return this.cdformaPago;
	}

	public void setCdformaPago(Integer cdformaPago) {
		this.cdformaPago = cdformaPago;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getDsformaPago() {
		return this.dsformaPago;
	}

	public void setDsformaPago(String dsformaPago) {
		this.dsformaPago = dsformaPago;
	}

	public Timestamp getFemodificacion() {
		return this.femodificacion;
	}

	public void setFemodificacion(Timestamp femodificacion) {
		this.femodificacion = femodificacion;
	}

}