package com.axpe.od.mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.CatCategoria;
import com.axpe.od.dao.CatPrioridad;
import com.axpe.od.dao.CatSituPeticion;
import com.axpe.od.dao.CatTipoAmbfuncional;
import com.axpe.od.dao.GodAdjunto;
import com.axpe.od.dao.GodCliente;
import com.axpe.od.dao.GodPetiTitulacione;
import com.axpe.od.dao.GodPeticiones;
import com.axpe.od.exceptions.EntityNotFoundException;
import com.axpe.od.model.DBFile;
import com.axpe.od.model.Position;
import com.axpe.od.repository.CatCategoriaRepository;
import com.axpe.od.repository.CatPrioridadRepository;
import com.axpe.od.repository.CatSituPeticionRepository;
import com.axpe.od.repository.CatTipoAmbfuncionalRepository;
import com.axpe.od.repository.GodClienteRepository;
import com.axpe.od.repository.GodPetiTitulacioneRepository;

@Service
public class MapperPosition {

	@Autowired
	CatTipoAmbfuncionalRepository catTipoAmbfuncionalRepository;

	@Autowired
	GodPetiTitulacioneRepository godPetiTitulacioneRepository;

	@Autowired
	GodClienteRepository godClienteRepository;

	@Autowired
	CatCategoriaRepository catCategoriaRepository;

	@Autowired
	CatPrioridadRepository catPrioridadRepository;
	
	@Autowired
	CatSituPeticionRepository catSituPeticionRepository;

	final String COMPANY = "Axpe Consulting";

	public GodPeticiones positionToGodpeticiones(Position position) {

		GodPeticiones godpeticiones = new GodPeticiones();

		// godpeticiones.setCdpeticion((int) (long) position.getPositionId());
		godpeticiones.setCdemprClie(seachIdClient(position.getClient()));

		godpeticiones.setCatCategoria(searchCategory(position.getWorkCategory()));

		godpeticiones.setCatPrioridad(searchByPrio(position.getPriority()));

		godpeticiones.setCatSituPeticion(searchState(position.getState()));

		/* este campo es obligaorio en la tabla GodPeticiones */
		godpeticiones.setFcentrada(new Timestamp(System.currentTimeMillis()));
		/* Timestamp timestamp= Timestamp.valueOf(position.getPositionDate()); */
		if (position.getPositionDate() != null) {
			godpeticiones.setFcsolicitud(Timestamp.valueOf(position.getPositionDate()));
		}

		godpeticiones.setDescripcion(position.getDescription());
		godpeticiones.setNumTecnicos(position.getNumProfessionals());
		godpeticiones.setTarifa(position.getRate());
		if (position.getIncorporationDate() != null) {
			godpeticiones.setFcincorporacion(Timestamp.valueOf(position.getIncorporationDate()));
		}
		//TODO column obligatoria, si es null inserta fecha actual
		else {
			
			godpeticiones.setFcincorporacion(new Timestamp(System.currentTimeMillis()));
		}
		
		
		if (position.getUnit() != null) {
			godpeticiones.setCdunidad(searchByUnit(position.getUnit()));
		}

		godpeticiones.setComentarios(position.getShortDescription());
		godpeticiones.setClaveExterna(position.getExternalKey());
		godpeticiones.setFcmodificacion(new Timestamp(System.currentTimeMillis()));
		godpeticiones.setDepartamento(position.getDepartment());
		godpeticiones.setDuracionServ(position.getDuration());
		godpeticiones.setExpSalario1(BigDecimal.valueOf(position.getMinWage()));
		godpeticiones.setExpSalario2(BigDecimal.valueOf(position.getMaxWage()));
		godpeticiones.setArchivo(position.getHasFiles().booleanValue());
		godpeticiones.setTecnico(position.getRecruiter());
		godpeticiones.setManager(position.getManager());
		godpeticiones.setProyecto(position.getProject());
		//TODO Dato obligatorio , por defecto ponemos 1
		godpeticiones.setCdusuario(1);
		//TODO gerente obligatorio , de momento pongo 46
		godpeticiones.setCdgerente(46);
		godpeticiones.setDeleted(0);

//		godpeticiones.setCdTipoTitulacion(position.getCertification());		
//		godpeticiones.setCdtitulacion(position.getSpecialization());
//		godpeticiones.setPalabrasclaves(position.getKeywords());

		return godpeticiones;

	}

	/*
	 * FECHAS : monolito_god : Timestamp odbd: LocalDateTime
	 */

