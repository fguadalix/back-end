package com.axpe.od.controller;

import com.axpe.od.model.User;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@Slf4j
public class UserController {

  private AuthenticationManager am;

  @Autowired
  public UserController(AuthenticationManager am) {
    this.am = am;
  }

  @PostMapping("/perform_login")
  public Principal login(@RequestBody User user, HttpServletRequest req) {

    try {
      UsernamePasswordAuthenticationToken authReq
          = new UsernamePasswordAuthenticationToken(user.getUser(),
          user.getPass());
      Authentication auth = am.authenticate(authReq);
      SecurityContext sc = SecurityContextHolder.getContext();
      sc.setAuthentication(auth);
      HttpSession session = req.getSession(true);
      session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
      log.info("Successfully authenticated. Security context contains: " +
          SecurityContextHolder.getContext().getAuthentication());
      return SecurityContextHolder.getContext().getAuthentication();
    } catch (AuthenticationException e) {
      log.info("Authentication failed: " + e.getMessage());
      return null;
    }
  }

  @GetMapping(value = "/perform_logout")
  public void logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    response.setStatus(HttpServletResponse.SC_OK);
  }
}
