package com.mvc.weblab6.service;

import com.mvc.weblab6.entity.Product;

import java.util.List;

public interface ProductService {
  List<Product> getAllProducts();

  Product getById(int id);
}
