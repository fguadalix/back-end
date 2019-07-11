//package com.axpe.od.jpa;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//
//import com.axpe.od.exceptions.EntityNotFoundException;
//import com.axpe.od.model.Assignation;
//import com.axpe.od.repository.AssignationRepository;
//import com.axpe.od.repository.PositionRepository;
//import com.axpe.od.repository.ProfessionalRepository;
//import java.util.Optional;
//import java.util.function.Supplier;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@Slf4j
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class AssignationRepositoryTest {
//
//  @Autowired
//  private AssignationRepository assignationRepository;
//
//  @Autowired
//  private ProfessionalRepository professionalRepository;
//
//  @Autowired
//  private PositionRepository peticionRepository;
//
//  private Supplier<EntityNotFoundException> entityNotFoundExceptionSupplier =
//      () -> new EntityNotFoundException("Candidate not found");
//  private Supplier<EntityNotFoundException> entityNotFoundExceptionSupplier1 =
//      () -> new EntityNotFoundException("Position not found");
//
//  @Autowired
//  private TestEntityManager entityManager;
//
//  @Test
//  public void givenTwoPosicionAndOneCandidato_whenSave_thenGetOk() {
//
//    Assignation assignation1 = new Assignation();
//    assignation1.setProfessional(
//        professionalRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier));
//    assignation1.setPosition(
//        peticionRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier1));
//    //assignation1.setInfo("test asignacion 1");
//
//    Assignation assignation2 = new Assignation();
//    assignation2.setProfessional(
//        professionalRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier));
//    assignation2.setPosition(
//        peticionRepository.findById(2L).orElseThrow(entityNotFoundExceptionSupplier1));
//    //assignation2.setInfo("test asignacion 1");
//
//    assignationRepository.save(assignation1);
//    assignationRepository.save(assignation2);
//
//    assertEquals(professionalRepository.findById(1L).get().getAsignaciones().size(), 2);
//    assertEquals(peticionRepository.findById(1L).get().getAsignaciones().size(), 1);
//    assertEquals(peticionRepository.findById(2L).get().getAsignaciones().size(), 1);
//  }
//
//  @Test
//  public void givenTwoCandidatesAndOnePosition_whenSave_thenGetOk() {
//
//    Assignation assignation1 = new Assignation();
//    assignation1.setProfessional(
//        professionalRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier));
//    assignation1.setPosition(
//        peticionRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier1));
//    //assignation1.setInfo("test asignacion 1");
//
//    Assignation assignation2 = new Assignation();
//    assignation2.setProfessional(
//        professionalRepository.findById(2L).orElseThrow(entityNotFoundExceptionSupplier));
//    assignation2.setPosition(
//        peticionRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier1));
//    //assignation2.setInfo("test asignacion 1");
//
//    assignationRepository.save(assignation1);
//    assignationRepository.save(assignation2);
//
//    assertEquals(peticionRepository.findById(1L).get().getAsignaciones().size(), 2);
//    assertEquals(professionalRepository.findById(1L).get().getAsignaciones().size(), 1);
//    assertEquals(professionalRepository.findById(2L).get().getAsignaciones().size(), 1);
//  }
//
//  // FIXME
//  public void givenTwoCandidatesAndOnePosition_whenDeleteOne_thenGetOk() {
//
//    Assignation assignation1 = new Assignation();
//    assignation1.setProfessional(
//        professionalRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier));
//    assignation1.setPosition(
//        peticionRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier1));
//    //assignation1.setInfo("test asignacion 1");
//
//    Assignation assignation2 = new Assignation();
//    assignation2.setProfessional(
//        professionalRepository.findById(2L).orElseThrow(entityNotFoundExceptionSupplier));
//    assignation2.setPosition(
//        peticionRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier1));
//    //assignation2.setInfo("test asignacion 1");
//
//    Assignation assignation_stored1 = assignationRepository.save(assignation1);
//    Assignation assignation_stored2 = assignationRepository.save(assignation2);
//
//    assertEquals(peticionRepository.findById(1L).get().getAsignaciones().size(), 2);
//    assertEquals(professionalRepository.findById(1L).get().getAsignaciones().size(), 1);
//    assertEquals(professionalRepository.findById(2L).get().getAsignaciones().size(), 1);
//
//    assignationRepository.deleteById(assignation_stored1.getAssignationId());
//    assertEquals(
//        assignationRepository.findById(assignation_stored1.getAssignationId()), Optional.empty());
//
//    entityManager.flush();
//    entityManager.clear();
//
//    assertEquals(peticionRepository.findById(1L).get().getAsignaciones().size(), 1);
//    assertNull(professionalRepository.findById(1L).get().getAsignaciones());
//    assertEquals(peticionRepository.findById(2L).get().getAsignaciones().size(), 1);
//  }
//
//  @Test
//  public void givenOneAsignacion_whenDeleteCandidate_thenAsignacionDeletedOk() {
//
//    Assignation assignation1 = new Assignation();
//    assignation1.setProfessional(
//        professionalRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier));
//    assignation1.setPosition(
//        peticionRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier1));
//    //assignation1.setInfo("test asignacion 1");
//    Assignation assignation_stored1 = assignationRepository.save(assignation1);
//
//    professionalRepository.deleteById(1L);
//    assertEquals(professionalRepository.findById(1L), Optional.empty());
//
//    assertEquals(
//        assignationRepository.findById(assignation_stored1.getAssignationId()), Optional.empty());
//  }
//
//  @Test
//  public void givenOneAsignacion_whenDeletePosicion_thenAsignacionDeletedOk() {
//
//    Assignation assignation1 = new Assignation();
//    assignation1.setProfessional(
//        professionalRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier));
//    assignation1.setPosition(
//        peticionRepository.findById(1L).orElseThrow(entityNotFoundExceptionSupplier1));
//    //assignation1.setInfo("test asignacion 1");
//    Assignation assignation_stored1 = assignationRepository.save(assignation1);
//
//    peticionRepository.deleteById(1L);
//    assertEquals(peticionRepository.findById(1L), Optional.empty());
//
//    assertEquals(
//        assignationRepository.findById(assignation_stored1.getAssignationId()), Optional.empty());
//  }
//}
