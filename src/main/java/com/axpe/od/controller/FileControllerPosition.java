package com.axpe.od.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.exceptions.FileFormatException;
import com.axpe.od.exceptions.FileStorageException;
import com.axpe.od.exceptions.MyFileNotFoundException;
import com.axpe.od.model.DBFile;
import com.axpe.od.repository.PositionRepository;
import com.axpe.od.service.impl.ServiceDbFilePositionImpl;

@RestController
@RequestMapping(value = "/v1/files/", produces = "application/hal+json")
public class FileControllerPosition {

	/* Lista de formatos permitidos para la subida del documentos */
	private static final String[] ALLOWED_FILE_TYPES = { "application/msword", "application/pdf",
			"application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
			"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" };

	private ServiceDbFilePositionImpl serviceDbFilePositionImpl;

	@Autowired
	public FileControllerPosition(ServiceDbFilePositionImpl serviceDbFilePositionImpl) {

		this.serviceDbFilePositionImpl = serviceDbFilePositionImpl;

	}

	 /***
	 * Lista los archivos de una peticion, en la BDreal una peticion tiene un adju (oneToOne)
	 * En la BDinicial una peticion puede ter  varios adjuntos
	 * ESTE ENDPOINT NO SE PUEDE IMPLEMENTAR PORQUE SOLO HAY UN DOC POR PETICION
	 * 
	 * @param positionlId
	 * @return lista de archivos File
	 */

