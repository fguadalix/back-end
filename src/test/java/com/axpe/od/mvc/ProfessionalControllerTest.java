//package com.axpe.od.mvc;
//
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.axpe.od.controller.ProfessionalController;
//import com.axpe.od.exceptions.ApiExceptionHandler;
//import com.axpe.od.model.Professional;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import java.util.Optional;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.Mockito;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {ProfessionalController.class})
//@Import(ProfessionalControllerTest.Config.class)
//@FixMethodOrder(MethodSorters.JVM)
//@Slf4j
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class ProfessionalControllerTest {
//
//  @Autowired
//  private ProfessionalController professionalController;
//
//  private MockMvc mockMvc;
//
//  private Professional professional = new Professional();
//
//  @Before
//  public void setUp() {
//    mockMvc =
//            MockMvcBuilders.standaloneSetup(professionalController)
//                    .setControllerAdvice(new ApiExceptionHandler())
//                    .build();
//
//    professional.setName("francisco");
//    professional.setFirstLastName("martinez");
//    professional.setSecondLastName("lopez");
//    professional.setDni("lopez");
//    professional.setEmail("foo@bar.com");
//    professional.setPhoneNumber("45456561");
//    professional.setWorkCategory("comercial");
//    professional.setState("desempleado");
//    professional.setMinWage(0);
//    professional.setMaxWage(45);
//    professional.setAvailability("abierta");
//    professional.setCountry("España");
//    professional.setProvince("madrid");
//    professional.setCertification("it");
//    professional.setSpecialization("informatica");
//    professional.setUniversity("urjc");
//    professional.setScore(6);
//    professional.setBusinessArea("tururu");
//  }
//
//  @Test
//  public void createAndRetrieveProfessional() throws Exception {
//
//    when(professionalService.getProfessionalById(1L)).thenReturn(Optional.of(professional));
//
//    MvcResult result =
//            mockMvc
//                    .perform(get("/v1/professional/1"))
//                    .andExpect(status().isOk())
//                    .andExpect(content().contentType(APPLICATION_JSON_UTF8))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("España"))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.maxWage").value(45))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.score").value(6))
//                    .andReturn();
//
//    log.info(result.getResponse().getContentAsString());
//    verify(professionalService, times(1)).getProfessionalById(1L);
//  }
//
//  @Test
//  public void createAndUpdateProfessional() throws Exception {
//
//    when(professionalService.getProfessionalById(1L)).thenReturn(Optional.of(professional));
//
//    MvcResult result =
//            mockMvc
//                    .perform(get("/v1/professional/1"))
//                    .andExpect(status().isOk())
//                    .andExpect(content().contentType(APPLICATION_JSON_UTF8))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("España"))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.maxWage").value(45))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.score").value(6))
//                    .andReturn();
//
//    ProfessionalDto professionalInputDto = new ProfessionalDto();
//    BeanUtils.copyProperties(professional, professionalInputDto);
//    professionalInputDto.setMaxWage(666666);
//    professionalInputDto.setCountry("China");
//    professional.setCountry("China");
//    professional.setMaxWage(666666);
//
//    when(professionalService.updateProfessional(professionalInputDto, 1L))
//            .thenReturn(professional);
//
//    ObjectMapper mapper = new ObjectMapper();
//    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//    String requestJson = ow.writeValueAsString(professionalInputDto);
//
//    mockMvc
//            .perform(put("/v1/professional/1").contentType(APPLICATION_JSON_UTF8)
//                    .content(requestJson))
//            .andExpect(status().isCreated())
//            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("China"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.maxWage").value(666666))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.score").value(6))
//            .andReturn();
//
//    verify(professionalService, times(2)).getProfessionalById(1L);
//    verify(professionalService, times(1)).updateProfessional(professionalInputDto, 1);
//  }
//
//  @Test
//  public void getCandidate_nonExistingId_shouldReturnNotFound() throws Exception {
//    // Given
//    final long badId = 4L;
//    doReturn(Optional.empty()).when(professionalService).getProfessionalById(badId);
//
//    // When
//    final ResultActions result =
//            mockMvc.perform(get("/v1/professional/".concat(Long.toString(badId))));
//
//    // Then
//    result.andExpect(status().isNotFound());
//  }
//
//  @TestConfiguration
//  protected static class Config {
//
//    @Bean
//    public IProfessional candidateService() {
//      return Mockito.mock(IProfessional.class);
//    }
//  }
//}
