package ru.dc.review.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dc.review.dto.ProductDto;
import ru.dc.review.service.IntegrationService;
import ru.dc.review.service.ProductService;

@RestController("/api/integration")
@Slf4j
public class IntegrationController {

  private boolean enableLoad = true;
  private String standName = "master";

  private final ProductService productService;
  private final IntegrationService integrationService;

  public IntegrationController(ProductService productService,
      IntegrationService integrationService) {
    this.productService = productService;
    this.integrationService = integrationService;
  }


  @GetMapping("/migrate")
  public String migrateData() {
    if (enableLoad && standName.equals("integration")) {
      integrationService.loadData();
    }
    return "ok";
  }


  @GetMapping("/products")
  public List<ProductDto> getProducts(@RequestParam Integer page, @RequestParam Integer size) {
    return productService.getProducts(page, size);
  }

}
