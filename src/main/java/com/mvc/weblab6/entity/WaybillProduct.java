package com.mvc.weblab6.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "waybill_has_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaybillProduct {
  @Id
  @ManyToOne(optional = false)
  @JoinColumn(name = "waybill_id", nullable = false)
  @JsonBackReference
  private Waybill waybill;

  @Id
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  private int quantity;
}
