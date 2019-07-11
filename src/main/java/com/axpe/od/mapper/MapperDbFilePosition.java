package com.axpe.od.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.axpe.od.dao.GodAdjunto;
import com.axpe.od.model.DBFile;

public class MapperDbFilePosition {

	@SuppressWarnings("null")
	public static List<DBFile> listAdjuntosToListDBFile ( List<GodAdjunto> listFile){
	
		
		List<DBFile> listDbfile = new ArrayList <> ();
		for (GodAdjunto attached: listFile) {
			try {
			
			//DBFile file = new DBFile();
			DBFile	file = DBFile.builder().build();
			
			file.setFileId((long) (int) attached.getFileid());
			file.setFileName(attached.getFilename());				
			file.setFileType(attached.getFiletype());
			file.setPosition(attached.getPositionid());
			
			
			if (attached.getDatos() != null) {					
					file.setData(attached.getDatos());
					listDbfile.add(file);	
				} 
			else {
				String vacio = "";
				byte[] by = vacio.getBytes();
				file.setData(by);	
			}
			listDbfile.add(file);			
			System.out.println("se  añade uno");
			}		
			catch (NullPointerException e) {
				//		String vacio = "";
				//		byte[] by = vacio.getBytes();
				//		file.setData(by);		
				System.out.println("es vacio");
				continue;
			}
			
		}
		return listDbfile;
		 
	
	}
	
	public static DBFile FileToGodadjunto(GodAdjunto attached) {

		DBFile file = null;

		file.setFileId((long)(int)attached.getFileid());
		file.setData(attached.getDatos());
		file.setFileType(attached.getFiletype());
		file.setPosition(attached.getPositionid());

		Optional<String> fileName = Optional.of(attached.getFilename());
		if (fileName.isPresent()) {
			file.setFileName(fileName.get());
		} else {
			file.setFileName("");
		}

		// ejemplo de optional-- fileName.ifPresent(file.setFileName(fileName.get());

		return file;

	}

}
