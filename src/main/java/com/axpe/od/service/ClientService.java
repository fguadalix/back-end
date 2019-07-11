package com.axpe.od.service;

import java.util.List;

import com.axpe.od.dao.GodCliente;

public interface ClientService {

	List<GodCliente> getAllClients();
	void saveCliente(GodCliente godCliente);
	void deletedCliente(Integer idCliente);
	Object findById(Integer idCliente);
	void updateCliente(GodCliente client);
}