	@GetMapping("/position/{positionId}/list")
	public  ResponseEntity<List<DBFile>> getAllFilesMetadata(@PathVariable Long positionId) {
	//	public  List<DBFile> getAllFilesMetadata(@PathVariable Long positionId) {
		// return dbFileRepository.findByPosition_PositionId(positionId);
		//return serviceDbFilePositionImpl.listByPositionId(positionId);		
		
		return  new  ResponseEntity<List<DBFile>>( serviceDbFilePositionImpl.listByPositionId(positionId), HttpStatus.OK); 
	}
	
	
	  
//
//	 @GetMapping("/position/{positionId}/file/{fileId}")
//	  public ResponseEntity<Resource> downloadFile(
//	      @PathVariable Long positionId, @PathVariable Long fileId) {
//
//		 /*comprobaos si existe el profesional*/
//	    Optional<Position> position = positionRepository.findById(positionId);
//	    if (!position.isPresent()) {
//	      throw new EntityNotFoundException(
//	          String.format("Position with id %d not found", positionId));
//	    }
//	    /*Si existe, buscamos el fichero de ese profesional */
//	    Optional<DBFile> responsefile = dbFileRepository
//	        .findByFileIdAndPosition_PositionId(fileId, positionId);
//	    if (!responsefile.isPresent()) {
//	      throw new MyFileNotFoundException("File not found with id " + fileId);
//	    }
//	    return ResponseEntity.ok()
//	        .contentType(MediaType.parseMediaType(responsefile.get().getFileType()))
//	        .header(
//	            HttpHeaders.CONTENT_DISPOSITION,
//	            "attachment; filename=\"" + responsefile.get().getFileName() + "\"")
//	        .body(new ByteArrayResource(responsefile.get().getData()));
//	  }
//	  
//	

//
//		
//	@GetMapping("/position/{positionId}")	 
//	public ResponseEntity <Resource> getAllFilesMetadata(@PathVariable Long positionId) {
//		
//	
//				 DBFile dbfile = serviceDbFilePositionImpl.getFileByIdPosition(positionId);
//		// return dbFileRepository.findByPosition_PositionId(positionId);
//
//		return null;
//	}
//	
	

	
	 
}
	  
	
//	  /***
//	   * METODOS PARA SUBIR UN DOCUMENTO A UN POSITION EN CONCRETO
//	   * @param file
//	   * @param professionalId
//	   * @return
//	   * @throws IOException
//	   */  
//	  
//	  @PostMapping(value = "/position/{positionId}/file")
//	  public ResponseEntity<?> uploadFile(
//	      @RequestParam("file") MultipartFile file, @PathVariable Long positionId)
//	      throws IOException {
//
//		  /*Primero comprobamos si la posicion  existe.*/ 
//	    Optional<Position> position = positionRepository.findById(positionId);
//	    if (!position.isPresent()) {
//	      throw new EntityNotFoundException(
//	          String.format("Position with id %d not found", positionId));
//	    }
//
//	    /* Comprobamos que el tipo de contenido se pueda subir  y 
//	     * obtenemos el nombre del fichero */
//	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//	    String contentType = Objects.requireNonNull(file.getContentType()).toLowerCase();
//	    if (!Arrays.asList(ALLOWED_FILE_TYPES).contains(contentType)) {
//	      throw new FileFormatException(
//	          String.format(
//	              "Format file not allowed, only allowed %s", Arrays.toString(ALLOWED_FILE_TYPES)));
//	    }
//	    
//	    /* Creamos el objeto documento*/
//	    DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
//	    dbFile.setPosition(position.get());
//	    position.get().setHasFiles(true);
//	    dbFileRepository.save(dbFile);
//	    positionRepository.save(position.get());
//
//	    return ResponseEntity.ok().build();
//	  }
//	  
//	  /***
//	   *  Subir varios adjuntos
//	   * 
//	   * @param files
//	   * @param positionId
//	   * @return
//	   */
//	  
//	  @PostMapping("/position/{positionId}/uploadMultipleFiles")
//	  public ResponseEntity<?> uploadMultipleFiles(@RequestParam MultipartFile[]
//	      files, @PathVariable Long positionId) {
//
//	    for (MultipartFile uploadedFile : files) {
//	      try {
//	        this.uploadFile(uploadedFile, positionId);
//	      } catch (IOException e) {
//	        throw new FileStorageException(e.getMessage());
//	      }
//	    }
//	    return ResponseEntity.ok().build();
//	  }  
//	  
//	  /***
//	   * Descargar un archivo
//	   * 
//	   * @param files
//	   * @param positionId
//	   * @return
//	   */
//	  
//	  @GetMapping("/position/{positionId}/file/{fileId}")
//	  public ResponseEntity<Resource> downloadFile(
//	      @PathVariable Long positionId, @PathVariable Long fileId) {
//
//		 /*comprobaos si existe el profesional*/
//	    Optional<Position> position = positionRepository.findById(positionId);
//	    if (!position.isPresent()) {
//	      throw new EntityNotFoundException(
//	          String.format("Position with id %d not found", positionId));
//	    }
//	    /*Si existe, buscamos el fichero de ese profesional */
//	    Optional<DBFile> responsefile = dbFileRepository
//	        .findByFileIdAndPosition_PositionId(fileId, positionId);
//	    if (!responsefile.isPresent()) {
//	      throw new MyFileNotFoundException("File not found with id " + fileId);
//	    }
//	    return ResponseEntity.ok()
//	        .contentType(MediaType.parseMediaType(responsefile.get().getFileType()))
//	        .header(
//	            HttpHeaders.CONTENT_DISPOSITION,
//	            "attachment; filename=\"" + responsefile.get().getFileName() + "\"")
//	        .body(new ByteArrayResource(responsefile.get().getData()));
//	  }
//	  
//

//
//  @DeleteMapping(value = "/position/{positionsId}/file/{fileId}")
//  public ResponseEntity<?> deleteFile(
//      @PathVariable Long positionsId, @PathVariable Long fileId) {
//
//    return positionRepository
//        .findById(positionsId)
//        .map(
//            p -> {
//              dbFileRepository.deleteById(fileId);
//              if (dbFileRepository.findByPosition_PositionId(positionsId).size() == 0) {
//                p.setHasFiles(false);
//                positionRepository.save(p);
//              }
//              return ResponseEntity.ok().build();
//            })
//        .orElseThrow(
//            () ->
//                new EntityNotFoundException(
//                    String.format("Position with id %d not found", positionsId)));
//  }
//	  
//	  
//}
