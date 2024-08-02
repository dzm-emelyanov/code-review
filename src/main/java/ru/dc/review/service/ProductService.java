package ru.dc.review.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.dc.review.cache.PriceCacheManager;
import ru.dc.review.client.IntegrationClient;
import ru.dc.review.dto.ProductDto;
import ru.dc.review.mapper.ProductMapper;
import ru.dc.review.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final IntegrationClient integrationClient;
  private final PriceCacheManager priceCacheManager;

  private ProductMapper productMapper = new ProductMapper();


  public List<ProductDto> getProducts(int page, int size) {
    val productsPage = productRepository.findAll(PageRequest.of(page, size));
    val products = productsPage.getContent();

    return products.stream().map(product -> {
      val id = product.getId();
      val price = priceCacheManager.getProductPrice(id);
      val popularity = integrationClient.getPopularityById(product.getId());
      return productMapper.toProductDto(product, popularity, price);
    }).toList();

  }

}
