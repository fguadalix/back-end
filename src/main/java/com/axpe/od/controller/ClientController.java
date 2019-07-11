package com.axpe.od.controller;

import java.net.URI;
import java.util.List;

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

import com.axpe.od.dao.GodCliente;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.service.impl.ClientServiceImpl;

@RequestMapping(value = "/v1/", produces = "application/hal+json")
@RestController
public class ClientController {

	@Autowired
	ClientServiceImpl clientServiceImpl;

	@GetMapping(value = "client")
	public List<GodCliente> getAllClients() throws EntityNotFoundException {

		return clientServiceImpl.getAllClients();
	}

	@PostMapping("client")
	public ResponseEntity<GodCliente> addClient(@RequestBody GodCliente client) {

		clientServiceImpl.saveCliente(client);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
				.buildAndExpand(client.getClienteid()).toUri();
		return ResponseEntity.created(uri).body(client);
	}

	@PutMapping("client")
	public ResponseEntity<GodCliente> updateClient(@RequestBody GodCliente client) {

		clientServiceImpl.saveCliente(client);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
				.buildAndExpand(client.getClienteid()).toUri();
		return ResponseEntity.created(uri).body(client);
	}
  @DeleteMapping("client/{id}")
  public ResponseEntity<?> deleteClient(@PathVariable Integer id) {

    return clientServiceImpl
        .findById(id)
        .map(
            p -> {
            	clientServiceImpl.deletedCliente(id);
              return ResponseEntity.ok().build();
            })
        .orElseThrow(
            () -> new EntityNotFoundException(String.format("Client with id %d not found", id)));
  }


	@PutMapping("client/{id}")
	public ResponseEntity<GodCliente> editClient(@RequestBody GodCliente client, @PathVariable Integer idClient) {

		if (clientServiceImpl.findById(idClient).isPresent()) {
			client.setClienteid(idClient);
			clientServiceImpl.updateCliente(client);
			final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
					.buildAndExpand(client.getClienteid()).toUri();
			return ResponseEntity.created(uri).body(client);
		} else {
			throw new EntityNotFoundException(
					String.format("Professional with contactId %d not found, cannot modify Professional", idClient));
		}
	}
}
