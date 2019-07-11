package com.axpe.od.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.axpe.od.dao.GodProfesionale;
import com.axpe.od.model.Contact;
import com.axpe.od.model.Position;
import com.axpe.od.model.Professional;
import com.axpe.od.model.resource.ProfessionalResource;
import com.axpe.od.service.ProfessionalService;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
@Configuration
@ComponentScan("com.axpe.od.service")
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class ProfessionalController {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ProfessionalService serviceProfessionalImpl;

	@Autowired
	private ModelMapper modelMapper;

	/***
	 * Obtener un profesional por ID
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "professional/{id}")
	public ResponseEntity<ProfessionalResource> getProfessionalById(@PathVariable Integer id) {
		/*
		 * dev todos los link relacionados con el profesional En la respuesta se envia
		 * los datos Professional y los links p es el objecto profesional
		 */
		return ResponseEntity.ok(new ProfessionalResource(serviceProfessionalImpl.getProfessional(id)));

	}

	@GetMapping(value = "professional/{id}/contacts")
	public ResponseEntity<List<Contact>> getAllContactsForProfessional(@PathVariable Integer id) {
		/*
		 * dev todos los link relacionados con el profesional En la respuesta se envia
		 * los datos Professional y los links p es el objecto profesional
		 */

		List<Contact> collection = serviceProfessionalImpl.getContactsOfProfessional(id);
		ResponseEntity<List<Contact>> respuesta = new ResponseEntity<List<Contact>>(collection, HttpStatus.OK);

		return respuesta;
	}

	/****
	 * Description: Crea un profesional Parameters: none
	 ***/
	@PostMapping(value = "professional", consumes = "application/json")
	public ResponseEntity<ProfessionalResource> addProfessional(@RequestBody Professional professionalRequest) {

		final Professional professional = new Professional(professionalRequest);
		serviceProfessionalImpl.saveProfessional(professional);
		//reindex();
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
				.buildAndExpand(professional.getProfessionalId()).toUri();
		return ResponseEntity.created(uri).body(new ProfessionalResource(professional));
	}

	/****
	 * Description: Borra el profesional correspondiente al ID pasado por parametro
	 * Parameters: ID professional
	 ***/

	@DeleteMapping("professional/{id}")
	public ResponseEntity<?> deleteProfessionalById(@PathVariable Integer id) {

//		return professionalRepository.findById(id).map(p -> {
//			professionalRepository.deleteById(id);
//			reindex();
//			return ResponseEntity.ok().build();
//		}).orElseThrow(() -> new EntityNotFoundException(String.format("Professional with id %d not found", id)));

		serviceProfessionalImpl.deletProfessional(id);
		return ResponseEntity.ok().build();
	}

	/****
	 * Description: Actualiza el profesional pasado por paramentro Parameters: ID
	 * professional
	 ***/
//  @PutMapping(value = "professional/{id}", consumes = "application/json")
//  public ResponseEntity<ProfessionalResource> updateProfessional(
//      @RequestBody Professional professionalFromRequest, @PathVariable long id) {
//
//    if (professionalRepository.findById(id).isPresent()) {
//      final Professional oldProfessional = professionalRepository.findById(id).get();
//      final Professional newProfessional = new Professional(professionalFromRequest, id);
//      newProfessional.setAsignaciones(oldProfessional.getAsignaciones());
//      newProfessional.setContacts(oldProfessional.getContacts());
//      newProfessional.setWorkExperiences(oldProfessional.getWorkExperiences());
//      professionalRepository.save(newProfessional);
//      reindex();
//      final ProfessionalResource resource = new ProfessionalResource(newProfessional);
//      final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//      return ResponseEntity.created(uri).body(resource);
//    } else {
//      throw new EntityNotFoundException(
//          String.format(
//              "Professional with contactId %d not found, cannot modify Professional", id));
//    }
//  }

	/****
	 * Description: modifica la fecha de modificacion de un profesional en concreto
	 * Parameters: ID professional
	 ***/
