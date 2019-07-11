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

import com.axpe.od.dao.CatTag;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.Keyword;
import com.axpe.od.service.KeywordService;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class KeywordController {
  
  @Autowired
  private ModelMapper modelMapper;
 
  private final KeywordService keywordService;

  @Autowired
  public KeywordController(KeywordService keywordService) {
    this.keywordService = keywordService;
  }

  @GetMapping(value = "keyword")
  public List<Keyword> getAllKeywords() throws EntityNotFoundException {

	List<CatTag> posts = keywordService.getAllKeywords();
    return posts.stream()
      .map(post -> convertToDto(post))
      .collect(Collectors.toList());
  }

  @DeleteMapping("keyword/{id}")
  public ResponseEntity<?> deleteKeyword(@PathVariable Integer id) {

    keywordService.deleteById(id);
    return ResponseEntity.ok().build();
//        .findById(id)
//        .map(
//            p -> {
//              keywordRepository.deleteById(id);
//              return ResponseEntity.ok().build();
//            })
//        .orElseThrow(
//            () -> new EntityNotFoundException(String.format("Keyword with id %d not found", id)));
  }

  @PostMapping("keyword")
  public ResponseEntity<Keyword> addKeyword(@RequestBody Keyword keyword) {

	  try {
		  	keywordService.save(convertToEntity(keyword));

		    final URI uri =
		        MvcUriComponentsBuilder.fromController(getClass())
		            .path("/{id}")
		            .buildAndExpand(keyword.getKeywordId())
		            .toUri();
		    return ResponseEntity.created(uri).body(keyword);
		} catch (ParseException e) {
			return (ResponseEntity<Keyword>) ResponseEntity.status(404);
		}
  }

  @PutMapping("keyword/{id}")
  public ResponseEntity<Keyword> editKeyword(@RequestBody Keyword keyword, @PathVariable long id) {
      final URI uri =
      MvcUriComponentsBuilder.fromController(getClass())
          .path("/{id}")
          .buildAndExpand(keyword.getKeywordId())
          .toUri();
	  try {
		keywordService.save(convertToEntity(keyword));
			return ResponseEntity.created(uri).body(keyword);
		} catch (ParseException e) {
			return (ResponseEntity<Keyword>) ResponseEntity.status(404);
		}
//    if (keywordRepository.findById(id).isPresent()) {
//      keyword.setKeywordId(id);
//      keywordRepository.save(keyword);
//      final URI uri =
//          MvcUriComponentsBuilder.fromController(getClass())
//              .path("/{id}")
//              .buildAndExpand(keyword.getKeywordId())
//              .toUri();
//      return ResponseEntity.created(uri).body(keyword);
//    } else {
//      throw new EntityNotFoundException(
//          String.format(
//              "Professional with contactId %d not found, cannot modify Professional", id));
//    }
  }
  
  private Keyword convertToDto(CatTag post) {
	  Keyword postDto = modelMapper.map(post, Keyword.class);
	  postDto.setKeywordId(post.getCdtag().intValue());
	  postDto.setKeyword(post.getDstag());
	    return postDto;
	}
  
  private CatTag convertToEntity(Keyword postDto) throws ParseException {
	  CatTag post = modelMapper.map(postDto, CatTag.class);
	  post.setCdtag(postDto.getKeywordId());
	  post.setDstag(postDto.getKeyword());
		
	  LocalDateTime localDateTime = LocalDateTime.now();
	  Timestamp timestamp = Timestamp.valueOf(localDateTime);
	  post.setFemodificacion(timestamp);

      return post;
	}
}
