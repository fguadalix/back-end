//package com.axpe.od.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.axpe.od.dao.CatTag;
//import com.axpe.od.model.Specialization;
//import com.axpe.od.repository.KeywordRepository;
//import com.axpe.od.repository.SpecializationRepository;
//import com.axpe.od.service.SpecializationService;
//
///***
// * CLASE CON LA LOGICA DE NEGOCIO ENDPOINT - Es llamada desde las clases
// * controlLER - consume las funciones jpaRepository - Mapea front - back
// *
// */
//
//@Service
//public class SpecializationServiceImpl implements SpecializationService {
//
//	
//
//	@Autowired
//	SpecializationRepository specializationRepository;
//
//	@Override
//	public List<Specialization> findAllByCertificationId(Integer id) {
//		return specializationRepository.findAllByCertificationId(id);
//	}
//
//	@Override
//	public Specialization save(Specialization specialization) {
//		return specializationRepository.save(specialization);
//	}
//
//	@Override
//	public Specialization update(Specialization specialization) {
//		return specializationRepository.save(specialization);
//		
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		specializationRepository.deleteById(id);
//	}
//
//}
