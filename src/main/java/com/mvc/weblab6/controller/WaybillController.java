package com.mvc.weblab6.controller;

import com.mvc.weblab6.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/waybills")
public class WaybillController {

  private final WaybillService waybillService;

  @Autowired
  public WaybillController(WaybillService waybillService) {
    this.waybillService = waybillService;
  }

  @GetMapping
  public String getAllWaybills(Model model) {
    model.addAttribute("waybills", waybillService.getAllWaybills());
    return "waybills";
  }

  @GetMapping("/{id}")
  public String getWaybillById(@PathVariable int id, Model model) {
    model.addAttribute("waybill", waybillService.getById(id));
    return "waybill-info";
  }
}
