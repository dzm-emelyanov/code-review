package ru.dc.review.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.dc.review.client.IntegrationClient;
import ru.dc.review.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class IntegrationService {

  private final ProductRepository productRepository;
  private final IntegrationClient integrationClient;

  @PostConstruct
  void init() {
    loadData();
  }


  public void loadData() {
    val products = productRepository.findAll();
    val popularities = integrationClient.getPopularities();

    for (val product : products) {
      if (product.isMarketplace()) {

        for (val popularity : popularities) {

          if (product.getId().equals(popularity.getProductId())) {
            product.setCategory(popularity.getCategory());
            productRepository.save(product);
          }
        }
      }
    }
  }

}
