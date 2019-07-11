package com.axpe.od.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodHContacto;
import com.axpe.od.dao.GodProfesionale;
import com.axpe.od.mapper.MapperContact;
import com.axpe.od.model.Contact;
import com.axpe.od.model.Professional;
import com.axpe.od.repository.CadTipoTitulacionRepository;
import com.axpe.od.repository.CatAmbfuncionalRepository;
import com.axpe.od.repository.CatCategoryRepository;
import com.axpe.od.repository.CatPaisRepository;
import com.axpe.od.repository.CatProvinciaRepository;
import com.axpe.od.repository.CatSituProfesionalRepository;
import com.axpe.od.repository.CatTitulacioneRepository;
import com.axpe.od.repository.GodDisponibilidadRepository;
import com.axpe.od.repository.ProfessionalRepository;
import com.axpe.od.service.ProfessionalService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProfessionalServiceImpl implements ProfessionalService {

	@Autowired
	private ProfessionalRepository professionalRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CatCategoryRepository catCategoryRepository;
	@Autowired
	private CatSituProfesionalRepository catSituProfesionalRepository;
	@Autowired
	private GodDisponibilidadRepository godDisponibilidadRepository;
	@Autowired
	private CatProvinciaRepository catProvinciaRepository;
	@Autowired
	private CatPaisRepository catPaisRepository;
	@Autowired
	private CadTipoTitulacionRepository cadTipoTitulacionRepository;
	@Autowired
	private CatTitulacioneRepository catTitulacioneRepository;
	@Autowired
	private CatAmbfuncionalRepository catAmbfuncionalRepository;

	@Autowired
	private MapperContact mapperContact;

	public List<Professional> findAll() {

		List<GodProfesionale> collection = professionalRepository.findAll();

		return collection.stream().map(post -> convertToDto(post)).collect(Collectors.toList());

	}

	@Override
	public Professional getProfessional(Integer id) {
		log.debug("Entrada a Servicio ServiceProfessionalImpl metodo getProfessional");

		GodProfesionale godProffesional = professionalRepository.getOne(id);
		log.debug("godProffesional --> " + godProffesional);

		Professional professional = convertToDto(godProffesional);

		return professional;
	}

	@Override
	public List<Contact> getContactsOfProfessional(Integer id) {

		GodProfesionale godProffesional = professionalRepository.getOne(id);

		List<GodHContacto> contactos = godProffesional.getGodHContactos();

		List<Contact> respuesta = mapperContact.godHContactoListToContactList(contactos);

		return respuesta;
	}

	@Override
	public void deletProfessional(Integer id) {
		professionalRepository.deleteById(id);
	}

	@Override
	public void saveProfessional(Professional professional) {
		professionalRepository.save(convertToEntity(professional));

	}

	private Professional convertToDto(GodProfesionale godProfesionale) {
		Professional resultado = modelMapper.map(godProfesionale, Professional.class);

		resultado.setProfessionalId(godProfesionale.getCdprofesional());
		resultado.setName(godProfesionale.getNombre());
		resultado.setDni(godProfesionale.getDni());
		resultado.setBirthDate(godProfesionale.getFcnacimiento());
		resultado.setEmail(godProfesionale.getCorreo());
		resultado.setFirstLastName(godProfesionale.getApellido1());
		resultado.setSecondLastName(godProfesionale.getApellido2());
		resultado.setPhoneNumber(godProfesionale.getTelefono1());
		resultado.setCellNumber(godProfesionale.getTelefono2());
		resultado.setWorkCategory(catCategoryRepository.getOne(godProfesionale.getCdcategoria()).getDscategoria());
		resultado.setState(catSituProfesionalRepository.getOne(godProfesionale.getCdsituProf()).getDssituProf());
		resultado.setMinWage(godProfesionale.getExpSalario1().intValue());
		resultado.setMaxWage(godProfesionale.getExpSalario2().intValue());
		resultado.setAvailability(
				godDisponibilidadRepository.getOne(godProfesionale.getCddisponibilidad()).getDsdisponibilidad());
		resultado.setProvince(catProvinciaRepository.getOne(godProfesionale.getCdprovincia()).getDsprovincia());
		resultado.setCountry(
				godProfesionale.getCdpais() != null ? catPaisRepository.getOne(godProfesionale.getCdpais()).getPais()
						: " ");

		if (godProfesionale.getGodProfTitulaciones() != null && !godProfesionale.getGodProfTitulaciones().isEmpty()) {
			try {
				resultado.setCertification(cadTipoTitulacionRepository
						.getOne(godProfesionale.getGodProfTitulaciones().get(0).getCdprofTitulacion())
						.getDstipoTitulacion());
				resultado.setSpecialization(catTitulacioneRepository
						.getOne(godProfesionale.getGodProfTitulaciones().get(0).getCdtitulacion()).getTitulacion());
				resultado.setUniversity(
						godProfesionale.getGodProfTitulaciones().get(0).getCatUniversidadCf().getDscentroFormativo());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		resultado.setUrl(godProfesionale.getLinkedin());
		resultado.setDescription(godProfesionale.getComentarios());
		resultado.setKeywords(godProfesionale.getGodAlertas().toString());
		resultado.setScore(godProfesionale.getCdvaloracion());
		resultado.setHasFiles(godProfesionale.getCvbinary() != null);
		resultado.setBusinessArea(godProfesionale.getCdAmbFuncional() != null
				? catAmbfuncionalRepository.getOne(godProfesionale.getCdAmbFuncional()).getDsambfuncional()
				: " ");
		resultado.setLastModificationDate(godProfesionale.getFcmodificacion());
		return resultado;
	}

	private GodProfesionale convertToEntity(Professional professional) {
		GodProfesionale resultado = modelMapper.map(professional, GodProfesionale.class);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		resultado.setCdprofesional(professional.getProfessionalId());
		resultado.setNombre(professional.getName());
		resultado.setDni(professional.getDni());
		resultado.setFcnacimiento(professional.getBirthDate());
		resultado.setCorreo(professional.getEmail());
		resultado.setApellido1(professional.getFirstLastName());
		resultado.setApellido2(professional.getSecondLastName());
		resultado.setTelefono1(professional.getPhoneNumber());
		resultado.setTelefono2(professional.getCellNumber());
		resultado.setExpSalario1(BigDecimal.valueOf(professional.getMinWage()));
		resultado.setExpSalario2(BigDecimal.valueOf(professional.getMaxWage()));
		resultado.setLinkedin(professional.getUrl());
		resultado.setComentarios(professional.getDescription());
		resultado.setCdvaloracion(professional.getScore());
		resultado.setFcaltaBd(now);
		resultado.setFcmodificacion(professional.getLastModificationDate());
		resultado.setCdusuario(1);
		resultado.setCdempresa(1);
		resultado.setDeleted(1);
//		resultado.setKeywords(professional.getGodAlertas().toString());
		resultado.setCdAmbFuncional(catAmbfuncionalRepository.getIdFromDescription(professional.getBusinessArea()));
		resultado.setCdcategoria(catCategoryRepository.getIdFromCategoryName(professional.getWorkCategory()));
		resultado.setCdsituProf(catSituProfesionalRepository.getIdFromDescription(professional.getState()));
		resultado.setCddisponibilidad(godDisponibilidadRepository.getIdFromDescription(professional.getAvailability()));
		resultado.setCdprovincia(catProvinciaRepository.getIdFromProvinceName(professional.getProvince()));
		resultado.setCdpais(catPaisRepository.getIdFromCountryName(professional.getCountry()));
//		resultado.setCertification(cadTipoTitulacionRepository.getOne(catTitulacioneRepository.getOne(godProfesionale.getGodProfTitulaciones().
//				get(0).getCdtitulacion()).getCatTipoTitulacion().getCdtipoTitulacion()).getDstipoTitulacion());
//		
//		resultado.setSpecialization(catTitulacioneRepository.getOne(godProfesionale.getGodProfTitulaciones().
//				get(0).getCdtitulacion()).getTitulacion());
//		
//		resultado.setUniversity(godProfesionale.getGodProfTitulaciones().get(0).getCatUniversidadCf().getDscentroFormativo());

		return resultado;
	}

}
