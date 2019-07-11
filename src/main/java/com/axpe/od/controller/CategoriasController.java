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

import com.axpe.od.dao.CatCategoria;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.CategoriaRequest;
import com.axpe.od.model.Generico;
import com.axpe.od.model.Keyword;
import com.axpe.od.service.CategoriasService;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class CategoriasController {

	@Autowired
	private CategoriasService categoriasServiceImpl;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "category")
	public List<Generico> getAllCategorias() throws EntityNotFoundException {
		List<CatCategoria> posts = categoriasServiceImpl.getAllCategories();
		return posts.stream().map(post -> convertToDto(post)).collect(Collectors.toList());

	}
	
	@DeleteMapping("category/{id}")
	 public ResponseEntity<?> deleteKeyword(@PathVariable Integer id) {

	    categoriasServiceImpl.deleteById(id);
	    return ResponseEntity.ok().build();
	  }

	  @PostMapping("category")
	  public ResponseEntity<CategoriaRequest> addKeyword(@RequestBody CategoriaRequest keyword) {

		  try {
			  	categoriasServiceImpl.save(convertToEntity(keyword,null));

			    final URI uri =
			        MvcUriComponentsBuilder.fromController(getClass())
			            .path("/{id}")
			            .buildAndExpand(keyword.getCategory())
			            .toUri();
			    return ResponseEntity.created(uri).body(keyword);
			} catch (ParseException e) {
				return (ResponseEntity<CategoriaRequest>) ResponseEntity.status(404);
			}
	  }

	  @PutMapping("category/{id}")
	  public ResponseEntity<CategoriaRequest> editKeyword(@RequestBody CategoriaRequest keyword, @PathVariable Integer id) {
		  try {
			  	categoriasServiceImpl.save(convertToEntity(keyword,id));

			    final URI uri =
			        MvcUriComponentsBuilder.fromController(getClass())
			            .path("/{id}")
			            .buildAndExpand(keyword.getCategory())
			            .toUri();
			    return ResponseEntity.created(uri).body(keyword);
			} catch (ParseException e) {
				return (ResponseEntity<CategoriaRequest>) ResponseEntity.status(404);
			}
	  }

	private Generico convertToDto(CatCategoria post) {
		Generico postDto = modelMapper.map(post, Generico.class);
		postDto.setId(post.getCdcategoria().intValue());
		postDto.setDescription(post.getDscategoria());
		return postDto;
	}

	private CatCategoria convertToEntity(CategoriaRequest postDto,Integer id) throws ParseException {
		CatCategoria post = modelMapper.map(postDto, CatCategoria.class);
		if(id != null) post.setCdcategoria(id);
		post.setCdusuario(0);
		post.setCodcategoria(0);
		post.setDscategoria(postDto.getCategory());
		post.setDeleted(0);
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(localDateTime);
		post.setFemodificacion(timestamp);

		return post;
	}
}
