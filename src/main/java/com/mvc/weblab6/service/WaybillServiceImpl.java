package com.mvc.weblab6.service;

import com.mvc.weblab6.entity.Waybill;
import com.mvc.weblab6.entity.WaybillProduct;
import com.mvc.weblab6.exception.NotFoundException;
import com.mvc.weblab6.repository.WaybillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaybillServiceImpl implements WaybillService {

  private final WaybillRepository waybillRepository;

  @Autowired
  public WaybillServiceImpl(WaybillRepository waybillRepository) {
    this.waybillRepository = waybillRepository;
  }

  @Override
  public List<Waybill> getAllWaybills() {
    return waybillRepository.findAll();
  }

  @Override
  public Waybill getById(int id) {
    return waybillRepository.findById(id).orElseThrow(() ->
            new NotFoundException("Waybill %d not found".formatted(id)));
  }

  @Override
  public double countTotalPrice(int id) {
    Waybill waybill = waybillRepository.findById(id).orElseThrow(() ->
            new NotFoundException("Waybill %d not found".formatted(id)));
    double totalPrice = 0;
    for (int i = 0; i < waybill.getProducts().size(); i++) {
      WaybillProduct waybillProduct = waybill.getProducts().get(i);
      totalPrice += waybillProduct.getProduct().getPrice() * waybillProduct.getQuantity();
    }
    return totalPrice;
  }
}