	/*
	 * MAPEA UN GOD PETICIONES A FRONT: obligatorios para odbd : unit, priority,
	 * state, positionDate
	 */
	public Position godPeticionesToPosition(GodPeticiones godPeticion) {

		// Position position = new Position() ;
		Position position = Position.builder().build();
		position.setPositionId(godPeticion.getCdpeticion().longValue());
		position.setUnit(searchUnit(godPeticion.getCdunidad()));
		position.setPriority(godPeticion.getCatPrioridad().getDsprioridad());
		position.setState(godPeticion.getCatSituPeticion().getDssituPeti());

		if (godPeticion.getFcsolicitud() != null) {
			position.setPositionDate(godPeticion.getFcsolicitud().toLocalDateTime());
		} else {
			position.setPositionDate(LocalDateTime.now());
		}

		position.setCompany(COMPANY);
		position.setRecruiter(godPeticion.getTecnico());
		position.setManager(godPeticion.getManager());
		position.setWorkCategory(godPeticion.getCatCategoria().getDscategoria());
		position.setNumProfessionals(godPeticion.getNumTecnicos());
		position.setRate(godPeticion.getTarifa());

		if (godPeticion.getExpSalario1() != null) {
			position.setMinWage(godPeticion.getExpSalario1().intValueExact());
		} else {

			position.setMinWage(0);
		}

		if (godPeticion.getExpSalario2() != null) {
			position.setMaxWage(godPeticion.getExpSalario2().intValueExact());
		} else {
			position.setMaxWage(0);
		}

		position.setDuration(godPeticion.getDuracionServ());
		position.setDescription(godPeticion.getDescripcion());
		position.setIncorporationDate(godPeticion.getFcincorporacion().toLocalDateTime());
		position.setKeywords(godPeticion.getPalabrasclaves());
		position.setExternalKey(godPeticion.getClaveExterna());
		position.setShortDescription(godPeticion.getComentarios());
		position.setDepartment(godPeticion.getDepartamento());
		position.setHasFiles(godPeticion.getArchivo());
		position.setClient(searchClient(godPeticion.getCdemprClie()));

		/*
		 * nombre de la titulacion, una peticion puede tener muchas titulaciones
		 * (oneToMany), de momento solo se recoge y lerr un elemento de esos valores de
		 * titulaciones ya que BD_OD tiene oneToOne
		 */
		/*
		 * position.setSpecialization(searchTitulation
		 * (godPeticion.getGodPetiTitulaciones().get(0).getCdpetiTitulacion()));
		 */

		if( godPeticion.getGodPetiTitulaciones() != null &&  godPeticion.getGodPetiTitulaciones().size() > 0 ) {
			position.setSpecialization(godPeticion.getGodPetiTitulaciones().get(0).getCatTitulacione().getTitulacion());

		/* Nombre del tipo de titulacion */
		position.setCertification(godPeticion.getGodPetiTitulaciones().get(0).getCatTitulacione().getCatTipoTitulacion()
				.getDstipoTitulacion());
		}

		return position;
	}
	
	public List<Position> listGodPeticionesToPosition (List<GodPeticiones> listGodPeticiones){
		List<Position> listPosition = new ArrayList <> ();
		for (GodPeticiones godPeticiones: listGodPeticiones) {
			
			Position position = godPeticionesToPosition (godPeticiones);
			listPosition.add(position);
		}
		
		
		return listPosition;
	}
	
	

	private Integer seachIdClient(String cliente) {

		GodCliente client = godClienteRepository.searchByClient(cliente);

		if (client != null) {

			return client.getClienteid();
		}

		else
			return 0;
	}

	private String searchClient(Integer id) {
		Optional<GodCliente> client = godClienteRepository.findById(id);
		if(client.isPresent()) {
			return client.get().getClient();
		}
		else {
			return "";
		}
		

	}

	private String searchUnit(Integer id) {

		Optional<CatTipoAmbfuncional> unitObj = catTipoAmbfuncionalRepository.findById(id);
		if( unitObj.isPresent()) {
//		if(unitObj !=null || !unitObj.get().getDstipoAmbfuncional().isEmpty()) {
			
			return unitObj.get().getDstipoAmbfuncional();
			
		}
		else {
			return "";
		}
		
		// .map(p-> p.getDsunidad());
				//.orElseThrow(() -> new EntityNotFoundException(String.format("Unit with id %d not found", id)));

	}

	private Integer searchByUnit(String unit) {

		CatTipoAmbfuncional unitObj = catTipoAmbfuncionalRepository.findByUnit(unit);
		if (unitObj != null) {
			return unitObj.getCdtipoAmbfuncional();

		} else
			return 0;
	}

	private CatCategoria searchCategory(String category) {
		CatCategoria categoria = catCategoriaRepository.findByCategory(category);
		if (categoria != null) {
			return categoria;
		} else
			return catCategoriaRepository.findByCategory("Sin Categoria");
	}

	private CatPrioridad searchByPrio(String priority) {

		CatPrioridad category = catPrioridadRepository.searchByPriority(priority);
		if (category != null) {
			return category;
		}
		// TODO front no contempla este dato como obligatorio pero en BD si lo es. Si no
		// encuentra se pone como 'prioridad Baja'
		return catPrioridadRepository.searchByPriority("Baja");
	}
	
	private CatSituPeticion  searchState(String state) {
		
		CatSituPeticion situPeti = catSituPeticionRepository.searchByState(state);
		if(situPeti != null) {
			return situPeti;
		}
		//TODO quitar como obligatorio en monoloto_god, de momento dev  'Abierta Atendida'
		return catSituPeticionRepository.searchByState("Abierta Atendida");
	}
}