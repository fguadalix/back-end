//package com.axpe.od.repository.criteria;
//
//import com.axpe.od.dao.GodProfesionale;
//import com.axpe.od.dao.GodProfesionale_;
//import com.axpe.od.model.Professional;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.Path;
//import javax.persistence.criteria.Predicate;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.util.StringUtils;
//
//public class ProfessionalSpecifications {
//	/****
//	 * En esta clase se especifica las busquedas de los profesionales con JPA Criteria API
//	 * Crea una query segun el valor buscado en el formulario " Buscar profesional"
//	 *  
//	 *  nota:   
//	 * 		ROOT: raiz, fuente (from)
//	 * 		QUERY:where, having, order, group by  
//	 * 		CB: or, and,
//	 * 
//	 * parameters: professional con valores del json del front
//	 */ 
//
//	
//  public static Specification<GodProfesionale> createProfessionalQueryUsingInputForm(
//		  Professional professional) {
//    return (Specification<GodProfesionale>)
//        (root, query, cb) -> {
//        	
//          final Collection<Predicate> predicates = new ArrayList<>();
//          final Collection<Predicate> predicatesOR = new ArrayList<>();
//     
//              
//          isStringFieldEqual(root.get(GodProfesionale_.nombre), professional.getName(), cb, predicates);
//          isStringFieldEqual(
//              root.get(GodProfesionale_.apellido1), professional.getFirstLastName(),cb,  predicates);
//          isStringFieldEqual(
//              root.get(GodProfesionale_.apellido2), professional.getSecondLastName(),cb,predicates);
//          isStringFieldEqual(
//        		  root.get(GodProfesionale_.dni), professional.getDni(), cb, predicates);
//          isStringFieldEqual(
//              root.get(GodProfesionale_.correo), professional.getEmail(), cb, predicates);
//          isStringFieldEqual(
//              root.get(GodProfesionale_.cdambfuncional.toString()), professional.getBusinessArea(), cb, predicates);
////          isStringFieldEqual(
////              root.get(GodProfesionale_.state), professional.getState(), cb, predicates);
//          isIntFieldEqual(
//              root.get(GodProfesionale_.expSalario1), professional.getMinWage(), cb, predicates);
//          isIntFieldEqual(
//              root.get(GodProfesionale_.expSalario2), professional.getMaxWage(), cb, predicates);
////          isStringFieldEqual(
////              root.get(GodProfesionale_.availability), professional.getAvailability(), cb, predicates);
////          isStringFieldEqual(
////              root.get(GodProfesionale_.country), professional.getCountry(), cb, predicates);
////          isStringFieldEqual(
////              root.get(GodProfesionale_.cdprovincia), professional.getProvince(), cb, predicates);
////          isStringFieldEqual(
////              root.get(GodProfesionale_.certification),professional.getCertification(),cb,predicates);
////          isStringFieldEqual(
////        		  root.get(GodProfesionale_.specialization),professional.getSpecialization(),cb,predicates);
////          isStringFieldEqual(
////        		  root.get(GodProfesionale_.university), professional.getUniversity(), cb, predicates);
////          isIntFielGreatThanEquals(
////        		  root.get(GodProfesionale_.score), professional.getScore(), cb, predicates);
////          isStringFieldEqual(
////        		  root.get(GodProfesionale_.businessArea),professional.getBusinessArea(),cb, predicates);
////     	  isStringFieldEqual(
////                  root.get(Professional_.phoneNumber), professional.getPhoneNumber(), cb, predicates);
////          isStringFieldEqual(
////                      root.get(Professional_.cellNumber), professional.getCellNumber(), cb, predicates);
//	          
//          /* En el formulario solo buscan por un numero de telefono y me lo pasan en el atributo PhoneNumber
//           * Hay que buscar ese numero en cellNumber o phoneNumber 
//           * 
//          */
//          if(!StringUtils.isEmpty(professional.getPhoneNumber()) ) {
//     		 predicates.add(
//        			  cb.or(
//                			  cb.equal(root.get(GodProfesionale_.telefono1),professional.getPhoneNumber()),
//                			  cb.equal(root.get(GodProfesionale_.telefono2),professional.getPhoneNumber())                			  
//                			)       			  
//     				 	);         	 
//          	}          	 
//	 
//          /* convierte la collection a Array */
//          return cb.and(
//        		  		 predicates.toArray(new Predicate[0])
//        		  				
//        		  	);
//        };
//  }
//
// /*** 
//  * Compara  el valor del atributo del objeto del formulario con el 
//  * @param objectPath, equivale al nombre de la columna, atributo: name, apellido, phonenumber...
//  * @param value: valor a buscar especificado en el formulario de front
//  * @param cb , objecto CriteriaBuilder necesario para hacer la consulta o query
//  * @param predicates
//  */
//  
//  private static void isStringFieldEqual(
//      Path<String> objectPath, String value, CriteriaBuilder cb, Collection<Predicate> predicates) {
//    if (!StringUtils.isEmpty(value)) {
//    	/*Este equivale a  objecto_name = valor del profesional pasado por parametro*/
//      predicates.add(cb.equal(objectPath, value));
//    }
//  }
//
//  
//  private static void isIntFieldEqual(
//      Path<BigDecimal> path, int value, CriteriaBuilder cb, Collection<Predicate> predicates) {
//
//	  if (value != 0) {
//      predicates.add(cb.equal(path, value));
//    }
//  }
//
//  private static void isIntFielGreatThanEquals(
//	      Path<Integer> objectPath, int value, CriteriaBuilder cb, Collection<Predicate> predicates) {
//	    if (value != 0) {
//	     predicates.add(cb.greaterThanOrEqualTo(objectPath,value));
//	     
//	     //predicates.add(cb.equal(objectPath, value));
//	    }
//	  }
//  
//  /****
//   * metodos que dev el listado de resultado filtrado por: DNI, APELLIDOS, EMIAL...
//   * @param professional -objeto 
//   * @param result  - Lista
//   * @return
//   */
//  
//  
//  private static List<Professional> filterByDni(Professional professional,
//      List<Professional> result) {
//
//    if (!StringUtils.isEmpty(professional.getDni())) {
//      result =
//          result.stream()
//              .filter(p -> p.getDni().equalsIgnoreCase(professional.getDni()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Professional> filterByEmail(Professional professional,
//      List<Professional> result) {
//
//    if (!StringUtils.isEmpty(professional.getEmail())) {
//      result =
//          result.stream()
//              .filter(p -> p.getEmail().equalsIgnoreCase(professional.getEmail()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Professional> filterByFirstLastName(Professional professional,
//      List<Professional> result) {
//
//    if (!StringUtils.isEmpty(professional.getFirstLastName())) {
//      result =
//          result.stream()
//              .filter(p -> p.getFirstLastName().equalsIgnoreCase(professional.getFirstLastName()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Professional> filterBySecondLastName(Professional professional,
//      List<Professional> result) {
//
//    if (!StringUtils.isEmpty(professional.getSecondLastName())) {
//      result =
//          result.stream()
//              .filter(p -> p.getSecondLastName().equalsIgnoreCase(professional.getSecondLastName()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Professional> filterByCellNumber(Professional professional,
//      List<Professional> result) {
//
//    if (!StringUtils.isEmpty(professional.getCellNumber())) {
//      result =
//          result.stream()
//              .filter(p -> p.getCellNumber().equalsIgnoreCase(professional.getCellNumber()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  public static List<Professional> filterByPositionForm(
//      Professional professional, List<Professional> result) {
//
//    result = filterByDni(professional, result);
//    result = filterByEmail(professional, result);
//    result = filterByFirstLastName(professional, result);
//    result = filterBySecondLastName(professional, result);
//    result = filterByCellNumber(professional, result);
//
//    return result;
//  }
//}
