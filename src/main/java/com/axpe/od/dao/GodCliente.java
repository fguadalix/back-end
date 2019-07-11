package com.axpe.od.dao;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name="god_cliente", schema="monolito_god")
@Indexed
@NamedQuery(name="GodCliente.findAll", query="SELECT c FROM GodCliente c")
public class GodCliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="client_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer clienteid;
	
	@Column(name="creation_date")
	private Timestamp creationdate;

	@Column(name="last_modified_date")
	private Timestamp lastmodifieddate;
	
	@Column(name="last_modified_by")
	private String lastmodifiedby;
	
	@Column(name="created_by")
	private String createdby;

	private String client;

	public Integer getClienteid() {
		return clienteid;
	}

	public void setClienteid(Integer clienteid) {
		this.clienteid = clienteid;
	}

	public Timestamp getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Timestamp creationdate) {
		this.creationdate = creationdate;
	}

	public Timestamp getLastmodifieddate() {
		return lastmodifieddate;
	}

	public void setLastmodifieddate(Timestamp lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}

	public String getLastmodifiedby() {
		return lastmodifiedby;
	}

	public void setLastmodifiedby(String lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
}
