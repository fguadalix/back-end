package com.axpe.od.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
class ApiError {

  private final HttpStatus status;
  private final String message;

  ApiError(HttpStatus status, String message) {
    super();
    this.status = status;
    this.message = message;
  }
}
