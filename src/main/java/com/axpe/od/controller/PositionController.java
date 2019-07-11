package com.axpe.od.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.util.QueryBuilder;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.axpe.od.mapper.MapperPosition;
import com.axpe.od.model.Position;
import com.axpe.od.model.resource.PositionResource;
import com.axpe.od.service.impl.ServicePositionImpl;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
@Slf4j
public class PositionController {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired(required = false)
	ServicePositionImpl servicePositionImpl;
	
	
	
	@Autowired
	MapperPosition mapperPosition;

	@Autowired
	public PositionController(ServicePositionImpl servicePositionImpl) {
		this.servicePositionImpl = servicePositionImpl;
	}

	@GetMapping(value = "position/{id}")
	public ResponseEntity<Position> getPositionById(@PathVariable Long id) {

		log.debug("Pasa por aqui");
		Position position = servicePositionImpl.getPositionByIdImpl(id);
		// return ResponseEntity.ok(new PositionResource(position));
		return ResponseEntity.ok(position);

	}
	
	
	  @PostMapping(value = "position", consumes = "application/json")
	  @ResponseStatus(HttpStatus.CREATED)
	  //public ResponseEntity<PositionResource> addPosition(@RequestBody Position positionFromRequest) {
	  
	  public ResponseEntity<?> addPosition(@RequestBody Position positionFromRequest) {

		Position posit = new Position (positionFromRequest); 
	    URI uriPosition =  servicePositionImpl.insertPosition(posit);	    
	   // reindex();
	    return ResponseEntity.created(uriPosition).body(new PositionResource(posit));
	  }
	  
	  @PostMapping("position/search")
	  @ResponseBody
	  public ResponseEntity<Resources<PositionResource>> getAllMatchingPositions(
	      @RequestBody Position position) {
		 
//	    final List<PositionResource> collection =
//	    		positionRepository
//	            .findAll().stream()
//	            .map(PositionResource::new)
//	            .collect(Collectors.toList());
//	    final Resources<PositionResource> resources = new Resources<>(collection);
		List<Position> listPeti= servicePositionImpl.findByAll();
		List<PositionResource> collections= listPeti.stream().map(PositionResource::new)
                .collect(Collectors.toList());
		 final Resources<PositionResource> resources = new Resources<>(collections);
        
        return ResponseEntity.ok(resources);
	   // return new ResponseEntity<List<Position>>(listPeti, HttpStatus.OK) ;
	  }

	  
//  @DeleteMapping("position/{id}")
//  public ResponseEntity<?> deletePositionById(@PathVariable long id) {
//
//    return positionRepository
//        .findById(id)
//        .map(
//            p -> {
//              positionRepository.deleteById(id);
//              //reindex();
//              return ResponseEntity.ok().build();
//            })
//        .orElseThrow(
//            () ->
//                new EntityNotFoundException(
//                    String.format("Professional with id %d not found", id)));
//  }



//  @PutMapping(value = "position/{id}", consumes = "application/json")
//  public ResponseEntity<PositionResource> updatePosition(
//      @RequestBody Position positionFromRequest, @PathVariable long id) {
//
//    if (positionRepository.findById(id).isPresent()) {
//      final Position oldPosition = positionRepository.findById(id).get();
//      final Position newPosition = new Position(positionFromRequest, id);
//      newPosition.setAsignaciones(oldPosition.getAsignaciones());
//      positionRepository.save(newPosition);
//      final PositionResource resource = new PositionResource(newPosition);
//      final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//      reindex();
//      return ResponseEntity.created(uri).body(resource);
//    } else {
//      throw new EntityNotFoundException(
//          String.format(
//              "Position with contactId %d not found, cannot modify Professional", id));
//    }
//  }

//  private void reindex() {
//    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//    try {
//      fullTextEntityManager.createIndexer(Position.class).startAndWait();
//    } catch (InterruptedException e) {
//      log.info("Error occured trying to build Hibernate Search indexes "
//          + e.toString());
//    }
//  }



//  @PostMapping("position/search/keyword")
//  @ResponseBody
//  public ResponseEntity<Resources<PositionResource>> getAllMatchingKeywordPositions(
//      @RequestBody Position position,
//      @RequestParam String keywords) {
//
//    Query keywordQuery =
//        getQueryBuilder()
//            .phrase()
//            .withSlop(3)
//            .onField("keywords")
//            .sentence(keywords)
//            .createQuery();
//
//    List<Position> result = getJpaQuery(keywordQuery).getResultList();
//    result = PositionSpecifications.filterByPositionForm(position, result);
//    final List<PositionResource> collection = result.stream().map(PositionResource::new)
//        .collect(Collectors.toList());
//    final Resources<PositionResource> resources = new Resources<>(collection);
//    return ResponseEntity.ok(resources);
//  }

  private FullTextQuery getJpaQuery(org.apache.lucene.search.Query luceneQuery) {

    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
    return fullTextEntityManager.createFullTextQuery(luceneQuery, Position.class);
  }

//  private QueryBuilder getQueryBuilder() {
//
//    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//
//    return fullTextEntityManager
//        .getSearchFactory()
//        .buildQueryBuilder()
//        .forEntity(Position.class)
//        .get();
//  }
}