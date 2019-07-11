//package com.axpe.od.controller;
//
//import com.axpe.od.exceptions.EntityNotFoundException;
//import com.axpe.od.exceptions.FileFormatException;
//import com.axpe.od.exceptions.FileStorageException;
//import com.axpe.od.exceptions.MyFileNotFoundException;
//import com.axpe.od.model.DBFile;
//import com.axpe.od.model.Professional;
//import com.axpe.od.repository.DBFileRepository;
//import com.axpe.od.repository.ProfessionalRepository;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping(value = "/v1/files/", produces = "application/hal+json")
//public class FileController {
//
// /*Lista de formatos permitidos para la subida del documentos*/	
//  private static final String[] ALLOWED_FILE_TYPES = {
//      "application/msword",
//      "application/pdf",
//      "application/vnd.ms-excel",
//      "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
//      "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
//  };
//  private ProfessionalRepository professionalRepository;
//  private DBFileRepository dbFileRepository;
//
//  @Autowired
//  public FileController(
//      ProfessionalRepository professionalRepository,
//      DBFileRepository dbFileRepository) {
//    this.professionalRepository = professionalRepository;
//    this.dbFileRepository = dbFileRepository;
//  }
//
//  /***
//   * METODOS PARA SUBIR UN DOCUMENTO A UN PROFESIONAL EN CONCRETO
//   * @param file
//   * @param professionalId
//   * @return
//   * @throws IOException
//   */
//  
//  @PostMapping(value = "/professional/{professionalId}/file")
//  public ResponseEntity<?> uploadFile(
//      @RequestParam("file") MultipartFile file, @PathVariable Long professionalId)
//      throws IOException {
//
//	  /*Primero comprobamos si el profesional existe.*/ 
//    Optional<Professional> professional = professionalRepository.findById(professionalId);
//    if (!professional.isPresent()) {
//      throw new EntityNotFoundException(
//          String.format("Professional with id %d not found", professionalId));
//    }
//
//    /* Comprobamos que el tipo de contenido se pueda subir  y 
//     * obtenemos el nombre del fichero */
//    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//    String contentType = Objects.requireNonNull(file.getContentType()).toLowerCase();
//    if (!Arrays.asList(ALLOWED_FILE_TYPES).contains(contentType)) {
//      throw new FileFormatException(
//          String.format(
//              "Format file not allowed, only allowed %s", Arrays.toString(ALLOWED_FILE_TYPES)));
//    }
//    
//    /* Creamos el objeto documento*/
//    DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
//    dbFile.setProfessional(professional.get());
//    professional.get().setHasFiles(true);
//    dbFileRepository.save(dbFile);
//    professionalRepository.save(professional.get());
//
//    return ResponseEntity.ok().build();
//  }
//
//  /***
//   * Subir varios adjuntos 
//   * 
//   * @param files
//   * @param professionalId
//   * @return
//   * 
//   * A traves del swagger no se envia bien el array de los ficheros , pero desde front y con el postman funciona correctamente
//   * Ejemplo  http://172.26.2.55:5000/v1/files/professional/36/uploadMultipleFiles
//   * 
//   * Header: 
//   * 	Authorization : Basic YmdhcmNpYWw6QXhwZS4xOTg4
//   *    Content-Type: multipart/form-data
//   *    Accept: application/hal+json
//   * Body
//   * 	files: <seleccionar ficheros>
//   */
//  
//  
//  @PostMapping("/professional/{professionalId}/uploadMultipleFiles")
//  public ResponseEntity<?> uploadMultipleFiles(@RequestParam MultipartFile[]
//      files, @PathVariable Long professionalId) {
//
//    for (MultipartFile file : files) {
//      try {
//        this.uploadFile(file, professionalId);
//      } catch (IOException e) {
//        throw new FileStorageException(e.getMessage());
//      }
//    }
//    return ResponseEntity.ok().build();
//  }
//  
//  /***
//   * Descargar un fichero
//   * 
//   * @param files
//   * @param professionalId
//   * @return
//   */
//
//  @GetMapping("/professional/{professionalId}/file/{fileId}")
//  public ResponseEntity<Resource> downloadFile(
//      @PathVariable Long professionalId, @PathVariable Long fileId) {
//
//	 /*comprobaos si existe el profesional*/
//    Optional<Professional> professional = professionalRepository.findById(professionalId);
//    if (!professional.isPresent()) {
//      throw new EntityNotFoundException(
//          String.format("Professional with id %d not found", professionalId));
//    }
//    /*Si existe, buscamos el fichero de ese profesional */
//    Optional<DBFile> responsefile = dbFileRepository
//        .findByFileIdAndProfessional_ProfessionalId(fileId, professionalId);
//    if (!responsefile.isPresent()) {
//      throw new MyFileNotFoundException("File not found with id " + fileId);
//    }
//    return ResponseEntity.ok()
//        .contentType(MediaType.parseMediaType(responsefile.get().getFileType()))
//        .header(
//            HttpHeaders.CONTENT_DISPOSITION,
//            "attachment; filename=\"" + responsefile.get().getFileName() + "\"")
//        .body(new ByteArrayResource(responsefile.get().getData()));
//  }
//  
///***
// * Lista los documentos de un profesioanal en concreto pasado por parametro
// * @param professionalId
// * @return lista de objetos File
// */
//  
//  @GetMapping("/professional/{professionalId}/list")
//  public List<DBFile> getAllFilesMetadata(@PathVariable Long professionalId) {
//
//    return dbFileRepository.findByProfessional_ProfessionalId(professionalId);
//  }
//
//
//  @DeleteMapping(value = "/professional/{professionalId}/file/{fileId}")
//  public ResponseEntity<?> deleteFile(
//      @PathVariable Long professionalId, @PathVariable Long fileId) {
//
//    return professionalRepository
//        .findById(professionalId)
//        .map(
//            p -> {
//              dbFileRepository.deleteById(fileId);
//              if (dbFileRepository.findByProfessional_ProfessionalId(professionalId).size() == 0) {
//                p.setHasFiles(false);
//                professionalRepository.save(p);
//              }
//              return ResponseEntity.ok().build();
//            })
//        .orElseThrow(
//            () ->
//                new EntityNotFoundException(
//                    String.format("Professional with id %d not found", professionalId)));
//  }
//}
