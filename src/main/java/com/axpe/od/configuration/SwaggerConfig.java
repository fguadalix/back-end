package com.axpe.od.configuration;

import static springfox.documentation.builders.PathSelectors.any;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.ResourceSupport;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


// cong de usuario para LDAP
  @Bean
  public Docket api() {

    SecurityReference securityReference = SecurityReference.builder()
        .reference("basicAuth")
        .scopes(new AuthorizationScope[0])
        .build();
    // ArrayList<>(1) inicializa a 1
    ArrayList<SecurityReference> reference = new ArrayList<>(1);
    reference.add(securityReference);

    ArrayList<SecurityContext> securityContexts = new ArrayList<>(1);
    securityContexts.add(SecurityContext.builder().securityReferences(reference).build());

    ArrayList<SecurityScheme> auth = new ArrayList<>(1);
    auth.add(new BasicAuth("basicAuth"));

    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.axpe.od.controller"))
        .paths(any())
        .build()
        .securitySchemes(auth)
        .securityContexts(securityContexts)
        .alternateTypeRules(AlternateTypeRules.newRule(ResourceSupport.class, Object.class));
  }
}
