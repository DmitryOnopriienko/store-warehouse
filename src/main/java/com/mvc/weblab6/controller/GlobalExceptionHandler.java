package com.mvc.weblab6.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mvc.weblab6.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  protected @ResponseBody ErrorResponse handleNotFound(NotFoundException e) {
    return new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            e.getMessage());
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonInclude(JsonInclude.Include.NON_NULL)
  static class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private List<String> errors;

    public ErrorResponse(int status, String error, String message) {
      this.status = status;
      this.error = error;
      this.message = message;
    }

    public ErrorResponse(int status, String message, List<String> errors) {
      this.status = status;
      this.message = message;
      this.errors = errors;
    }
  }
}
