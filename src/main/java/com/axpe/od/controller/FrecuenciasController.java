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

import com.axpe.od.dao.GodDisponibilidad;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.FrecDispRequest;
import com.axpe.od.model.Generico;
import com.axpe.od.service.FrecDispService;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class FrecuenciasController {

	@Autowired
	private FrecDispService frecDdispServiceImpl;

	@Autowired
	private ModelMapper modelMapper;
	
	private final static String  COD_INMEDIATE ="INMEDIATA";
	
	@GetMapping(value = "frequency")
	public List<Generico> getAllFrecuencias() throws EntityNotFoundException {
		List<GodDisponibilidad> posts = frecDdispServiceImpl.getAllDisp();
		return posts.stream().map(post -> convertToDto(post))
				.filter(line -> !COD_INMEDIATE.equals(line.getDescription())) 
				.collect(Collectors.toList());

	}

	@GetMapping(value = "availability")
	public List<Generico> getAllDisponibilidades() throws EntityNotFoundException {
		List<GodDisponibilidad> posts = frecDdispServiceImpl.getAllDisp();
		return posts.stream().map(post -> convertToDto(post)).collect(Collectors.toList());

	}

	@DeleteMapping("frequency/{id}")
	public ResponseEntity<?> deleteUniversity(@PathVariable Integer id) {

		frecDdispServiceImpl.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("frequency")
	public ResponseEntity<FrecDispRequest> addUniversity(@RequestBody FrecDispRequest keyword) {

		try {
			frecDdispServiceImpl.save(convertToEntity(keyword, null));

			final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
					.buildAndExpand(keyword.getFrequency()).toUri();
			return ResponseEntity.created(uri).body(keyword);
		} catch (ParseException e) {
			return (ResponseEntity<FrecDispRequest>) ResponseEntity.status(404);
		}
	}

	@PutMapping("frequency/{id}")
	public ResponseEntity<FrecDispRequest> editUniversity(@RequestBody FrecDispRequest keyword,
			@PathVariable Integer id) {
		try {
			frecDdispServiceImpl.save(convertToEntity(keyword, id));

			final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
					.buildAndExpand(keyword.getFrequency()).toUri();
			return ResponseEntity.created(uri).body(keyword);
		} catch (ParseException e) {
			return (ResponseEntity<FrecDispRequest>) ResponseEntity.status(404);
		}

	}

	private Generico convertToDto(GodDisponibilidad post) {
		Generico postDto = modelMapper.map(post, Generico.class);
		postDto.setId(post.getCddisponibilidad().intValue());
		postDto.setDescription(post.getDsdisponibilidad());
		return postDto;
	}

	private GodDisponibilidad convertToEntity(FrecDispRequest postDto, Integer id) throws ParseException {
		GodDisponibilidad post = modelMapper.map(postDto, GodDisponibilidad.class);
		if (id != null)
			post.setCddisponibilidad(id);
		
		post.setDsdisponibilidad(postDto.getFrequency());
		post.setCdusuario(0);
		post.setDeleted(0);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(localDateTime);
		post.setFemodificacion(timestamp);

		return post;
	}

}
