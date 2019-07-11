//package com.axpe.od.controller;
//
//import com.axpe.od.exceptions.EntityNotFoundException;
//import com.axpe.od.model.Contact;
//import com.axpe.od.model.Professional;
//import com.axpe.od.model.resource.ContactResource;
//import com.axpe.od.repository.ProfessionalRepository;
//import com.axpe.od.service.impl.ContactServiceImpl;
//import com.axpe.od.service.impl.ProfessionalServiceImpl;
//
//import java.net.URI;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resources;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//@RequestMapping(value = "/v1/", produces = "application/hal+json")
//@RestController
//public class ContactController {
//
//  @Autowired
//  private ContactServiceImpl contactServiceImpl;
//
//	
//	@GetMapping(value = "professional/{id}/contacts")
//	public ResponseEntity<List<Contact>>  getAllContactsForProfessional(@PathVariable Integer id) {
//		/*
//		 * dev todos los link relacionados con el profesional En la respuesta se envia
//		 * los datos Professional y los links p es el objecto profesional
//		 */
//
//		List<Contact> collection = serviceProfessionalImpl.getContactsOfProfessional(id);
//		ResponseEntity<List<Contact>> respuesta = new ResponseEntity<List<Contact>>(collection, HttpStatus.OK);
//
//		return respuesta;
//	}
//  
//  @GetMapping(value = "/contacts/{professionalId}")
//  public ResponseEntity<Resources<ContactResource>> getAllContactsByProfessionalId(
//      @PathVariable(required = true) Integer professionalId) {
//
//    List<ContactResource> collection = contactServiceImpl
//        .getAllContactsOfProfessional(professionalId)
//        .stream()
//        .map(ContactResource::new)
//        .collect(Collectors.toList());
//    final Resources<ContactResource> resources = new Resources<>(collection);
//    return ResponseEntity.ok(resources);
//  }
//
//  @GetMapping(value = "/contacts/contact/{contactId}")
//  public ResponseEntity<ContactResource> getContactById(@PathVariable Integer contactId) {
//
//    return contactServiceImpl
//        .getContact(contactId)
//        .map(p -> ResponseEntity.ok(new ContactResource(p)))
//        .orElseThrow(
//            () ->
//                new EntityNotFoundException(
//                    String.format(
//                        "Contact with contactId %d  for professional with contactId %d not found",
//                        contactId, professionalId)));
//  }
//
////  @DeleteMapping("/contacts/{professionalId}/contact/{contactId}")
////  public ResponseEntity<?> deleteContactById(
////      @PathVariable Long professionalId, @PathVariable Long contactId) {
////
////    return contactRepository
////        .findByContactIdAndProfessional_ProfessionalId(contactId, professionalId)
////        .map(
////            contact -> {	
////              contactRepository.delete(contact);
////              return ResponseEntity.ok().build();
////            })
////        .orElseThrow(
////            () ->
////                new EntityNotFoundException(
////                    String.format("Contact with id %d not found", contactId)));
////  }
////
////  @PostMapping(value = "/contacts/{professionalId}/contact", consumes = "application/json")
////  public ResponseEntity<ContactResource> addContact(
////      @RequestBody Contact contact, @PathVariable Long professionalId) {
////
////    Professional professional =
////        professionalRepository
////            .findById(professionalId)
////            .orElseThrow(
////                () ->
////                    new EntityNotFoundException(
////                        String.format(
////                            "Professional with professionalId %d not found", professionalId)));
////
////    contact.setProfessional(professional);
////    Contact savedContact = contactRepository.save(contact);
////    final URI uri =
////        MvcUriComponentsBuilder.fromController(getClass())
////            .path("/{id}")
////            .buildAndExpand(savedContact.getContactId())
////            .toUri();
////    return ResponseEntity.created(uri).body(new ContactResource(savedContact));
////  }
////
////  @PutMapping(
////      value = "/contacts/{professionalId}/contact/{contactId}",
////      consumes = "application/json")
////  @ResponseStatus(HttpStatus.CREATED)
////  public ResponseEntity<ContactResource> updateContact(
////      @RequestBody Contact contact,
////      @PathVariable long professionalId,
////      @PathVariable long contactId) {
////
////    Contact savedContact =
////        contactRepository
////            .findByContactIdAndProfessional_ProfessionalId(contactId, professionalId)
////            .orElseThrow(
////                () ->
////                    new EntityNotFoundException(
////                        String.format(
////                            "Contact with contactId %d  for professional with contactId %d not found",
////                            contactId, professionalId)));
////
////    Professional professional =
////        professionalRepository
////            .findById(professionalId)
////            .orElseThrow(
////                () ->
////                    new EntityNotFoundException(
////                        String.format(
////                            "Professional with professionalId %d not found", professionalId)));
////
////    contact.setProfessional(professional);
////    contact.setContactId(savedContact.getContactId());
////    contactRepository.save(contact);
////    final ContactResource resource = new ContactResource(contact);
////    final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
////    return ResponseEntity.created(uri).body(resource);
////  }
//}
