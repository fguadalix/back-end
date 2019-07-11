package com.axpe.od.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodCliente;
import com.axpe.od.repository.GodClienteRepository;
import com.axpe.od.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	GodClienteRepository godClienteRepository;

	@Override
	public List<GodCliente> getAllClients() {
		return godClienteRepository.findAll();
	}

	@Override
	public void saveCliente(GodCliente godCliente) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		godCliente.setCreationdate(now);
		godCliente.setLastmodifieddate(now);
		godClienteRepository.save(godCliente);
	}

	@Override
	public void deletedCliente(Integer idCliente) {
		godClienteRepository.deleteById(idCliente);
	}

	@Override
	public Optional<GodCliente> findById(Integer idCliente) {
		return godClienteRepository.findById(idCliente);
	}

	@Override
	public void updateCliente(GodCliente client) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		client.setLastmodifieddate(now);
		godClienteRepository.save(client);
	}

}
