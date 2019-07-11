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

import com.axpe.od.dao.CatSectorNegocio;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.CatUnidadNegocioRequest;
import com.axpe.od.model.Generico;
import com.axpe.od.service.UnidadesNegocioService;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class UnidadesNegocioController {

	@Autowired
	private UnidadesNegocioService unicdadesNegocioServiceImpl;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "unit")
	public List<Generico> getAllFrecuencias() throws EntityNotFoundException {
		List<CatSectorNegocio> posts = unicdadesNegocioServiceImpl.getAllUnidades();
		return posts.stream().map(post -> convertToDto(post)).collect(Collectors.toList());

	}

	@DeleteMapping("unit/{id}")
	public ResponseEntity<?> deleteUnit(@PathVariable Integer id) {

		unicdadesNegocioServiceImpl.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("unit")
	public ResponseEntity<CatUnidadNegocioRequest> addUnit(@RequestBody CatUnidadNegocioRequest keyword) {

		try {
			unicdadesNegocioServiceImpl.save(convertToEntity(keyword, null));

			final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
					.buildAndExpand(keyword.getUnit()).toUri();
			return ResponseEntity.created(uri).body(keyword);
		} catch (ParseException e) {
			return (ResponseEntity<CatUnidadNegocioRequest>) ResponseEntity.status(404);
		}
	}

	@PutMapping("unit/{id}")
	public ResponseEntity<CatUnidadNegocioRequest> editUnit(@RequestBody CatUnidadNegocioRequest keyword,
			@PathVariable Integer id) {
		try {
			unicdadesNegocioServiceImpl.save(convertToEntity(keyword, id));

			final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
					.buildAndExpand(keyword.getUnit()).toUri();
			return ResponseEntity.created(uri).body(keyword);
		} catch (ParseException e) {
			return (ResponseEntity<CatUnidadNegocioRequest>) ResponseEntity.status(404);
		}

	}

	private CatSectorNegocio convertToEntity(CatUnidadNegocioRequest postDto, Integer id) throws ParseException {
		CatSectorNegocio post = modelMapper.map(postDto, CatSectorNegocio.class);
		if (id != null)
			post.setCdsectorn(id);
		else 
			post.setCdsectorn(0);
		post.setCodsectorn("NA");	
		post.setCdusuario(1);
		post.setDssectorn(postDto.getUnit());

		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(localDateTime);
		post.setFemodificacion(timestamp);

		return post;
	}

	private Generico convertToDto(CatSectorNegocio post) {
		Generico postDto = modelMapper.map(post, Generico.class);
		postDto.setId(post.getCdsectorn().intValue());
		postDto.setDescription(post.getDssectorn());
		return postDto;
	}

}
