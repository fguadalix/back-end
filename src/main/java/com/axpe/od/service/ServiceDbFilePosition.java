package com.axpe.od.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.axpe.od.model.DBFile;



@Service
public interface ServiceDbFilePosition {
	

	public List<DBFile> listByPositionId(Long positionId);

}
