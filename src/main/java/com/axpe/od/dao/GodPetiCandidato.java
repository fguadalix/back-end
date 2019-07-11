package com.axpe.od.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the god_peti_candidato database table.
 * 
 */
@Entity
@Table(name="god_peti_candidato", schema="monolito_god")
@NamedQuery(name="GodPetiCandidato.findAll", query="SELECT g FROM GodPetiCandidato g")
public class GodPetiCandidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GodPetiCandidatoPK id;

	@Column(name="ajuste_previo", columnDefinition="int2(5)")
	private Integer ajustePrevio;

	private Integer cancelado;

	private Integer cdempleado;

	@Column(name="cdestado_recruiting")
	private Integer cdestadoRecruiting;

	@Column(name="cdmotivo_cancelado")
	private Integer cdmotivoCancelado;

	@Column(name="cdmotivo_nofit")
	private Integer cdmotivoNofit;

	@Column(name="cdorigen_cand")
	private Integer cdorigenCand;

	private Integer cdusuario;

	private String comentarios;

	private Integer deleted;

	@Column(name="entrevista", columnDefinition="int2(5)")
	private Integer entrevista;

	@Column(name="entrevista_cliente", columnDefinition="int2(5)")
	private Integer entrevistaCliente;

	private Integer excluido;

	private Timestamp fcasignacion;

	private Timestamp fcasignado;

	private Timestamp fccontratado;

	private Timestamp fcenviadocliente;

	private Timestamp fcenviadogerencia;

	private Timestamp fcincorporado;

	private Timestamp fcmodificacion;

	private Integer inmails;

	@Column(name="llamadas_atendidas")
	private Integer llamadasAtendidas;

	@Column(name="llamadas_realizadas")
	private Integer llamadasRealizadas;

	private Integer mails;

	@Column(name="mensaje", columnDefinition="int2(5)")
	private Integer mensaje;

	@Column(name="primera_llamada", columnDefinition="int2(5)")
	private Integer primeraLlamada;

	@Column(name="segunda_llamada", columnDefinition="int2(5)")
	private Integer segundaLlamada;

	public GodPetiCandidato() {
	}

	public GodPetiCandidatoPK getId() {
		return this.id;
	}

	public void setId(GodPetiCandidatoPK id) {
		this.id = id;
	}

	public Integer getAjustePrevio() {
		return this.ajustePrevio;
	}

	public void setAjustePrevio(Integer ajustePrevio) {
		this.ajustePrevio = ajustePrevio;
	}

	public Integer getCancelado() {
		return this.cancelado;
	}

	public void setCancelado(Integer cancelado) {
		this.cancelado = cancelado;
	}

	public Integer getCdempleado() {
		return this.cdempleado;
	}

	public void setCdempleado(Integer cdempleado) {
		this.cdempleado = cdempleado;
	}

	public Integer getCdestadoRecruiting() {
		return this.cdestadoRecruiting;
	}

	public void setCdestadoRecruiting(Integer cdestadoRecruiting) {
		this.cdestadoRecruiting = cdestadoRecruiting;
	}

	public Integer getCdmotivoCancelado() {
		return this.cdmotivoCancelado;
	}

	public void setCdmotivoCancelado(Integer cdmotivoCancelado) {
		this.cdmotivoCancelado = cdmotivoCancelado;
	}

	public Integer getCdmotivoNofit() {
		return this.cdmotivoNofit;
	}

	public void setCdmotivoNofit(Integer cdmotivoNofit) {
		this.cdmotivoNofit = cdmotivoNofit;
	}

	public Integer getCdorigenCand() {
		return this.cdorigenCand;
	}

	public void setCdorigenCand(Integer cdorigenCand) {
		this.cdorigenCand = cdorigenCand;
	}

	public Integer getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(Integer cdusuario) {
		this.cdusuario = cdusuario;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getEntrevista() {
		return this.entrevista;
	}

	public void setEntrevista(Integer entrevista) {
		this.entrevista = entrevista;
	}

	public Integer getEntrevistaCliente() {
		return this.entrevistaCliente;
	}

	public void setEntrevistaCliente(Integer entrevistaCliente) {
		this.entrevistaCliente = entrevistaCliente;
	}

	public Integer getExcluido() {
		return this.excluido;
	}

	public void setExcluido(Integer excluido) {
		this.excluido = excluido;
	}

	public Timestamp getFcasignacion() {
		return this.fcasignacion;
	}

	public void setFcasignacion(Timestamp fcasignacion) {
		this.fcasignacion = fcasignacion;
	}

	public Timestamp getFcasignado() {
		return this.fcasignado;
	}

	public void setFcasignado(Timestamp fcasignado) {
		this.fcasignado = fcasignado;
	}

	public Timestamp getFccontratado() {
		return this.fccontratado;
	}

	public void setFccontratado(Timestamp fccontratado) {
		this.fccontratado = fccontratado;
	}

	public Timestamp getFcenviadocliente() {
		return this.fcenviadocliente;
	}

	public void setFcenviadocliente(Timestamp fcenviadocliente) {
		this.fcenviadocliente = fcenviadocliente;
	}

	public Timestamp getFcenviadogerencia() {
		return this.fcenviadogerencia;
	}

	public void setFcenviadogerencia(Timestamp fcenviadogerencia) {
		this.fcenviadogerencia = fcenviadogerencia;
	}

	public Timestamp getFcincorporado() {
		return this.fcincorporado;
	}

	public void setFcincorporado(Timestamp fcincorporado) {
		this.fcincorporado = fcincorporado;
	}

	public Timestamp getFcmodificacion() {
		return this.fcmodificacion;
	}

	public void setFcmodificacion(Timestamp fcmodificacion) {
		this.fcmodificacion = fcmodificacion;
	}

	public Integer getInmails() {
		return this.inmails;
	}

	public void setInmails(Integer inmails) {
		this.inmails = inmails;
	}

	public Integer getLlamadasAtendidas() {
		return this.llamadasAtendidas;
	}

	public void setLlamadasAtendidas(Integer llamadasAtendidas) {
		this.llamadasAtendidas = llamadasAtendidas;
	}

	public Integer getLlamadasRealizadas() {
		return this.llamadasRealizadas;
	}

	public void setLlamadasRealizadas(Integer llamadasRealizadas) {
		this.llamadasRealizadas = llamadasRealizadas;
	}

	public Integer getMails() {
		return this.mails;
	}

	public void setMails(Integer mails) {
		this.mails = mails;
	}

	public Integer getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(Integer mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getPrimeraLlamada() {
		return this.primeraLlamada;
	}

	public void setPrimeraLlamada(Integer primeraLlamada) {
		this.primeraLlamada = primeraLlamada;
	}

	public Integer getSegundaLlamada() {
		return this.segundaLlamada;
	}

	public void setSegundaLlamada(Integer segundaLlamada) {
		this.segundaLlamada = segundaLlamada;
	}

}