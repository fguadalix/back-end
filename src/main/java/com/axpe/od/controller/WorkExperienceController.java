package com.axpe.od.controller;

import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.axpe.od.model.Professional;
import com.axpe.od.model.WorkExperience;
import com.axpe.od.model.resource.WorkExperienceResource;
import com.axpe.od.service.ProfessionalService;
import com.axpe.od.service.WorkExperienceService;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class WorkExperienceController {

	@Autowired
	private WorkExperienceService workExperienceService;
	@Autowired
	private ProfessionalService professionalService;

	@GetMapping(value = "/professional/{professionalId}/workExperience")
	public ResponseEntity<Resources<WorkExperienceResource>> getAllWorkExperienceByProfessionalId(
			@PathVariable Integer professionalId) {

		List<WorkExperience> workExperienceList = workExperienceService.findAllByProfessionalId(professionalId);
		List<WorkExperienceResource> collection = new ArrayList<WorkExperienceResource>();
		for (WorkExperience workExperience : workExperienceList) {
			collection.add(new WorkExperienceResource(workExperience));
		}
		final Resources<WorkExperienceResource> resources = new Resources<>(collection);
		return ResponseEntity.ok(resources);
	}

	@GetMapping(value = "/professional/{professionalId}/workExperience/{workId}")
	public ResponseEntity<WorkExperienceResource> getWorkExperienceById(@PathVariable Integer professionalId,
			@PathVariable Integer workId) {
		return ResponseEntity.ok(new WorkExperienceResource(
				workExperienceService.findByWorkIdAndProfessionalId(workId, professionalId)));
	}

	@DeleteMapping("/professional/{professionalId}/workExperience/{workId}")
	public ResponseEntity<?> deleteWorkExperienceById(@PathVariable Integer professionalId,
			@PathVariable Integer workId) {
		workExperienceService.deleteById(workId);
		return ResponseEntity.ok().build();

	}

	@PostMapping(value = "/professional/{professionalId}/workExperience", consumes = "application/json")
	public ResponseEntity<WorkExperienceResource> addWorkExperience(@RequestBody WorkExperience workExperience,
			@PathVariable Integer professionalId) throws ParseException {
		workExperienceService.save(workExperience);
		WorkExperienceResource savedWork = new WorkExperienceResource(workExperience);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
				.buildAndExpand(savedWork.getWorkExperience().getWorkId()).toUri();
		return ResponseEntity.created(uri).body(savedWork);
	}

	@PutMapping(value = "/professional/{professionalId}/workExperience/{workId}", consumes = "application/json")
	public ResponseEntity<WorkExperienceResource> updateWorkExperience(@RequestBody WorkExperience workExperience,
			@PathVariable Integer professionalId, @PathVariable Integer workId) {

		WorkExperience savedWork = workExperienceService
				.findByWorkIdAndProfessionalId(workId, professionalId);

		Professional professional = professionalService.getProfessional(professionalId);

		workExperience.setProfessional(professional);
		workExperience.setWorkId(savedWork.getWorkId());
		workExperienceService.save(workExperience);
		final WorkExperienceResource resource = new WorkExperienceResource(workExperience);
		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).body(resource);
	}

}
