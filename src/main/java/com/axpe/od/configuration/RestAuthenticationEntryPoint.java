package com.axpe.od.configuration;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {


	/****
	 * * @author Axpe
	 * 
	 *  Configurar los servicios de autenticacion.
	 *
	 */

	
  @Override
  public void commence(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final AuthenticationException authException) throws IOException {

    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
        "Unauthorized");
  }
}
