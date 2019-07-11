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

import com.axpe.od.dao.CatUniversidadCf;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.CatUniversidadCfRequest;
import com.axpe.od.model.Generico;
import com.axpe.od.service.UniversidadesService;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class UniversidadesController {

	@Autowired
	private UniversidadesService universidadesService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "university")
	public List<Generico> getAllUniversity() throws EntityNotFoundException {
		List<CatUniversidadCf> posts = universidadesService.getAllUniversidades();
		return posts.stream().map(post -> convertToDto(post)).collect(Collectors.toList());

	}

	  @DeleteMapping("university/{id}")
	  public ResponseEntity<?> deleteUniversity(@PathVariable Integer id) {

	    universidadesService.deleteById(id);
	    return ResponseEntity.ok().build();
	  }

	  @PostMapping("university")
	  public ResponseEntity<CatUniversidadCfRequest> addUniversity(@RequestBody CatUniversidadCfRequest keyword) {

		  try {
			  	universidadesService.save(convertToEntity(keyword,null));

			    final URI uri =
			        MvcUriComponentsBuilder.fromController(getClass())
			            .path("/{id}")
			            .buildAndExpand(keyword.getUniversity())
			            .toUri();
			    return ResponseEntity.created(uri).body(keyword);
			} catch (ParseException e) {
				return (ResponseEntity<CatUniversidadCfRequest>) ResponseEntity.status(404);
			}
	  }

	  @PutMapping("university/{id}")
	  public ResponseEntity<CatUniversidadCfRequest> editUniversity(@RequestBody CatUniversidadCfRequest keyword, @PathVariable Integer id) {
		  try {
			  	universidadesService.save(convertToEntity(keyword,id));

			    final URI uri =
			        MvcUriComponentsBuilder.fromController(getClass())
			            .path("/{id}")
			            .buildAndExpand(keyword.getUniversity())
			            .toUri();
			    return ResponseEntity.created(uri).body(keyword);
			} catch (ParseException e) {
				return (ResponseEntity<CatUniversidadCfRequest>) ResponseEntity.status(404);
			}

	  }
	  
	private Generico convertToDto(CatUniversidadCf post) {
		Generico postDto = modelMapper.map(post, Generico.class);
		postDto.setId(post.getCdcentroFormativo().intValue());
		 postDto.setDescription(post.getDscentroFormativo());
		return postDto;
	}

	private CatUniversidadCf convertToEntity(CatUniversidadCfRequest postDto,Integer id) throws ParseException {
		CatUniversidadCf post = modelMapper.map(postDto, CatUniversidadCf.class);
		if(id != null)	post.setCdcentroFormativo(id);
		post.setDscentroFormativo(postDto.getUniversity());
		post.setCdusuario(0);
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(localDateTime);
		post.setFemodificacion(timestamp);

		return post;
	}

}
