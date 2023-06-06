package com.mvc.weblab6.service;

import com.mvc.weblab6.entity.Product;
import com.mvc.weblab6.exception.NotFoundException;
import com.mvc.weblab6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getById(int id) {
    return productRepository.findById(id).orElseThrow(() ->
            new NotFoundException("Product %d not found".formatted(id)));
  }
}
