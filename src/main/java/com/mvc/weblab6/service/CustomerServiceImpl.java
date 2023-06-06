package com.mvc.weblab6.service;

import com.mvc.weblab6.entity.Customer;
import com.mvc.weblab6.exception.NotFoundException;
import com.mvc.weblab6.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getById(int id) {
    return customerRepository.findById(id).orElseThrow(() ->
            new NotFoundException("Customer %d not found".formatted(id)));
  }
}
