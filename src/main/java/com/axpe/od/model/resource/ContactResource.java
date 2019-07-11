//package com.axpe.od.model.resource;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//import com.axpe.od.controller.ContactController;
//import com.axpe.od.controller.ProfessionalController;
//import com.axpe.od.dao.GodHContacto;
//import com.axpe.od.model.Contact;
//import lombok.Getter;
//import org.springframework.hateoas.ResourceSupport;
//
//@Getter
//public class ContactResource extends ResourceSupport {
//
//  private final GodHContacto contact;
//
//  public ContactResource(final GodHContacto contact) {
//
//    this.contact = contact;
//    final Integer id = contact.getClHContactos();
//    add(
//        linkTo(
//            methodOn(ContactController.class)
//                .getContactById(id)
//            .withSelfRel());
//    if (contact.getCdempleado() != null) {
//      add(
//          linkTo(
//              methodOn(ProfessionalController.class)
//                  .getProfessionalById(contact.getProfessional().getProfessionalId()))
//              .withRel("professional"));
//    }
//  }
//}
