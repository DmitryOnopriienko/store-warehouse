package com.mvc.weblab6.controller;

import com.mvc.weblab6.entity.Customer;
import com.mvc.weblab6.entity.Waybill;
import com.mvc.weblab6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/{id}")
  public Customer getById(@PathVariable int id) {
    return customerService.getById(id);
  }

  @GetMapping("/{id}/waybills")
  public List<Waybill> getWaybillsByCustomerId(@PathVariable int id) {
    return customerService.getWaybillsByCustomerId(id);
  }
}
