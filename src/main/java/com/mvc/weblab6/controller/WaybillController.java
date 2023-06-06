package com.mvc.weblab6.controller;

import com.mvc.weblab6.entity.Waybill;
import com.mvc.weblab6.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/waybills")
public class WaybillController {

  private final WaybillService waybillService;

  @Autowired
  public WaybillController(WaybillService waybillService) {
    this.waybillService = waybillService;
  }

  @GetMapping
  public List<Waybill> getAllWaybills() {
    return waybillService.getAllWaybills();
  }

  @GetMapping("/{id}")
  public Waybill getWaybillById(@PathVariable int id) {
    return waybillService.getById(id);
  }
}
