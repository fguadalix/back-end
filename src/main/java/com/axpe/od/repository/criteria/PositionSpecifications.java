//package com.axpe.od.repository.criteria;
//
//import com.axpe.od.model.Position;
//import com.axpe.od.model.Position_;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.Path;
//import javax.persistence.criteria.Predicate;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.util.StringUtils;
//
//public class PositionSpecifications {
//
//  @PersistenceContext
//  private EntityManager entityManager;
//
//  public static Specification<Position> createPositionQueryUsingInputForm(
//      Position inputForm) {
//    return (Specification<Position>)
//        (root, query, cb) -> {
//          final Collection<Predicate> predicates = new ArrayList<>();
//          isStringFieldEqual(
//        		  root.get(Position_.manager), inputForm.getManager(), cb, predicates);
//          isStringFieldEqual(
//        		  root.get(Position_.company), inputForm.getCompany(), cb, predicates);
//          isStringFieldEqual(
//        		  root.get(Position_.unit), inputForm.getUnit(), cb, predicates);
//          isStringFieldEqual(
//        		  root.get(Position_.client), inputForm.getClient(), cb, predicates);
//          isStringFieldEqual(
//        		  root.get(Position_.recruiter), inputForm.getRecruiter(), cb, predicates);
//          isStringFieldEqual(
//        		  root.get(Position_.workCategory), inputForm.getWorkCategory(), cb, predicates);
//          isStringFieldEqual(
//        		  root.get(Position_.priority), inputForm.getPriority(), cb, predicates);
//          isStringFieldEqual(
//        		  root.get(Position_.state), inputForm.getState(), cb, predicates);
//          isStringFieldLike(
//        		  root.get(Position_.shortDescription), inputForm.getShortDescription(),cb, predicates);
//          isStringFieldLike(
//        		  root.get(Position_.department), inputForm.getDepartment(), cb,predicates);
//          isStringFieldGreaterThan(
//        		  root.get(Position_.incorporationDate), inputForm.getIncorporationDate(),cb, predicates);
//          isStringFieldGreaterThan(
//        		  root.get(Position_.positionDate), inputForm.getPositionDate(),cb, predicates);
//          /*
//           * concatena predicados con AND  
//           * Example: AND  name='juan' AND dni='547'
//           * 
//           *  */
//          return cb.and(predicates.toArray(new Predicate[0]));
//        };
//  }
//
//  private static void isStringFieldEqual(
//      Path<String> objectPath, String value, CriteriaBuilder cb, Collection<Predicate> predicates) {
//    if (!StringUtils.isEmpty(value)) {
//      predicates.add(cb.equal(objectPath, value));
//    }
//  }
//
//  private static void isStringFieldLike(
//      Path<String> objectPath, String value, CriteriaBuilder cb, Collection<Predicate> predicates) {
//    if (!StringUtils.isEmpty(value)) {
//      predicates.add(cb.like(objectPath, value));
//    }
//  }
//
//  /*Para probar con el swagger hay que pasar la fecha como : "incorporationDate": "2019-05-15T02:00:00.000"*/
//  private static void isStringFieldGreaterThan(
//	      Path<LocalDateTime> path, LocalDateTime localDateTime, CriteriaBuilder cb, Collection<Predicate> predicates) {
//	    if (!StringUtils.isEmpty(localDateTime)) {
//	      predicates.add(cb.greaterThanOrEqualTo(path, localDateTime));
//	    }
//	  }
//  
//  private static List<Position> filterByManager(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getManager())) {
//      result =
//          result.stream()
//              .filter(p -> p.getManager().equalsIgnoreCase(position.getManager()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByCompany(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getCompany())) {
//      result =
//          result.stream()
//              .filter(p -> p.getCompany().equalsIgnoreCase(position.getCompany()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByUnit(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getUnit())) {
//      result =
//          result.stream()
//              .filter(p -> p.getUnit().equalsIgnoreCase(position.getUnit()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByRecruiter(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getRecruiter())) {
//      result =
//          result.stream()
//              .filter(p -> p.getRecruiter().equalsIgnoreCase(position.getRecruiter()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByClient(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getClient())) {
//      result =
//          result.stream()
//              .filter(p -> p.getClient().equalsIgnoreCase(position.getClient()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByWorkCategory(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getWorkCategory())) {
//      result =
//          result.stream()
//              .filter(p -> p.getWorkCategory().equalsIgnoreCase(position.getWorkCategory()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByPriority(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getPriority())) {
//      result =
//          result.stream()
//              .filter(p -> p.getPriority().equalsIgnoreCase(position.getPriority()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByState(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getState())) {
//      result =
//          result.stream()
//              .filter(p -> p.getState().equalsIgnoreCase(position.getState()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByExternalKey(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getExternalKey())) {
//      result =
//          result.stream()
//              .filter(p -> p.getExternalKey().equalsIgnoreCase(position.getExternalKey()))
//              .collect(Collectors.toList());
//    }
//    return result;
//  }
//
//  private static List<Position> filterByShortDescription(Position position, List<Position> result) {
//
//    if (!StringUtils.isEmpty(position.getShortDescription())) {
//      result =
//          result.stream()
//              .filter(p -> p.getShortDescription().toLowerCase()
//                  .contains(position.getShortDescription().toLowerCase()))
//              .collect(Collectors.toList());
//    }
//    return result;
//
//
//  }
//
//  // TODO revisar con rrhh
////  private static List<Position> filterByIncorporationDate(Position position, List<Position> result) {
////
////    if (!position.getIncorporationDate().getYear() == 0)
////      result =
////          result.stream()
////              .filter(p -> p.getIncorporationDate().equalsIgnoreCase(position.getExternalKey()))
////              .collect(Collectors.toList());
////    return result;
////  }
////
////  private static List<Position> filterByPositionDate(Position position, List<Position> result) {
////
////    if (!position.getIncorporationDate().getYear() == 0)
////      result =
////          result.stream()
////              .filter(p -> p.getIncorporationDate().equalsIgnoreCase(position.getExternalKey()))
////              .collect(Collectors.toList());
////    return result;
////  }
//
//  public static List<Position> filterByPositionForm(Position position, List<Position> result) {
//
//    result = filterByManager(position, result);
//    result = filterByCompany(position, result);
//    result = filterByUnit(position, result);
//    result = filterByRecruiter(position, result);
//    result = filterByClient(position, result);
//    result = filterByWorkCategory(position, result);
//    result = filterByPriority(position, result);
//    result = filterByState(position, result);
//    result = filterByExternalKey(position, result);
//    result = filterByShortDescription(position, result);
////    result = filterByIncorporationDate(position,result);
////    result = filterByPositionDate(position,result);
//    return result;
//  }
//
//
//}
