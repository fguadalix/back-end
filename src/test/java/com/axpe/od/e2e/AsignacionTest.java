// package com.axpe.od.e2e;
//
// import com.axpe.od.model.Assignation;
// import com.axpe.od.model.Position;
// import com.axpe.od.model.Professional;
// import lombok.extern.slf4j.Slf4j;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.transaction.annotation.EnableTransactionManagement;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.client.RestTemplate;
//
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.core.IsEqual.equalTo;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
// @Slf4j
// @EnableJpaRepositories(basePackages = "com.axpe.od.repository")
// @EnableTransactionManagement
// @Transactional
// public class AsignacionTest {
//
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${server.port}")
//    private String port;
//
//    @Test
//    public void e2e_caseMtoN_OK() {
//
//        // get position
//
//        ResponseEntity<Position> position = restTemplate.getForEntity("http://localhost:" + port +
// "/v1/position/1", Position.class);
//        assertThat(position.getStatusCode(), equalTo(HttpStatus.OK));
//
//        // get professional
//
//        ResponseEntity<Professional> professional = restTemplate.getForEntity("http://localhost:"
// +
// port
// + "/v1/professional/1", Professional.class);
//        assertThat(professional.getStatusCode(), equalTo(HttpStatus.OK));
//
//        // post asignacion
//
//        Assignation asignacion = new Assignation();
//        asignacion.setProfessional(professional.getBody());
//        asignacion.setPosition(position.getBody());
//        asignacion.setInfo("test asignacion");
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        RestTemplate restTemplate = new RestTemplate();
//
//        ResponseEntity<Assignation> response = restTemplate.postForEntity("http://localhost:" +
// port + "/v1/asignacion", asignacion, Assignation.class);
//        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
//        assertEquals(response.getBody().getComments(), "test asignacion");
//
//        // get asignacion
//        ResponseEntity<Assignation> asignacionResponseEntity =
// restTemplate.getForEntity("http://localhost:" + port + "/v1/asignacion/" +
// response.getBody().getAsignacion_id(), Assignation.class);
//        assertThat(asignacionResponseEntity.getStatusCode(), equalTo(HttpStatus.OK));
//        assertEquals(asignacionResponseEntity.getBody().getComments(), "test asignacion");
//    }
// }
