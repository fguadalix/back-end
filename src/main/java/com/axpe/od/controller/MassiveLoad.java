//package com.axpe.od.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.axpe.od.exceptions.EntityNotFoundException;
//import com.axpe.od.exceptions.FileFormatException;
//import com.axpe.od.model.Professional;
//import com.axpe.od.model.resource.ProfessionalResource;
//import com.axpe.od.repository.MassiveLoadRepository;
//import com.axpe.od.repository.ProfessionalRepository;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//
//
//@RequestMapping(value = "/v1/", produces = "application/hal+json")
//@RestController
//
//public class MassiveLoad {
//	
//	 /*Lista de formatos permitidos para la subida masiva de documentos*/	
//	  private static final String[] ALLOWED_FILE_TYPES = {
//	      "application/vnd.ms-excel"
//	  };
//	
//	  private ProfessionalRepository professionalRepository;;
//	  private MassiveLoadRepository massiveLoadRepository;
//	
//	
//
//	  protected boolean sw = false;
//	  int contador=0;
//	  protected List<HashMap> listProfessional = new ArrayList<HashMap>();
//
//	  
//	  @PersistenceContext
//	  private EntityManager entityManager;
//	  
//	  
//	  @PostMapping(value = "professional/{fileProfessional}")
//	  public ResponseEntity<?> uploadFilePorfessiona( 
//			  		@RequestParam("file") MultipartFile fileProfessional) throws IOException {
//		  
//	  sw = false;
//	  contador=0;
//	  int i = 0;
//	  Boolean haveProf=false;
//	 
//	  HashMap<String,String> prof = new HashMap<String,String>();		  
//
//		try {	
//	
//			/*convierte multipartFile en File */
//			File convFile = new File(fileProfessional.getOriginalFilename());
//		    convFile.createNewFile();		    
//		    FileOutputStream outFil = new FileOutputStream(convFile);
//		    outFil.write(fileProfessional.getBytes());
//		    outFil.close();
//		    
//		    FileInputStream inFile = new FileInputStream(convFile);
//		    XSSFWorkbook workbook = new XSSFWorkbook(inFile);
//		    XSSFSheet sheet = workbook.getSheetAt(0);
//
//	
//		    Iterator<Row> rowIt = sheet.iterator();
//		    String[] columnProfessional = new String[12] ;
//		    /*FILAS*/
//		    while(rowIt.hasNext()) {
//		      Row row = rowIt.next();		
//			      Iterator<Cell> cellIterator = row.cellIterator();
//			     
//			     /*COLUMNAS */
//			      while (cellIterator.hasNext()) {
//				        Cell cell = cellIterator.next();				        	
//				        System.out.print(cell.toString() + ";");				        
//				        if( !sw ) {
//				        		 columnProfessional[i]=cell.toString().trim().toLowerCase();
//				        		 i++;			        	 
//				        }  
//				        /*creamos  profesioal*/
//				        else {
//				        		 haveProf=true;
//				        		 prof.put(columnProfessional[i], cell.toString());
//				        		 i++;
//				        		 
//				        	 }	      	
//			      	}
//			      
//			      System.out.println("Empieza nueva FILA, TAMANO DE PROF ");
//			      sw= true;  
//			      i=0;
//			      if( haveProf  ){			    	  
//			      	 listProfessional.add(prof);
//			      	System.out.println("Se añade a la lista");
//			      	 }
//			      //contador++;
//		    }
//		    
//		    System.out.println("\n FIN LEER FICHERO \n");
//		    // System.out.println("eL NOMBRE DEL FICHERO ES "+ excelFile.getPath()+ "Pestaña : "+ excelFile.getName());
//		    /*cuando temrine de leer el excel , creamos profesional*/
//		    
//		    final Professional professional =null;		
//		    
//		    Iterator<HashMap> elemP = listProfessional.iterator();
//		    while(elemP.hasNext())
//		    {
//		    	elemP.next().forEach((k,v)->  System.out.println("Key: " + k + ": Value: " + v));
//		    	
//		    
//		    	
//		    }
//		    
//		   for(HashMap mapPersona :listProfessional ) {
//			   
//			   System.out.println( " \n pruebaaaa "+ mapPersona.get("nombre"));
//			 //  professional.setName( mapPersona.get("nombre"));
//			   
//		   }
//			        
////			        switch (k) {
////				        case ("nombre"):
////				        	professional.setName(elem.getValue());
////				        	break;		        
////				        case ("apellidos1"):
////				        	professional.setFirstLastName(elem.getValue());		        
////				        	break;
////				        case ("apellidos2"):
////				        	professional.setSecondLastName(elem.getValue());			        
////				        	break;
////				        case ("telefono"):		
////				        	professional.setCellNumber(elem.getValue());
////				        	break;
////				        case ("email"):	
////				        	professional.setEmail(elem.getValue());
////				        	break;	
////				        case ("categoria"):	
////				        	professional.setWorkCategory(elem.getValue());
////				        	break;        	
////				        case ("salario"):			        
////				        	professional.setMaxWage(Integer.valueOf(elem.getValue()));
////				        	break;
////				        case ("redcontacto"):
////				        	professional.setUrl(elem.getValue());
////				        	break;     	
////			        }// fin witch 
//		    
//			    
//			        
//			    //   professionalRepository.save(professional);
//			        
//			    //}// finfor
//		    	
//		    
//
//		    /*creamos professional - Verficamos que los camposobligatorios tengas datos*/     			   
//		      /*comprobar que los profesionales que insertamos no existan ( email, dni, telefono) */
//		  
//		} catch (FileNotFoundException fileNotFoundException) {
//			// TODO: handle exception
//			//return ResponseEntity.badRequest()notify();
//			 throw new FileNotFoundException("File not found");
//		}
//		catch (IOException ex) {
//			// TODO: handle exception
//			throw new IOException (ex.getMessage());
//		}		
//		
//		return ResponseEntity.ok().build();
//		  
//	  }
//
//	
//	
//}
