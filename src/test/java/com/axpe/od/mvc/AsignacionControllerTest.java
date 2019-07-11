// package com.axpe.od.mvc;
//
// import com.axpe.od.controller.AsignacionController;
// import com.axpe.od.dto.AsignacionDto;
// import com.axpe.od.exceptions.ApiExceptionHandler;
// import com.axpe.od.model.Assignation;
// import com.axpe.od.model.Professional;
// import com.axpe.od.model.Position;
// import com.axpe.od.dao.IAsignacion;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.ObjectWriter;
// import com.fasterxml.jackson.databind.SerializationFeature;
// import lombok.extern.slf4j.Slf4j;
// import org.junit.Before;
// import org.junit.FixMethodOrder;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.junit.runners.MethodSorters;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.TestConfiguration;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Import;
// import org.springframework.test.annotation.DirtiesContext;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.ResultActions;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
// import java.util.Optional;
//
// import static org.mockito.Mockito.*;
// import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
// @RunWith(SpringRunner.class)
// @ContextConfiguration(classes = {AsignacionController.class})
// @Import(AsignacionControllerTest.Config.class)
// @FixMethodOrder(MethodSorters.JVM)
// @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
// @Slf4j
// public class AsignacionControllerTest {
//
//  @Autowired private IAsignacion asignacionService;
//
//  @Autowired private AsignacionController asignacionController;
//
//  private MockMvc mockMvc;
//
//  @Before
//  public void setUp() {
//    mockMvc =
//        MockMvcBuilders.standaloneSetup(asignacionController)
//            .setControllerAdvice(new ApiExceptionHandler())
//            .build();
//  }
//
//  @Test
//  public void createAndRetrieveAsignacion() throws Exception {
//
//    AsignacionDto asignacion = new AsignacionDto(1L, 1L, 1L, "test asignacion");
//
//    when(asignacionService.getAsignacionById(1L)).thenReturn(Optional.of(asignacion));
//
//    mockMvc
//        .perform(get("/v1/asignacion/1"))
//        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8))
//        .andExpect(jsonPath("$.comments").value("test asignacion"))
//        .andReturn();
//
//    verify(asignacionService, times(1)).getAsignacionById(1L);
//  }
//
//  @Test
//  public void createAndUpdateAsignacion() throws Exception {
//
//    Assignation asignacion = new Assignation();
//    asignacion.setAsignacion_id(1L);
//    asignacion.setProfessional(new Professional());
//    asignacion.setPosition(new Position());
//    asignacion.setComments("test asignacion");
//
//    AsignacionDto asignacionDto = new AsignacionDto(1L, 1L, 1L, "test asignacion");
//
//    when(asignacionService.getAsignacionById(1L)).thenReturn(Optional.of(asignacionDto));
//
//    mockMvc
//        .perform(get("/v1/asignacion/1"))
//        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8))
//        .andExpect(jsonPath("$.comments").value("test asignacion"))
//        .andReturn();
//
//    asignacionDto.setComments("modificado");
//    when(asignacionService.addAsignacion(asignacion)).thenReturn(asignacionDto);
//
//    ObjectMapper mapper = new ObjectMapper();
//    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//    String requestJson = ow.writeValueAsString(asignacion);
//
//    mockMvc
//        .perform(put("/v1/asignacion/").contentType(APPLICATION_JSON_UTF8).content(requestJson))
//        .andExpect(MockMvcResultMatchers.status().isCreated())
//        .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8))
//        .andExpect(jsonPath("$.comments").value("modificado"))
//        .andReturn();
//
//    verify(asignacionService, Mockito.times(2)).getAsignacionById(1L);
//    verify(asignacionService, Mockito.times(1)).addAsignacion(asignacion);
//  }
//
//  @Test
//  public void getAsignacion_nonExistingId_shouldReturnNotFound() throws Exception {
//    // Given
//    final long badId = 4L;
//    doReturn(Optional.empty()).when(asignacionService).getAsignacionById(badId);
//
//    // When
//    final ResultActions result =
//        mockMvc.perform(get("/v1/asignacion/".concat(Long.toString(badId))));
//
//    // Then
//    result.andExpect(MockMvcResultMatchers.status().isNotFound());
//  }
//
//  @TestConfiguration
//  protected static class Config {
//
//    @Bean
//    public IAsignacion asignacionService() {
//      return Mockito.mock(IAsignacion.class);
//    }
//  }
// }
