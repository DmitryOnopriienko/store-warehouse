package com.mvc.weblab6.controller;

import com.mvc.weblab6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public String getAllProducts(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    return "products";
  }

  @GetMapping("/{id}")
  public String getProductById(@PathVariable int id, Model model) {
    model.addAttribute("product", productService.getById(id));
    return "product-info";
  }
}
