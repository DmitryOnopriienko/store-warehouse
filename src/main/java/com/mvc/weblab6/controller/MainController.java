package com.mvc.weblab6.controller;

import com.mvc.weblab6.entity.Customer;
import com.mvc.weblab6.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

  @Autowired
  CustomerRepository customerRepository;

  @GetMapping("/")
  public String hello() {
    customerRepository.save(new Customer("John", "Doe", "johndoe@gmail.com"));
    return "Hello, world!";
  }

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

}
