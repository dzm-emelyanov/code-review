package ru.dc.review.dto;

import lombok.Data;

@Data
public class PopularityDto {

  private Long productId;
  private String popularity;
  private String category;

}
