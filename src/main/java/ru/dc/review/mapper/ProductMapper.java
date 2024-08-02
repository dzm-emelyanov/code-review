package ru.dc.review.mapper;

import ru.dc.review.dto.PopularityDto;
import ru.dc.review.dto.ProductDto;
import ru.dc.review.entity.Product;

public class ProductMapper {

  public ProductDto toProductDto(Product product, PopularityDto popularity) {
    return ProductDto.builder()
        .id(product.getId())
        .name(product.getName())
        .category(product.getCategory())
        .popularityFactor(popularity.getPopularity())
        .build();
  }

}
