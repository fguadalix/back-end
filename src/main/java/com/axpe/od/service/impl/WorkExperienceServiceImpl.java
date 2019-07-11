package com.axpe.od.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.od.dao.GodProfExp;
import com.axpe.od.mapper.MapperProfesional;
import com.axpe.od.model.WorkExperience;
import com.axpe.od.repository.CatCategoriaRepository;
import com.axpe.od.repository.WorkExperienceRepository;
import com.axpe.od.service.WorkExperienceService;

/***
 * CLASE CON LA LOGICA DE NEGOCIO ENDPOINT - Es llamada desde las clases
 * controlLER - consume las funciones jpaRepository - Mapea front - back
 *
 */

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

	@Autowired
	WorkExperienceRepository workExperienceRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MapperProfesional mapperProfesional;
	
	@Autowired
	private CatCategoriaRepository catCategoriaRepository;

	@Override
	public void save(WorkExperience workEperience) {
		workExperienceRepository.save(convertToEntity(workEperience));
	}

	@Override
	public void update(WorkExperience workEperience) {
		workExperienceRepository.save(convertToEntity(workEperience));
	}

	@Override
	public void deleteById(Integer id) {
		workExperienceRepository.deleteById(id);

	}

	@Override
	public List<WorkExperience> findAllByProfessionalId(Integer professionalId) {

		List<GodProfExp> godProfExpList = workExperienceRepository.findAllByProfessionalId(professionalId);

		return godProfExpList.stream().map(post -> convertToDto(post)).collect(Collectors.toList());
	}

	@Override
	public WorkExperience findByWorkIdAndProfessionalId(Integer workId, Integer professionalId) {
		Optional<GodProfExp> godProfExp = workExperienceRepository.findByWorkIdAndProfessional_ProfessionalId(professionalId, workId);
		return convertToDto(godProfExp.get());
	}

	private WorkExperience convertToDto(GodProfExp post) {
		WorkExperience postDto = modelMapper.map(post, WorkExperience.class);
		postDto.setWorkId(post.getCdprofExp());
		postDto.setCdprofessional(post.getGodProfesionale().getCdprofesional());
		postDto.setCategory(post.getCatCategoria().getDscategoria());
		postDto.setClient(post.getCliente());
		postDto.setDescription(post.getComentarios());
		postDto.setStartDate(post.getFechaDesde());
		postDto.setEndDate(post.getFechaHasta());
		postDto.setProfessional(mapperProfesional.godProffesionalToProfessional(post.getGodProfesionale()));
		postDto.setStillThere(post.getStillthere() != null ? post.getStillthere() : false);
		return postDto;
	}

	private GodProfExp convertToEntity(WorkExperience postDto) {
		GodProfExp post = modelMapper.map(postDto, GodProfExp.class);
		post.setCdprofExp(postDto.getWorkId());
		post.setCdusuario(postDto.getProfessional().getProfessionalId());
		post.setCliente(postDto.getClient());
		post.setComentarios(postDto.getDescription());
		post.setFechaDesde(postDto.getStartDate());
		post.setFechaHasta(postDto.getEndDate());
		post.setCatCategoria(catCategoriaRepository.findByCategory(postDto.getCategory()));
		post.setStillthere(postDto.isStillThere());
		return post;
	}

}
