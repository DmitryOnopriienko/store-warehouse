package com.mvc.weblab6.service;

import com.mvc.weblab6.entity.Waybill;

import java.util.List;

public interface WaybillService {
  List<Waybill> getAllWaybills();

  Waybill getById(int id);

  double countTotalPrice(int id);
}
