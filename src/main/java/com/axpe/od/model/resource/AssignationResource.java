//package com.axpe.od.model.resource;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//
//import com.axpe.od.controller.AssignationController;
//import com.axpe.od.controller.PositionController;
//import com.axpe.od.controller.ProfessionalController;
//import com.axpe.od.model.Assignation;
//import lombok.Getter;
//import org.springframework.hateoas.ResourceSupport;
//import org.springframework.hateoas.core.DummyInvocationUtils;
//
//@Getter
//public class AssignationResource extends ResourceSupport {
//
//  private final Assignation assignation;
//
//  public AssignationResource(final Assignation assignation) {
//
//    this.assignation = assignation;
//    final long id = assignation.getAssignationId();
//    add(
//        linkTo(
//            DummyInvocationUtils.methodOn(AssignationController.class)
//                .getAssignationByPositionIdAndProfessionalId(
//                    assignation.getPosition().getPositionId(),
//                    assignation.getProfessional().getProfessionalId()))
//            .withSelfRel(),
//        linkTo(
//            DummyInvocationUtils.methodOn(ProfessionalController.class)
//                .getProfessionalById(assignation.getProfessional().getProfessionalId()))
//            .withRel("professional"),
//        linkTo(
//            DummyInvocationUtils.methodOn(PositionController.class)
//                .getPositionById(assignation.getPosition().getPositionId()))
//            .withRel("position"));
//  }
//}
