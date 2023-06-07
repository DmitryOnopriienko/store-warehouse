package com.mvc.weblab6.controller;

import com.mvc.weblab6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public String getAllCustomers(Model model) {
    model.addAttribute("customers", customerService.getAllCustomers());
    return "customers";
  }

  @GetMapping("/{id}")
  public String getById(@PathVariable int id, Model model) {
    model.addAttribute("customer", customerService.getById(id));
    model.addAttribute("waybills", customerService.getWaybillsByCustomerId(id));
    return "customer-info";
  }
}
