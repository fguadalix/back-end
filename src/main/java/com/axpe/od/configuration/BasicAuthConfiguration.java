package com.axpe.od.configuration;

import java.util.Arrays;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/****
 * * @author Axpe
 * 
 *  Esta clase se encarga de la seguridad , LDAP, SPRING SECURITY...
 *
 */

@Configuration
@EnableWebSecurity
@Slf4j
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {

  @Value("${ad.domain}")
  private String AD_DOMAIN;

  @Value("${ad.url}")
  private String AD_URL;

  @Autowired
  private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
        "/configuration/**", "/swagger-ui.html", "/webjars/**");
  }

  /****
   * * @author Axpe
   * 
   *  Method:  Asigna roles para las peticion HTTP
   *
   */
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.csrf().disable(); //FIXME add csrf protection
    http.cors();

    http
        //.anonymous().disable()
        .exceptionHandling()
        .authenticationEntryPoint(restAuthenticationEntryPoint)
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/perform_login").permitAll()
        .antMatchers(HttpMethod.GET, "/perform_logout").authenticated()
        // position
        .antMatchers(HttpMethod.POST, "/v1/position/**").hasAnyAuthority("OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.GET, "/v1/position/**").hasAnyAuthority("OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.PUT, "/v1/position/**").hasAnyAuthority("OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.DELETE, "/v1/position/**").hasAnyAuthority("OD_Admin")
//        // profesional
        .antMatchers(HttpMethod.POST, "/v1/professional/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.GET, "/v1/professional/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin", "Gitlab_users")
        .antMatchers(HttpMethod.PUT, "/v1/professional/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.DELETE, "/v1/professional/**").hasAnyAuthority("OD_Admin")
//        // assignation
        .antMatchers(HttpMethod.POST, "/v1/assignation/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.GET, "/v1/assignation/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.PUT, "/v1/assignation/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.DELETE, "/v1/assignation/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
//        // contact
        .antMatchers(HttpMethod.POST, "/v1/professional/*/contact/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.GET, "/v1/professional/*/contact/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.PUT, "/v1/professional/*/contact/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.DELETE, "/v1/professional/*/contact/**").hasAnyAuthority("OD_Admin")
//        // files
        .antMatchers(HttpMethod.POST, "/v1/uploadFile/professional/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.GET, "/v1/downloadFile/professional/*/fileId/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
//        // keywords
        .antMatchers(HttpMethod.POST, "/v1/keyword/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.GET, "/v1/keyword/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.PUT, "/v1/keyword/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.DELETE, "/v1/keyword/**").hasAnyAuthority("OD_Admin")
//        // workExperience
        .antMatchers(HttpMethod.POST, "/v1/professional/*/workExperience/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.GET, "/v1/professional/*/workExperience/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.PUT, "/v1/professional/*/workExperience/**")
        .hasAnyAuthority("OD_Tecnico", "OD_MANAGER", "OD_Admin")
        .antMatchers(HttpMethod.DELETE, "/v1/professional/*/workExperience/**")
        .hasAnyAuthority("OD_Admin")
        //.anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
        .logout()
        .logoutUrl("perform_logout")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID").permitAll().clearAuthentication(true)
        .permitAll();
//        .and()
//        .logout()
//        .logoutUrl("/logout")
//        //.logoutSuccessUrl("/login")
//

  }

  /****
   * * @author Axpe
   * 
   *   Method:  Conexion Autenticacion del LDAP 
   *
   *  Nota Bea : mirar esto  AD_DOMAIN, AD_URL , XX param  para que la autenticacion vaya mejor, esta relacionado cn LDAP
   */

  @Bean
  public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
    ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(
        AD_DOMAIN, AD_URL);
    provider.setConvertSubErrorCodesToExceptions(true);
    provider.setUseAuthenticationRequestCredentials(true);

    return provider;
  }

  
  @Bean
  public AuthenticationManager authenticationManager() {
    return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
  }

/*Este metodo no se utiliza ?? no veo su uso..
 * se debe  invocar en el metedo Configure */
  
  @Bean
  public PasswordEncoder passwordEncoder() {

    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  /****
   * * @author Axpe
   * 
   *   Method: Conf para securIzar las peticiones HTTP mediante CORS
   *
   * 
   */ 
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Collections.singletonList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
    configuration.setAllowedHeaders(
        Arrays.asList("authorization", "content-type", "xsrf-token", "Cache-Control",
            "responseType"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
