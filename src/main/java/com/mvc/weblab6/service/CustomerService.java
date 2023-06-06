package com.mvc.weblab6.service;

import com.mvc.weblab6.entity.Customer;

import java.util.List;

public interface CustomerService {
  public List<Customer> getAllCustomers();

  Customer getById(int id);
}
