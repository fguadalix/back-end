package com.axpe.od.model.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.axpe.od.controller.PositionController;
import com.axpe.od.controller.ProfessionalController;
import com.axpe.od.model.Professional;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
 /*
  * Clase que devuelve todos los link's - URIS asociados asociados a un profesional. 
  * 
  * 
  * **/
@Getter
public class ProfessionalResource extends ResourceSupport {

  private final Professional professional;

  
  /**
   * devuelve  las posiciones que tiene asignadado ese profesional 
   * 
   **/
  
  public ProfessionalResource(final Professional professional) {


	  this.professional = professional;
    add(
        linkTo(
            methodOn(ProfessionalController.class)
                .getProfessionalById(professional.getProfessionalId()))
            .withSelfRel());
    if (professional.getAsignaciones() != null) {
      professional
          .getAsignaciones()
          .forEach(
              a ->
                  add(
                      linkTo(
                          methodOn(PositionController.class)
                              .getPositionById(a.getPosition().getPositionId()))
                          .withRel("assignedPositions")));
    }
   
    /****Si el profesional tiene contactos. La tabla contactos tiene un atributo professionaID en comun con Contactos para sacar los 
     * contactos asociados a un profesional
     * 
     * Explicacion: se genera los link de   un profesional con cada  contacto
     */
    
    if (professional.getContacts() != null) {
//      professional
//          .getContacts()
//          .forEach(
//              a ->
//                  add(
//                      linkTo(
//                          methodOn(ContactController.class)
//                              .getContactById(
//                                  professional.getProfessionalId(), a.getContactId()))
//                          .withRel("contacts")));
      
      /***
       * genera link de un profesional con su Experiendia laboral 
       */
      if (professional.getWorkExperiences() != null) {
//        professional
//            .getWorkExperiences()
//            .forEach(
//                a ->
//                    add(
//                        linkTo(
//                            methodOn(WorkExperienceController.class)
//                                .getWorkExperienceById(
//                                    professional.getProfessionalId(), a.getWorkId()))
//                            .withRel("workExperiences")));
      }
    }
  }
}
