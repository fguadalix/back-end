package com.axpe.od.exceptions;

import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({EntityNotFoundException.class})
  protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler({MyFileNotFoundException.class})
  protected ResponseEntity<Object> handleMyFileNotFoundException(MyFileNotFoundException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler({FileStorageException.class})
  protected ResponseEntity<Object> handleFileStorageException(FileStorageException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler({FileFormatException.class})
  protected ResponseEntity<Object> handleFileFormatException(FileFormatException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

  @ExceptionHandler({SQLException.class})
  protected ResponseEntity<Object> handleSQLException(SQLException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
