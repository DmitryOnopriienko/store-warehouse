package com.mvc.weblab6.repository;

import com.mvc.weblab6.entity.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaybillRepository extends JpaRepository<Waybill, Integer> {
}
