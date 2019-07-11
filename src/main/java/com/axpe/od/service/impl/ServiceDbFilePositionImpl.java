package com.axpe.od.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodAdjunto;
import com.axpe.od.mapper.MapperDbFilePosition;
import com.axpe.od.model.DBFile;
import com.axpe.od.repository.GodAdjuntoRepository;

@Service
public class ServiceDbFilePositionImpl {

	@Autowired
	GodAdjuntoRepository godAdjuntoRepository;



	public List<DBFile> convertTolist(List<GodAdjunto> listAdjunto) {

		return null;

	}

	public List<DBFile> listByPositionId(Long positionId) {

		int id = (int)(long)positionId;
		List<GodAdjunto> ListaAdjunto = godAdjuntoRepository.listByPosition(id);
		List<DBFile> listFile=   MapperDbFilePosition.listAdjuntosToListDBFile(ListaAdjunto);

		return listFile;
	}
}
