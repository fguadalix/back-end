package com.axpe.od.mapper;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodProfesionale;
import com.axpe.od.model.Professional;
import com.axpe.od.repository.CadTipoTitulacionRepository;
import com.axpe.od.repository.CatAmbfuncionalRepository;
import com.axpe.od.repository.CatCategoryRepository;
import com.axpe.od.repository.CatPaisRepository;
import com.axpe.od.repository.CatProvinciaRepository;
import com.axpe.od.repository.CatSituProfesionalRepository;
import com.axpe.od.repository.CatTitulacioneRepository;
import com.axpe.od.repository.GodDisponibilidadRepository;

@Service
public class MapperProfesional {
	
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
	
	public MapperProfesional() {
		super();
	}

	public Professional godProffesionalToProfessional(GodProfesionale godProfesionale) {

		Professional resultado = new Professional();
		
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
		
		resultado.setMinWage(godProfesionale.getExpSalario1() != null ? godProfesionale.getExpSalario1().intValue() : 0);
		resultado.setMaxWage(godProfesionale.getExpSalario2() != null ? godProfesionale.getExpSalario2().intValue() : 0);
		
		resultado.setAvailability(godDisponibilidadRepository.getOne(godProfesionale.getCddisponibilidad()).getDsdisponibilidad());
		
		resultado.setProvince(catProvinciaRepository.getOne(godProfesionale.getCdprovincia()).getDsprovincia());
		resultado.setCountry(godProfesionale.getCdpais() != null?catPaisRepository.getOne(godProfesionale.getCdpais()).getPais():"España");
		
		resultado.setCertification(cadTipoTitulacionRepository.getOne(catTitulacioneRepository.getOne(godProfesionale.getGodProfTitulaciones().
				get(0).getCdtitulacion()).getCatTipoTitulacion().getCdtipoTitulacion()).getDstipoTitulacion());
		
		resultado.setSpecialization(catTitulacioneRepository.getOne(godProfesionale.getGodProfTitulaciones().
				get(0).getCdtitulacion()).getTitulacion());
		
		resultado.setUniversity(godProfesionale.getGodProfTitulaciones().get(0).getCatUniversidadCf().getDscentroFormativo());
		resultado.setUrl(godProfesionale.getLinkedin());
		resultado.setDescription(godProfesionale.getComentarios());
		resultado.setKeywords(godProfesionale.getGodAlertas().toString());
		resultado.setScore(godProfesionale.getCdvaloracion());
		resultado.setHasFiles(godProfesionale.getCvbinary() != null);
		resultado.setBusinessArea(godProfesionale.getCdAmbFuncional() != null?catAmbfuncionalRepository.getOne(godProfesionale.getCdAmbFuncional()).getDsambfuncional():" ");
		resultado.setLastModificationDate(godProfesionale.getFcmodificacion());	
		
		return resultado;
	}
	
	public GodProfesionale proffesionalToGodProfessional(Professional professional) {

		GodProfesionale resultado = new GodProfesionale();
		
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
		resultado.setFcmodificacion(professional.getLastModificationDate());
				
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
