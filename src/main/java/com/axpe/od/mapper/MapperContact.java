package com.axpe.od.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodHContacto;
import com.axpe.od.model.Contact;
import com.axpe.od.repository.CatSituProfesionalRepository;

@Service
public class MapperContact {
	
	@Autowired
	private CatSituProfesionalRepository catSituProfesionalRepository;

	public Contact godHContactoToContact (GodHContacto godHContacto) {
	
		Contact respuesta = new Contact();
		
		respuesta.setContactId(godHContacto.getClHContactos());
		respuesta.setContactDate(godHContacto.getFecha());
		respuesta.setAvailability(godHContacto.getGodDisponibilidad().getDsdisponibilidad());
		respuesta.setCurrentWage(godHContacto.getGodProfesionale().getExpSalario1().intValue());
		respuesta.setExpectedWage(godHContacto.getGodProfesionale().getExpSalario2().intValue());
		respuesta.setInformation(godHContacto.getComentarios());
		respuesta.setProfessionalName(godHContacto.getGodProfesionale().getNombre());
		respuesta.setRecruiter(godHContacto.getCdempleado().toString());
		respuesta.setScore(godHContacto.getCatValoracion()!=null?
				godHContacto.getCatValoracion().getDsvaloracion():
					"Sin valoración");
		respuesta.setState(catSituProfesionalRepository.getOne(godHContacto.getGodProfesionale().getCdsituProf()).getDssituProf());
		
		return respuesta;
	}
	
	public List<Contact> godHContactoListToContactList (List<GodHContacto> godHContactoList){
		
		List<Contact> ContactList = new ArrayList<Contact>();
		
		for (GodHContacto godHContacto : godHContactoList) {
			ContactList.add(godHContactoToContact(godHContacto));
		}
		return ContactList;
	}
	
}
