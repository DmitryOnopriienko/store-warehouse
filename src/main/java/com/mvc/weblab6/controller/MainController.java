package com.mvc.weblab6.controller;

import com.mvc.weblab6.exception.NotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {
  @GetMapping("/")
  public String hello(HttpServletResponse response) {
    try {
      response.sendRedirect("/waybills");
    } catch (IOException e) {
      e.printStackTrace();
      }
    throw new NotFoundException("Page '/waybills' not found");
  }
}
