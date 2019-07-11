//package com.axpe.od.controller;
//
//import com.axpe.od.exceptions.EntityNotFoundException;
//import com.axpe.od.model.Assignation;
//import com.axpe.od.model.Position;
//import com.axpe.od.model.Professional;
//import com.axpe.od.model.resource.AssignationResource;
//import com.axpe.od.repository.AssignationRepository;
//import com.axpe.od.repository.PositionRepository;
//import com.axpe.od.repository.ProfessionalRepository;
//import java.net.URI;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
//
//@RequestMapping(value = "/v1/", produces = "application/hal+json")
//@RestController
//public class AssignationController {
//
//  private final AssignationRepository assignationRepository;
//  private final ProfessionalRepository professionalRepository;
//  private final PositionRepository positionRepository;
//
//  @Autowired
//  public AssignationController(
//      AssignationRepository assignationRepository,
//      ProfessionalRepository professionalRepository,
//      PositionRepository positionRepository) {
//    this.assignationRepository = assignationRepository;
//    this.professionalRepository = professionalRepository;
//    this.positionRepository = positionRepository;
//  }
//
//  @GetMapping(value = "assignation/position/{positionId}/professional/{professionalId}")
//  public ResponseEntity<AssignationResource> getAssignationByPositionIdAndProfessionalId(
//      @PathVariable Long positionId, @PathVariable Long professionalId)
//      throws EntityNotFoundException {
//
//    return assignationRepository
//        .findByPosition_PositionIdAndProfessional_ProfessionalId(positionId, professionalId)
//        .map(p -> ResponseEntity.ok(new AssignationResource(p)))
//        .orElseThrow(() -> new EntityNotFoundException(String.format(
//            "Assignation with positionId %d and professionalId %d not found",
//            positionId, professionalId)));
//  }
//
//  @DeleteMapping("assignation/position/{positionId}/professional/{professionalId}")
//  public ResponseEntity<?> deleteAssignationById(
//      @PathVariable Long positionId, @PathVariable Long professionalId) {
//
//    return assignationRepository
//        .findByPosition_PositionIdAndProfessional_ProfessionalId(positionId, professionalId)
//        .map(
//            p -> {
//              assignationRepository.deleteById(p.getAssignationId());
//              return ResponseEntity.ok().build();
//            })
//        .orElseThrow(
//            () ->
//                new EntityNotFoundException(
//                    String.format(
//                        "Assignation with positionId %d and professionalId %d not found",
//                        positionId, professionalId)));
//  }
//
//  @PostMapping(value = "assignation/position/{positionId}/professional/{professionalId}")
//  public ResponseEntity<AssignationResource> createAssignation(
//      @PathVariable Long positionId, @PathVariable Long professionalId) {
//
//    Position position =
//        positionRepository
//            .findById(positionId)
//            .orElseThrow(
//                () ->
//                    new EntityNotFoundException(
//                        String.format("Position with id %d not found", positionId)));
//
//    Professional professional =
//        professionalRepository
//            .findById(professionalId)
//            .orElseThrow(
//                () ->
//                    new EntityNotFoundException(
//                        String.format("Professional with id %d not found", professionalId)));
//
//    Assignation assignationEntity = new Assignation(position, professional);
//    Assignation savedAsignation = assignationRepository.save(assignationEntity);
//
//    final URI uri =
//        MvcUriComponentsBuilder.fromController(getClass())
//            .path("/{id}")
//            .buildAndExpand(position.getPositionId())
//            .toUri();
//    return ResponseEntity.created(uri).body(new AssignationResource(savedAsignation));
//  }
//}
