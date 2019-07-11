package com.axpe.od.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
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

import com.axpe.od.dao.CatTipoTitulacion;
import com.axpe.od.dao.CatTitulacione;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.CatTitulacioneRequest;
import com.axpe.od.model.Generico;
import com.axpe.od.service.CertificacionesService;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class CertificacionesController {

	@Autowired
	private CertificacionesService certificacionesServiceImpl;	
	
	@Autowired
	private ModelMapper modelMapper;
	 
	@GetMapping(value = "certification")
	public List<Generico> getAllFrecuencias() throws EntityNotFoundException {
		List<CatTitulacione> posts = certificacionesServiceImpl.getAllCertificaciones();
	    return posts.stream()
	      .map(post -> convertToDto(post))
	      .collect(Collectors.toList());
		
	}
	
	 @DeleteMapping("certification/{id}")
	  public ResponseEntity<?> deleteCertification(@PathVariable Integer id) {

		 certificacionesServiceImpl.deleteById(id);
	    return ResponseEntity.ok().build();
	  }

	  @PostMapping("certification")
	  public ResponseEntity<CatTitulacioneRequest> addCertification(@RequestBody CatTitulacioneRequest keyword) {

		  try {
			  certificacionesServiceImpl.save(convertToEntity(keyword,null));

			    final URI uri =
			        MvcUriComponentsBuilder.fromController(getClass())
			            .path("/{id}")
			            .buildAndExpand(keyword.getCertification())
			            .toUri();
			    return ResponseEntity.created(uri).body(keyword);
			} catch (ParseException e) {
				return (ResponseEntity<CatTitulacioneRequest>) ResponseEntity.status(404);
			}
	  }

	  @PutMapping("certification/{id}")
	  public ResponseEntity<CatTitulacioneRequest> editCertification(@RequestBody CatTitulacioneRequest keyword, @PathVariable Integer id) {
		  try {
			  certificacionesServiceImpl.save(convertToEntity(keyword,id));

			    final URI uri =
			        MvcUriComponentsBuilder.fromController(getClass())
			            .path("/{id}")
			            .buildAndExpand(keyword.getCertification())
			            .toUri();
			    return ResponseEntity.created(uri).body(keyword);
			} catch (ParseException e) {
				return (ResponseEntity<CatTitulacioneRequest>) ResponseEntity.status(404);
			}

	  }
	  
	  private Generico convertToDto(CatTitulacione post) {
		  Generico postDto = modelMapper.map(post, Generico.class);
		  postDto.setId(post.getCdtitulacion().intValue());
		  postDto.setDescription(post.getTitulacion());
		  return postDto;
		}
	
	  private CatTitulacione convertToEntity(CatTitulacioneRequest postDto,Integer id) throws ParseException {
		  CatTitulacione post = modelMapper.map(postDto, CatTitulacione.class);
			if(id != null)	post.setCdtitulacion(id);
			post.setTitulacion(postDto.getCertification());
			post.setCdtitulacion(0);
			CatTipoTitulacion capttipo = new CatTipoTitulacion();
			capttipo.setCdtipoTitulacion(1);
			post.setCatTipoTitulacion(capttipo);
			post.setCdusuario(1);
			LocalDateTime localDateTime = LocalDateTime.now();
			Timestamp timestamp = Timestamp.valueOf(localDateTime);
			post.setFemodificacion(timestamp);

			return post;
		}
}
