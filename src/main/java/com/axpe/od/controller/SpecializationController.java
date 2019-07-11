package com.axpe.od.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.axpe.od.dao.CatTitulacione;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.Specialization;
import com.axpe.od.service.TitulacionesService;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class SpecializationController {

  private final TitulacionesService titulacionesService;
  
  @Autowired
  private ModelMapper modelMapper;
  
  
  @Autowired
  public SpecializationController(TitulacionesService titulacionesService) {
    this.titulacionesService = titulacionesService;
  }

  @GetMapping(value = "specialization/{certificationId}")
  public List<Specialization> getAllSpecializationsForCertificationId(
      @PathVariable Integer certificationId)
      throws EntityNotFoundException {
	
	  List<CatTitulacione> posts = titulacionesService.getAllById(certificationId);
	  return posts.stream()
		      .map(post -> convertToDto(post))
		      .collect(Collectors.toList());
    
  }

  @DeleteMapping("specialization/{id}")
  public ResponseEntity<?> deleteSpecialization(@PathVariable Integer id) {
	  titulacionesService.deleteById(id);
      return ResponseEntity.ok().build();
//    return specializationRepository
//        .findById(id)
//        .map(
//            p -> {
//              specializationRepository.deleteById(id);
//              return ResponseEntity.ok().build();
//            })
//        .orElseThrow(
//            () -> new EntityNotFoundException(
//                String.format("specialization with id %d not found", id)));
  }

  @PostMapping("specialization")
  public ResponseEntity<Specialization> addSpecialization(
      @RequestBody Specialization specialization) {

	  try {
		  titulacionesService.save(convertToEntity(specialization));

		    final URI uri =
		        MvcUriComponentsBuilder.fromController(getClass())
		            .path("/{id}")
		            .buildAndExpand(specialization.getSpecializationId())
		            .toUri();
		    return ResponseEntity.created(uri).body(specialization);
		} catch (ParseException e) {
			return (ResponseEntity<Specialization>) ResponseEntity.status(404);
		}
	  
//    specializationRepository.save(specialization);
//    final URI uri =
//        MvcUriComponentsBuilder.fromController(getClass())
//            .path("/{id}")
//            .buildAndExpand(specialization.getSpecializationId())
//            .toUri();
//    return ResponseEntity.created(uri).body(specialization);
  }

  @PutMapping("specialization/{id}")
  public ResponseEntity<Specialization> editSpecialization(
      @RequestBody Specialization specialization, @PathVariable long id) {
	  final URI uri =
		      MvcUriComponentsBuilder.fromController(getClass())
		          .path("/{id}")
		          .buildAndExpand(specialization.getCertificationId())
		          .toUri();
			  try {
				  titulacionesService.save(convertToEntity(specialization));
					return ResponseEntity.created(uri).body(specialization);
				} catch (ParseException e) {
					return (ResponseEntity<Specialization>) ResponseEntity.status(404);
				}
//    if (titulacionesService.findById(id).isPresent()) {
//      specialization.setSpecializationId(id);
//      titulacionesService.save(specialization);
//      final URI uri =
//          MvcUriComponentsBuilder.fromController(getClass())
//              .path("/{id}")
//              .buildAndExpand(specialization.getSpecializationId())
//              .toUri();
//      return ResponseEntity.created(uri).body(specialization);
//    } else {
//      throw new EntityNotFoundException(
//          String.format(
//              "Professional with contactId %d not found, cannot modify Professional", id));
//    }
  }
  
  private Specialization convertToDto(CatTitulacione post) {
	  Specialization postDto = modelMapper.map(post, Specialization.class);
	  postDto.setCertificationId(post.getCdtitulacion());
	  postDto.setSpecialization(post.getTitulacion());
	  return postDto;
	}
  
  private CatTitulacione convertToEntity(Specialization postDto) throws ParseException {
	  CatTitulacione post = modelMapper.map(postDto, CatTitulacione.class);
	  post.setCdtitulacion(postDto.getCertificationId());
	  post.setTitulacion(postDto.getSpecialization());
		
	  LocalDateTime localDateTime = LocalDateTime.now();
	  Timestamp timestamp = Timestamp.valueOf(localDateTime);
	  post.setFemodificacion(timestamp);

      return post;
	}
}
