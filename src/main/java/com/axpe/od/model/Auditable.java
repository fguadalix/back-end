package com.axpe.od.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@CreatedBy
	protected String createdBy;

	@CreatedDate
	@Temporal(TIMESTAMP)
	protected Date creationDate;

	@LastModifiedBy
	protected String lastModifiedBy;

	@LastModifiedDate
	@Temporal(TIMESTAMP)
	protected Date lastModifiedDate;
}
