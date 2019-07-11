package com.axpe.od.model.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.axpe.od.controller.PositionController;
import com.axpe.od.controller.ProfessionalController;
import com.axpe.od.model.Position;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class PositionResource extends ResourceSupport {

  private final Position position;

  public PositionResource(final Position position) {

    this.position = position;
    final long id = position.getPositionId();
    add(
        linkTo(methodOn(PositionController.class).getPositionById(position.getPositionId()))
            .withSelfRel());
//    if (position.getAsignaciones() != null) {
//      position
//          .getAsignaciones()
//          .forEach(
//              a ->
//                  add(
//                      linkTo(
//                          methodOn(ProfessionalController.class)
//                              .getProfessionalById(a.getProfessional().getProfessionalId()))
//                          .withRel("assignedProfessionals")));
//    }
  }
}