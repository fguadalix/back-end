package com.axpe.od.dao;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the cat_tags database table.
 * 
 */
@Entity
@Table(name="cat_tags", schema="monolito_god")
@NamedQuery(name="CatTag.findAll", query="SELECT c FROM CatTag c")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cdtag;

	private Integer cdusuario;

	private String dstag;

	private Timestamp femodificacion;

	

}