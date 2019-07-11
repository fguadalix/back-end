package com.axpe.od.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="god_agenda",schema="monolito_god")
@NamedQuery(name="GodAgenda.findAll", query="SELECT g FROM GodAgenda g")
public class GodAgenda implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer agendaid;

	private String text;
	
	private boolean marked;
	
	private String username;
	

	public GodAgenda() {
		super();
	}

	public GodAgenda(String text, boolean marked, String username) {
		super();
		this.text = text;
		this.marked = marked;
		this.username = username;
	}

	public Integer getAgendaid() {
		return agendaid;
	}

	public void setAgendaid(Integer agendaid) {
		this.agendaid = agendaid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
