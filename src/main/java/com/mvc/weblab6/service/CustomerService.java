package com.mvc.weblab6.service;

import com.mvc.weblab6.entity.Customer;
import com.mvc.weblab6.entity.Waybill;

import java.util.List;

public interface CustomerService {
  List<Customer> getAllCustomers();

  Customer getById(int id);

  List<Waybill> getWaybillsByCustomerId(int id);
}
