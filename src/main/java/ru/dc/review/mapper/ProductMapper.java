package ru.dc.review.mapper;

import java.math.BigDecimal;
import ru.dc.review.dto.PopularityDto;
import ru.dc.review.dto.ProductDto;
import ru.dc.review.entity.Product;

public class ProductMapper {

  public ProductDto toProductDto(Product product, PopularityDto popularity, BigDecimal price) {
    return ProductDto.builder()
        .id(product.getId())
        .name(product.getName())
        .category(product.getCategory())
        .popularityFactor(popularity.getPopularity())
        .price(price)
        .build();
  }

}
