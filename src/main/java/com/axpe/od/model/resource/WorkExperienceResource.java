package com.axpe.od.model.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.axpe.od.controller.ProfessionalController;
import com.axpe.od.controller.WorkExperienceController;
import com.axpe.od.model.WorkExperience;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class WorkExperienceResource extends ResourceSupport {

  private final WorkExperience workExperience;

  public WorkExperienceResource(WorkExperience workExperience) {

    this.workExperience = workExperience;
    add(
        linkTo(
            methodOn(WorkExperienceController.class)
                .getWorkExperienceById(
                    workExperience.getProfessional().getProfessionalId(),
                    workExperience.getWorkId()))
            .withSelfRel());
    if (workExperience.getProfessional().getProfessionalId() != null) {
      add(
          linkTo(
              methodOn(ProfessionalController.class)
                  .getProfessionalById(workExperience.getProfessional().getProfessionalId()))
              .withRel("professional"));
    }
  }
}
