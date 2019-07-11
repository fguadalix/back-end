package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the log_login_sgod database table.
 * 
 */
@Entity
@Table(name="log_login_sgod")
@NamedQuery(name="LogLoginSgod.findAll", query="SELECT l FROM LogLoginSgod l")
public class LogLoginSgod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_login")
	private Integer cdLogin;

	@Column(name="documento_ident")
	private String documentoIdent;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	@Column(name="ip_maquina_client")
	private String ipMaquinaClient;

	@Column(name="login_correcto")
	private Integer loginCorrecto;

	private String mensaje;

	private String usuario;

	public LogLoginSgod() {
	}

	public Integer getCdLogin() {
		return this.cdLogin;
	}

	public void setCdLogin(Integer cdLogin) {
		this.cdLogin = cdLogin;
	}

	public String getDocumentoIdent() {
		return this.documentoIdent;
	}

	public void setDocumentoIdent(String documentoIdent) {
		this.documentoIdent = documentoIdent;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIpMaquinaClient() {
		return this.ipMaquinaClient;
	}

	public void setIpMaquinaClient(String ipMaquinaClient) {
		this.ipMaquinaClient = ipMaquinaClient;
	}

	public Integer getLoginCorrecto() {
		return this.loginCorrecto;
	}

	public void setLoginCorrecto(Integer loginCorrecto) {
		this.loginCorrecto = loginCorrecto;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}