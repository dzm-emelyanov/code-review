package ru.dc.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {

  @Id
  private Long id;
  private String name;
  private String category;
  private boolean marketplace;

}
