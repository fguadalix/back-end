package com.axpe.od.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DBFile extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long fileId;

	private String fileName;

	private String fileType;

	private byte[] data;

//	@JsonIgnore
//	private Professional professional;
//
//	@JsonIgnore
//	private Position position;

	@JsonIgnore
	private Integer professional;

	@JsonIgnore
	private Integer position;

	public DBFile(String fileName, String fileType, byte[] data) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
}
