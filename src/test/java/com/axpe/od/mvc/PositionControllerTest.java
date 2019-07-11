//package com.axpe.od.mvc;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.axpe.od.controller.PositionController;
//import com.axpe.od.exceptions.ApiExceptionHandler;
//import com.axpe.od.model.Position;
//import com.axpe.od.repository.PositionRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class PositionControllerTest {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @MockBean
//  private PositionRepository repository;
//
//  private Position position;
//
//  @Before
//  public void setup() {
//    // Added so @ControllerAdvice could be added to test exception handling.
//    mockMvc =
//        MockMvcBuilders.standaloneSetup(new PositionController(repository))
//            .setControllerAdvice(new ApiExceptionHandler())
//            .build();
//  }
//
//  @Test
//  public void createAndRetrievePosition() throws Exception {
//
//    mockMvc
//        .perform(get("/v1/position/1"))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(APPLICATION_JSON_UTF8))
//        .andExpect(MockMvcResultMatchers.jsonPath("$.manager").value("francisco"))
//        .andExpect(MockMvcResultMatchers.jsonPath("$.client").value("isban"))
//        .andExpect(MockMvcResultMatchers.jsonPath("$.company").value("axpe"))
//        .andReturn();
//  }
//  //
//  //  @Test
//  //  public void getPosition_nonExistingId_shouldReturnNotFound() throws Exception {
//  //
//  //    // Given
//  //    final long badId = 4L;
//  //    doReturn(Optional.empty()).when(posicionService).getPositionById(badId);
//  //
//  //    // When
//  //    final ResultActions result =
//  // mockMvc.perform(get("/v1/position/".concat(Long.toString(badId))));
//  //
//  //    // Then
//  //    result.andExpect(status().isNotFound());
//  //  }
//  //
//  //  @Test
//  //  public void createAndUpdateposicion() throws Exception {
//  //
//  //    when(posicionService.getPositionById(1L)).thenReturn(Optional.of(positionDto));
//  //    mockMvc
//  //        .perform(get("/v1/position/1"))
//  //        .andExpect(status().isOk())
//  //        .andExpect(content().contentType(APPLICATION_JSON_UTF8))
//  //        .andExpect(MockMvcResultMatchers.jsonPath("$.manager").value("francisco"))
//  //        .andExpect(MockMvcResultMatchers.jsonPath("$.client").value("isban"))
//  //        .andExpect(MockMvcResultMatchers.jsonPath("$.company").value("axpe"))
//  //        .andReturn();
//  //
//  //    PositionDto positionInputDto = new PositionDto();
//  //    BeanUtils.copyProperties(positionDto, positionInputDto);
//  //    positionInputDto.setManager("carlos");
//  //    positionInputDto.setClient("bbva");
//  //    positionDto.setManager("carlos");
//  //    positionDto.setClient("bbva");
//  //
//  //
//  //    ObjectMapper mapper = new ObjectMapper();
//  //    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//  //    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//  //    String requestJson = ow.writeValueAsString(positionInputDto);
//  //
//  //    mockMvc
//  //        .perform(put("/v1/position/1").contentType(APPLICATION_JSON_UTF8).content(requestJson))
//  //        .andExpect(status().isCreated())
//  //        .andExpect(content().contentType(APPLICATION_JSON_UTF8))
//  //        .andExpect(MockMvcResultMatchers.jsonPath("$.manager").value("carlos"))
//  //        .andExpect(MockMvcResultMatchers.jsonPath("$.client").value("bbva"))
//  //        .andExpect(MockMvcResultMatchers.jsonPath("$.company").value("axpe"))
//  //        .andReturn();
//  //
//  //  }
//}