//  @PutMapping(value = "professional/updateModificationDate/{id}")
//  @ResponseStatus(HttpStatus.CREATED)
//  public ResponseEntity<ProfessionalResource> updateProfessionalModificationDate(
//      @PathVariable long id) throws Exception {
//
//    if (professionalRepository.findById(id).isPresent()) {
//      int result = professionalRepository.updateLastModificationDate(id, LocalDateTime.now());
//      if (result != 1) {
//        throw new Exception(
//            String.format(
//                "Professional with id %d cannot be updated ", id));
//      }
//      reindex();
//      final ProfessionalResource resource = new ProfessionalResource(
//          professionalRepository.findById(id).get());
//      final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//      return ResponseEntity.created(uri).body(resource);
//    } else {
//      throw new EntityNotFoundException(
//          String.format(
//              "Professional with contactId %d not found, cannot modify Professional", id));
//    }
//  }
	/****
	 * Description: Busqueda por cualquier campo del formulario , temporalmente
	 * buscado y dev TOODO , mejorar Parameters:
	 *****/

	@PostMapping("professional/search")
	@ResponseBody
	public ResponseEntity<Resources<ProfessionalResource>> getAllMatchingPositions(
			@RequestBody Professional professional) {

		// public ResponseEntity<List<Professional>>
		// getAllMatchingPositions(@RequestBody Professional professional) {
//	public ResponseEntity<Resources<Professional>> getAllMatchingPositions(@RequestBody Professional professional) {
		List<Professional> collection = serviceProfessionalImpl.findAll();
		/*
		 * dev todos link del resultado de la busqeda busqueda y lo envia como respuesta
		 * de la peticion
		 */
//		Link selfLink = linkTo(ProfessionalController.class).slash( 
//				((Professional)collection.get(0)).getProfessionalId()).withSelfRel();

//		ProfessionalResource pr = new ProfessionalResource(((Professional)collection.get(0)));
//		
////		Resources<ProfessionalResource> resources = new Resources<ProfessionalResource>(pr);

		List<ProfessionalResource> collections = collection.stream().map(ProfessionalResource::new)
				.collect(Collectors.toList());
		Resources<ProfessionalResource> resources = new Resources<>(collections);

		return ResponseEntity.ok(resources);

	}

	/****
	 * Description: Busqueda por cualquiera de los campos de un profesional (lucene)
	 * Parameters: palabraClave Enviar body peticion un professional.
	 *****/

//  @PostMapping("professional/search/keyword")
//  @ResponseBody
//  public ResponseEntity<Resources<ProfessionalResource>> getAllMatchingKeywordPositions(
//      @RequestBody Professional professional,
//      @RequestParam (required = false) String keywords)
//      throws InterruptedException {
//
//    		
//    //Crea la query con las funciones de QueryBuilder	
//    Query keywordQuery =	
//        getQueryBuilder()
//            .phrase()
//            .withSlop(3)
//            .onField("keywords")
//            .sentence(keywords)
//            .createQuery();
//
//    List<Professional> result = getJpaQuery(keywordQuery).getResultList();
//    result = ProfessionalSpecifications.filterByPositionForm(professional, result);
//    final List<ProfessionalResource> collection = result.stream().map(ProfessionalResource::new)
//        .collect(Collectors.toList());
//    final Resources<ProfessionalResource> resources = new Resources<>(collection);
//    return ResponseEntity.ok(resources);
//    // FIXME
//    //  juan: crear tabla keywords y cargarla con datos de la ddbb GOD
//  }

	/****
	 * Description: Funcion privada que usa la busqueda por palabra clave para
	 * obtener el resultado con las palabras clave Parameters:
	 *****/

	private FullTextQuery getJpaQuery(org.apache.lucene.search.Query luceneQuery) throws InterruptedException {

		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		return fullTextEntityManager.createFullTextQuery(luceneQuery, Professional.class);
	}

//  se crea el query usando Hibernate Search query DSL, dev una QueryBuilder para crear la Query en  LUCENE
	private QueryBuilder getQueryBuilder() {

		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

		return fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Professional.class).get();
	}

//	// crea un indice para realizar la busqueda con lucene
//	private void reindex() {
//		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//		try {
//			fullTextEntityManager.createIndexer(Position.class).startAndWait();
//		} catch (InterruptedException e) {
//			System.out.println("Error occured trying to build Hibernate Search indexes " + e.toString());
//		}
//	}

}
